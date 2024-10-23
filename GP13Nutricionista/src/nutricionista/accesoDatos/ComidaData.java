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
import javax.swing.JOptionPane;
import nutricionista.entidades.Comida;

/**
 *
 * @author gouff
 */
public class ComidaData {
    
     private Connection conection = null;
    
    
    public ComidaData(){
        conection = Conexion.getConexion();
    }
    
    public List<Comida> buscarPorNombre(String nombre){
        String query = "SELECT * FROM `comida` WHERE `nombre_comida` LIKE `%?%` ";
        
         ArrayList<Comida> comidas = new ArrayList();
        
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                
                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));
                
                // TODO traer ingredientes y mapearlos a la comida
                comidas.add(comida);
                
         
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorNombre)");
        }
    
        return comidas;
    }
}
