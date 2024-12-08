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

    public List<Ingrediente> listaDeIngredientes() {
        ArrayList<Ingrediente> ingredientes = new ArrayList();
        String sql = "SELECT * FROM `ingredientes`";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(rs.getInt("id_ingrediente"));
                ingrediente.setNomIngrediente(rs.getString("nombre_ingrediente"));
                ingredientes.add(ingrediente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }
        return ingredientes;
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
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (cargarIngrediente)");
        }
    }

    public void modificarIngrediente(Ingrediente ingrediente) {

        int contador = 0;
        List<Ingrediente> ingredientes = ingredientesUsados();
        for (int i = 0; i < ingredientes.size(); i++) {
            if (ingredientes.get(i).getIdIngrediente() == ingrediente.getIdIngrediente()) {
                contador++;
            }
        }
        if (contador == 0) {
            String modificar = "UPDATE `ingredientes` SET `nombre_ingrediente`= ? WHERE `id_ingrediente`= ?";
            try {
                PreparedStatement ps = conection.prepareStatement(modificar);
                ps.setString(1, ingrediente.getNomIngrediente());
                ps.setInt(2, ingrediente.getIdIngrediente());
                int update = ps.executeUpdate();
                if (update == 1) {
                    JOptionPane.showMessageDialog(null, "Ingrediente modificado con exito");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (modificarIngrediente)");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede modificar un ingrediente que este actualmente asignado a una comida");
        }
    }

    public void eliminarIngrediente(Ingrediente ingrediente) {
        int contador = 0;
        String eliminar = "DELETE FROM `ingredientes` WHERE `id_ingrediente`= ?";
        List<Ingrediente> ingredientes = ingredientesUsados();
        for (int i = 0; i < ingredientes.size(); i++) {
            if (ingredientes.get(i).getIdIngrediente() == ingrediente.getIdIngrediente()) {
                contador++;
            }
        }
        if (contador == 0) {
            try {
                PreparedStatement ps = conection.prepareStatement(eliminar);
                ps.setInt(1, ingrediente.getIdIngrediente());
                int res = ps.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Ingrediente eliminado con éxito");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Ingredientes (eliminarIngrediente)");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un ingrediente que este actualmente asignado a una comida");
        }
    }

    private List<Ingrediente> ingredientesUsados() {
        ArrayList<Ingrediente> ingredientes = new ArrayList();
        String mostrarTodo = "SELECT * FROM `comida_tiene_ingredientes`";

        try {
            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ingrediente ingrediente = new Ingrediente();
                ingrediente.setIdIngrediente(res.getInt("id_ingrediente"));
                ingredientes.add(ingrediente);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla comida_tiene_ingredientes");
        }
        return ingredientes;
    }

    public List<Ingrediente> ingredientesDeUnaComida(int idComida) {
        List<Ingrediente> ingredientes = new ArrayList<>();
        if (idComida > 0) {
            String ingredientesQuery
                    = "SELECT * FROM `comida_tiene_ingredientes` cti "
                    + "JOIN ingredientes i on i.id_ingrediente = cti.id_ingrediente "
                    + "WHERE cti.id_comida = ?";
            try {
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, idComida);
                ResultSet resAux = psAux.executeQuery();
                while (resAux.next()) {
                    Ingrediente ingrediente = new Ingrediente();
                    ingrediente.setIdIngrediente(resAux.getInt("id_ingrediente"));
                    ingrediente.setNomIngrediente(resAux.getString("nombre_ingrediente"));
                    ingredientes.add(ingrediente);
                }
                psAux.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
            }
        }
        return ingredientes;
    }
    
    public Boolean checkSiIngredienteEstaONo(String name) {
    String sql = "SELECT COUNT(*) AS total FROM ingredientes WHERE LOWER(nombre_ingrediente) = LOWER(?)";
    try {
        PreparedStatement ps = conection.prepareStatement(sql);
        ps.setString(1,name); 
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            int count = rs.getInt("total"); 
            ps.close();
            return count > 0; 
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes: " + ex.getMessage());
    }

        return false;
    }

}
