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
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Ingrediente;

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
        String query = "SELECT * FROM `comida` WHERE `nombre_comida` LIKE ? ";
        
         ArrayList<Comida> comidas = new ArrayList();
        
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, ("%"+nombre+"%"));
            ResultSet res = ps.executeQuery();
       
            
            while(res.next()){
                
                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));
                
                String ingredientesQuery = 
                        "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux  = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();
                
                List<Ingrediente> ingredientesList = new ArrayList<>();
                while(resAux.next()){
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setIdIngrediente(resAux.getInt("id_ingrediente"));
                    ingrediente.setNomIngrediente(resAux.getString("nombre_ingrediente"));
                    ingredientesList.add(ingrediente);
                }
                comida.setIngredientes(ingredientesList);
                comidas.add(comida);
                
         
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorNombre)");
        }
    
        return comidas;
    }
    

    public List<Comida> buscarPorIngredientes(List<Integer> ingredientes){
        String query = "SELECT * FROM `comida_tiene_ingredientes` cti "
                 + "JOIN ingredientes in ON in.id_ingrediente = cti.id_ingrediente "
                 + "WHERE in.id_ingrediente IN (" 
                 + String.join(",", Collections.nCopies(ingredientes.size(), "?")) 
                 + ")";
        
         ArrayList<Comida> comidas = new ArrayList();
        
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            for (int i = 0; i < ingredientes.size(); i++) {
            ps.setInt(i + 1, ingredientes.get(i));
            }
            ResultSet res = ps.executeQuery();
       
            
            while(res.next()){
                
                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));
                
                String ingredientesQuery = 
                        "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux  = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();
                
                List<Ingrediente> ingredientesList = new ArrayList<>();
                while(resAux.next()){
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setIdIngrediente(resAux.getInt("id_ingrediente"));
                    ingrediente.setNomIngrediente(resAux.getString("nombre_ingrediente"));
                    ingredientesList.add(ingrediente);
                }
                comida.setIngredientes(ingredientesList);
                comidas.add(comida);
                
         
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorNombre)");
        }
    
        return comidas;
    }
}
