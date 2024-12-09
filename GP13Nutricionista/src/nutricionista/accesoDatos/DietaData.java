package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Dieta;
import nutricionista.entidades.Ingrediente;
import nutricionista.entidades.Paciente;



/**
 *
 * @author Gouffier
 */
public class DietaData {
    private Connection conection =null;
    
    public DietaData(){
        conection= Conexion.getConexion();
    }
    
    public void modificarDieta(Dieta dieta){
        String modificar = "UPDATE `dieta` SET `nombre`=?, `fecha_inicio`=?, `fecha_fin`=?, `id_paciente`=?, `peso_inicial`=?, `peso_final`=?, `total_calorias`=?, `peso_buscado` = ? WHERE `id_dieta`=?";
        
        try {
            PreparedStatement ps= conection.prepareStatement(modificar);
            
            ps.setString(1, dieta.getNombre());
            ps.setDate(2, new java.sql.Date(dieta.getFechaInicio().getTime()));
            ps.setDate(3, new java.sql.Date(dieta.getFechaFin().getTime()));
            ps.setInt(4, dieta.getPaciente().getIdPaciente());
            ps.setDouble(5, dieta.getPesoInicial());
            if (dieta.getPesoFinal() != null) {
                ps.setDouble(6, dieta.getPesoFinal());
            } else {
                ps.setNull(6, java.sql.Types.DOUBLE);
            }
            if (dieta.getTotalCalorias() != null) {
                ps.setDouble(7, dieta.getTotalCalorias());
            } else {
                ps.setNull(7, java.sql.Types.DOUBLE);
            }
            ps.setDouble(8,dieta.getPesoBuscado());
            ps.setInt(9,dieta.getIdDieta());
            int filas_actualiz=ps.executeUpdate();
            
            if(filas_actualiz == 1){
                JOptionPane.showMessageDialog(null, "Dieta modificada con exito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta");
        }
    }
     public Dieta cargarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombre, fecha_inicio, fecha_fin, id_paciente, peso_inicial, total_calorias, peso_buscado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            java.util.Date fechaInicioUtil = dieta.getFechaInicio();
            java.sql.Date fechaSqlInicio = new java.sql.Date(fechaInicioUtil.getTime());

            java.util.Date fechaFinUtil = dieta.getFechaFin();
            java.sql.Date fechaSqlFin = new java.sql.Date(fechaFinUtil.getTime());
            PreparedStatement ps = conection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, dieta.getNombre());
            ps.setDate(2, fechaSqlInicio);
            ps.setDate(3, fechaSqlFin);
            ps.setInt(4, dieta.getPaciente().getIdPaciente());
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getTotalCalorias());
            ps.setDouble(7, dieta.getPesoBuscado());
            ps.executeUpdate();

            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) { 
                dieta.setIdDieta(res.getInt(1)); 
            } else {
                System.out.println("No se generó ningún ID para la dieta.");
            }
            res.close();
            ps.close();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta: " + ex.getMessage());
        }

        return dieta;
}

     
     public void cargarDietaTieneMenues(List<Integer> menues, Integer dietaId){
         try {
            String sql = "INSERT INTO dieta_tiene_menu (id_menu, id_dieta, estado) VALUES (?, ?, ?)";
            PreparedStatement ps = conection.prepareStatement(sql);
                for (Integer menuId : menues) {
                    ps.setInt(1, menuId);
                    ps.setInt(2, dietaId); 
                    ps.setInt(3, 1);  

                    ps.executeUpdate();
                }
                System.out.println("Menú cargado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar los renglones en la tabla dietatieneMenu.");
        }
    }
     
     public Dieta pacientePoseeDieta(int pacienteId){
         try {
             Dieta dieta = null;
             String query = "SELECT * FROM dieta WHERE id_paciente = ? AND CURRENT_TIMESTAMP BETWEEN fecha_inicio AND fecha_fin ";
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setInt(1, pacienteId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dieta = new Dieta();
                dieta.setIdDieta(rs.getInt("id_dieta"));
                dieta.setFechaInicio(rs.getDate("fecha_inicio"));
                dieta.setFechaFin(rs.getDate("fecha_fin"));
                dieta.setNombre(rs.getString("nombre"));
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(rs.getInt("id_paciente"));
                dieta.setPaciente(paciente);
                dieta.setPesoInicial(rs.getDouble("peso_inicial"));
                dieta.setTotalCalorias(rs.getDouble("total_calorias"));
                dieta.setPesoBuscado(rs.getDouble("peso_buscado"));
            }
            ps.close();
            return dieta;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
     
     public Double recalculoTotalCaloriasDieta(Integer dieta){
         String sql = "UPDATE dieta SET total_calorias = (SELECT SUM(m.calorias_menu) FROM dieta_tiene_menu dtm "
                 + "JOIN menu m on m.cod_menu = dtm.id_menu WHERE dtm.id_dieta = ? AND dtm.estado = 1 ) WHERE id_dieta = ?";
         
         String sql2 = "SELECT total_calorias FROM dieta WHERE id_dieta = ?";
         
         try {
             
            PreparedStatement ps1 = conection.prepareStatement(sql);
            ps1.setInt(1, dieta);
            ps1.setInt(2, dieta);
            int rs1 = ps1.executeUpdate();
             
            if(rs1 != 0){
                PreparedStatement ps2 = conection.prepareStatement(sql2);
                ps2.setInt(1, dieta);
                ResultSet rs2 = ps2.executeQuery();
                if(rs2.first()){
                    return rs2.getDouble("total_calorias");
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return null;
     }
     
     public Integer validarSiExisteDietaActual(Integer pacienteId) {
        String sql = "SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END FROM dieta WHERE id_paciente = ? AND CURRENT_TIMESTAMP BETWEEN fecha_inicio AND fecha_fin";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, pacienteId);
            ResultSet rs1 = ps.executeQuery();

            if (rs1.next()) { 
                return rs1.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
