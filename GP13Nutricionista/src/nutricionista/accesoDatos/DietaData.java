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
        String modificar=" UPDATE `dieta` SET `nombre`=?,`fecha_inicio`=?,`fecha_fin`=?,`id_paciente`=?',`peso_inicial`=?',`peso_final`=?,`total_calorias`=? WHERE `id_dieta`=?";
        
        try {
            PreparedStatement ps= conection.prepareStatement(modificar);
            
            ps.setString(1, dieta.getNombre());
            ps.setDate(2, (Date) dieta.getFechaInicio());
            ps.setDate(3, (Date) dieta.getFechaFin());
            ps.setInt(4, dieta.getPaciente().getIdPaciente());
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setDouble(7, dieta.getTotalCalorias());
            ps.setInt(8,dieta.getIdDieta());
            int filas_actualiz=ps.executeUpdate();
            
            if(filas_actualiz == 1){
                JOptionPane.showMessageDialog(null, "Dieta modificada con exito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta");
        }
    }
     public Dieta cargarDieta(Dieta dieta) {
        String sql = "INSERT INTO dieta (nombre, fecha_inicio, fecha_fin, id_paciente, peso_inicial, total_calorias) VALUES (?, ?, ?, ?, ?, ?)";

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
                dieta.setPesoInicial(rs.getDouble("peso_inicial"));
                dieta.setTotalCalorias(rs.getDouble("total_calorias"));
            }
            ps.close();
            return dieta;
         } catch (Exception e) {
             e.printStackTrace();
             return null;
         }
     }
}
