/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
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
}
