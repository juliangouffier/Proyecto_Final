/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Ingrediente;
import nutricionista.entidades.Renglon;
import nutricionista.vistas.FormularioRenglon;
import org.mariadb.jdbc.Statement;

/**
 *
 * @author JulianC
 */
public class RenglonData {
     
    private Connection conection = null;
     
    public RenglonData(){
        conection = Conexion.getConexion();
    } 
    
     public void crearRenglon (Renglon renglon){
        
        String cargar = "INSERT INTO `renglon`(`nro_renglon`, `id_comida`, `cantidad_gramos`, `sub_total_calorias`) "
                + "VALUES (?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(cargar, java.sql.Statement.RETURN_GENERATED_KEYS);
            
            ps.setInt(1, renglon.getNumRenglon());
            ps.setInt(2, renglon.getComida().getIdComida());
            ps.setDouble(3, renglon.getCantGrm());
            ps.setDouble(4, renglon.getSubTotalCalorias());
            ps.executeUpdate();
            
            ResultSet res = ps.getGeneratedKeys();
            
            if(res.next()){
                renglon.setNumRenglon(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Renglon cargado con éxito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla renglon (crearRenglon)");
        }
        
        
     }
     
     public void rellenarComboBox (String tabla, String valor, JComboBox combo){
         String sql = "SELECT * FROM "+tabla;
         Statement st;
         try {
             st = (Statement) conection.createStatement();
             ResultSet rs = st.executeQuery(sql);
             while (rs.next()) {                 
                 combo.addItem(rs.getString (valor));
             }
         } catch (SQLException e) {
             JOptionPane.showMessageDialog(null, "Error al cargar CoimboBox"+e.getMessage());
         }
     }
     
     
     public ArrayList<Renglon> traerRenglones(){
         ArrayList<Renglon> renglones = new ArrayList();
        String sql = "SELECT * FROM `renglon` r "
                + "JOIN `comida` c on c.cod_comida = r.id_comida ";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Renglon renglon = new Renglon();
                renglon.setNumRenglon(rs.getInt("nro_renglon"));
                renglon.setCantGrm(rs.getDouble("cantidad_gramos"));
                renglon.setSubTotalCalorias(rs.getDouble("sub_total_calorias"));
                
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("cod_comida"));
                comida.setNomComida(rs.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(rs.getDouble("calorias_por_porcion"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setTipo(rs.getString("tipo_comida"));
                
                renglon.setComida(comida);
                renglones.add(renglon);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }
        return renglones;
     }
     
     public void cargarMenuTieneRenglon(List<Integer> renglones, Integer menuId){
         try {
            String sql = "INSERT INTO menu_tiene_renglon (id_menu, id_renglon, estado) VALUES (?, ?, ?)";
            PreparedStatement ps = conection.prepareStatement(sql);
                for (Integer renglon : renglones) {
                    ps.setInt(1, menuId);
                    ps.setInt(2, renglon); 
                    ps.setInt(3, 1);  

                    ps.executeUpdate();
                }
                System.out.println("Menú cargado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al insertar los renglones en la tabla menu_tiene_renglon.");
        }
    }
     
     public ArrayList<Renglon> traerRenglonesQueNoEstenEnDieta(Integer dietaId){
         ArrayList<Renglon> renglones = new ArrayList();
         String sql = "SELECT DISTINCT * FROM `renglon` r "
           + "JOIN `comida` c ON c.cod_comida = r.id_comida "
           + "WHERE r.nro_renglon NOT IN ( "
           + "   SELECT mtr.id_renglon "
           + "   FROM `dieta_tiene_menu` dtm "
           + "   JOIN `menu_tiene_renglon` mtr ON mtr.id_menu = dtm.id_menu "
           + "   WHERE dtm.id_dieta = ? "
           + ")";   

        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, dietaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Renglon renglon = new Renglon();
                renglon.setNumRenglon(rs.getInt("nro_renglon"));
                renglon.setCantGrm(rs.getDouble("cantidad_gramos"));
                renglon.setSubTotalCalorias(rs.getDouble("sub_total_calorias"));
                
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("cod_comida"));
                comida.setNomComida(rs.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(rs.getDouble("calorias_por_porcion"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setTipo(rs.getString("tipo_comida"));
                
                renglon.setComida(comida);
                renglones.add(renglon);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla traerRenglonesQueNoEstenEnDieta");
        }
        return renglones;
     }
     
     public ArrayList<Renglon> traerRenglonesAsociadosAMenu(Integer menuId){
         ArrayList<Renglon> renglones = new ArrayList();
        String sql = "SELECT * FROM menu_tiene_renglon mtr "
                + "JOIN renglon r on r.nro_renglon = mtr.id_renglon "
                + "JOIN comida c on c.cod_comida = r.id_comida "
                + "WHERE mtr.id_menu = ? AND mtr.estado = 1";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, menuId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Renglon renglon = new Renglon();
                renglon.setNumRenglon(rs.getInt("nro_renglon"));
                renglon.setCantGrm(rs.getDouble("cantidad_gramos"));
                renglon.setSubTotalCalorias(rs.getDouble("sub_total_calorias"));
                
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("cod_comida"));
                comida.setNomComida(rs.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(rs.getDouble("calorias_por_porcion"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setTipo(rs.getString("tipo_comida"));
                
                renglon.setComida(comida);
                renglones.add(renglon);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla menu_tiene_renglon");
        }
        return renglones;
     }
     
}
