/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import nutricionista.entidades.Ingrediente;

/**
 *
 * @author Hernan
 */
public class IngredienteData {

    private Connection conection = null;

    public IngredienteData() {
        conection = Conexion.getConexion();
    }

    public void cargarIngrediente(Ingrediente ingrediente) {

        String cargar = "INSERT INTO `ingredientes`(`nombre_ingrediente`) VALUES (?)";

        try {
            PreparedStatement ps = conection.prepareStatement(cargar, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, ingrediente.getNomIngrediente());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                ingrediente.setIdIngrediente(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Ingrediente cargado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (cargarIngrediente)");
        }
    }

    public void modificarIngrediente(Ingrediente ingrediente) {

        String modificar = "UPDATE `ingredientes` SET `nombre_ingrediente`= ? WHERE `id_ingrediente`= ?";

        try {
            PreparedStatement ps = conection.prepareStatement(modificar);
            ps.setString(1, ingrediente.getNomIngrediente());
            ps.setInt(2, ingrediente.getIdIngrediente());
            int res = ps.executeUpdate();
            if (res == 1) {
                JOptionPane.showMessageDialog(null, "Ingrediente modificado con éxito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (modificarIngrediente)");
        }
    }

//    public void eliminarIngrediente(int id) {
//
//        int contador = 0;
//        String eliminar = "DELETE FROM `ingredientes` WHERE `id_ingrediente`= ?";
//        List<Ingrediente> ingredientes = ingredientesUsados();
//        
//        for (int i = 0; i < ingredientes.size(); i++) {
//            if (ingredientes.get(i).getIdIngrediente() == id) {
//                contador++;
//            }
//        }
//        if (contador == 0) {
//            limpiarComidaIngrediente(id);
//            try {
//                PreparedStatement ps = conection.prepareStatement(eliminar);
//                ps.setInt(1, id);
//                int res = ps.executeUpdate();
//                if (res == 1) {
//                    JOptionPane.showMessageDialog(null, "Ingrediente eliminado con éxito");
//                }
//            } catch (SQLException ex) {
//                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (eliminarIngrediente)");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "No se puede eliminar un ingrediente que este actualmente asignado a una comida");
//        }
//    }
//
//    private void limpiarComidaIngrediente(int id) {
//        
//        String eliminar = "DELETE FROM `comida_tiene_ingredientes` WHERE `id_ingrediente`= ? AND `estado`= 0";
//
//        try {
//            PreparedStatement ps = conection.prepareStatement(eliminar);
//            ps.setInt(1, id);
//            ResultSet res = ps.executeQuery();
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a tabla comida_tiene_ingredientes");
//        }
//    }
//
//    private List<Ingrediente> ingredientesUsados() {
//
//        ArrayList<Ingrediente> ingredientes = new ArrayList();
//        String mostrarTodo = "SELECT * FROM `comida_tiene_ingredientes` WHERE `estado`= 1";
//
//        try {
//            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
//            ResultSet res = ps.executeQuery();
//            while (res.next()) {
//                Ingrediente ingrediente = new Ingrediente();
//                ingrediente.setIdIngrediente(res.getInt("id_ingrediente"));
//                ingredientes.add(ingrediente);
//            }
//            ps.close();
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, "Error al acceder a tabla comida_tiene_ingredientes");
//        }
//        return ingredientes;
//    }
}
