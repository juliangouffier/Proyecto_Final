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
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.entidades.Comida;
import nutricionista.entidades.Ingrediente;

/**
 *
 * @author gouff
 */
public class ComidaData {

    private Connection conection = null;

    public ComidaData() {
        conection = Conexion.getConexion();
    }

    public List<Comida> listaDeComidas() {
        ArrayList<Comida> comidas = new ArrayList();
        String sql = "SELECT * FROM `comida`";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("cod_comida"));
                comida.setNomComida(rs.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(rs.getDouble("calorias_por_porcion"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setTipo(rs.getString("tipo_comida"));
                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes i on i.id_ingrediente = cti.id_ingrediente "
                        + "WHERE cti.id_comida = ?";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }
        return comidas;
    }

    public void cargarComida(Comida comida) {
        String cargar = "INSERT INTO `comida`(`nombre_comida`, `calorias_por_porcion`, `tipo_comida`, `detalle`) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = conection.prepareStatement(cargar, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, comida.getNomComida());
            ps.setDouble(2, comida.getCaloriasPor100Grm());
            ps.setString(3, comida.getTipo());
            ps.setString(4, comida.getDetalle());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                comida.setIdComida(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Comida cargada con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (cargarComida)");
        }
    }

    public void modificarComida(int idComida, String nombreComida, String tipoComida, Double cantidadCalorias, String detalle) {
        String query = "UPDATE `comida` SET `nombre_comida` = ?, `calorias_por_porcion` = ?, `tipo_comida` = ?, `detalle` = ? WHERE `cod_comida` = ?";
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, nombreComida);
            ps.setDouble(2, cantidadCalorias);
            ps.setString(3, tipoComida);
            ps.setString(4, detalle);
            ps.setInt(5, idComida);
            int update = ps.executeUpdate();
            if (update == 1) {
                JOptionPane.showMessageDialog(null, "Comida modificada con exito");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (modificarComida)");
        }
    }
    
    public void eliminarComida(Comida comida) {
        int contador = 0;
        int contador2 = 0;
        String eliminar = "DELETE FROM `comida` WHERE `cod_comida`= ?";
        List<Comida> comidas = comidasUsadasEnRenglon();
        for (int i = 0; i < comidas.size(); i++) {
            if (comidas.get(i).getIdComida() == comida.getIdComida()) {
                contador++;
            }
        }
        List<Comida> comidas2 = ingredientesUsadosEnComida();
        for (int i = 0; i < comidas2.size(); i++) {
            if (comidas2.get(i).getIdComida() == comida.getIdComida()) {
                contador2++;
            }
        }
        if (contador == 0 && contador2 == 0) {
            try {
                PreparedStatement ps = conection.prepareStatement(eliminar);
                ps.setInt(1, comida.getIdComida());
                int res = ps.executeUpdate();
                if (res == 1) {
                    JOptionPane.showMessageDialog(null, "Ingrediente eliminado con éxito");
                }
                ps.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (eliminarComida)");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede eliminar un comida que este actualmente asignado a un renglon e ingrediente");
        }
    }
    
    public List<Comida> buscarPorNombre(String nombre) {
        String query = "SELECT * FROM `comida` WHERE `nombre_comida` LIKE ? ";

        ArrayList<Comida> comidas = new ArrayList();

        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, ("%" + nombre + "%"));
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));

                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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

    public List<Comida> buscarPorIngredientes(List<Integer> ingredientes) {
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

            while (res.next()) {

                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));

                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorIngredientes)");
        }

        return comidas;
    }

    public List<Comida> buscarPorCalorias(Double calorias) {
        String query = "SELECT * FROM `comida` WHERE `calorias_por_porcion` = ? ";

        ArrayList<Comida> comidas = new ArrayList();

        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setDouble(1, calorias);
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));

                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorCalorias)");
        }

        return comidas;
    }

    public List<Comida> buscarPorTipo(String tipoComida) {
        String query = "SELECT * FROM `comida` WHERE `tipo_comida` = ? ";

        ArrayList<Comida> comidas = new ArrayList();

        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, (tipoComida));
            ResultSet res = ps.executeQuery();

            while (res.next()) {

                Comida comida = new Comida();
                comida.setIdComida(res.getInt("cod_comida"));
                comida.setNomComida(res.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                comida.setDetalle(res.getString("detalle"));
                comida.setTipo(res.getString("tipo_comida"));

                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes in on in.id_ingrediente = cti.id_ingrediente"
                        + "WHERE `cti.cod_comida` = ? ";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (buscarPorTipo)");
        }

        return comidas;
    }

    public void eliminarIngredienteDeComida(int comidaId, int ingredienteId) {
        String query = "DELETE FROM `comida_tiene_ingredientes` WHERE `id_comida` = ? AND `id_ingrediente` = ?";
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setInt(1, comidaId);
            ps.setInt(2, ingredienteId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (eliminarIngredienteDeComida)");
        }
    }

    public void agregarIngredienteAComida(int comidaId, int ingredienteId) {
        String query = "INSERT INTO `comida_tiene_ingredientes` VALUES (?,?)";
        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setInt(1, comidaId);
            ps.setInt(2, ingredienteId);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (agregarIngredienteAComida)");
        }
    }
    
    private List<Comida> comidasUsadasEnRenglon() {
        ArrayList<Comida> comidas = new ArrayList();
        String mostrarTodo = "SELECT * FROM `renglon`";

        try {
            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Comida comida = new Comida();
                comida.setIdComida(res.getInt("id_comida"));
                comidas.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla renglon");
        }
        return comidas;
    }
    
    private List<Comida> ingredientesUsadosEnComida() {
        ArrayList<Comida> comidas = new ArrayList();
        String mostrarTodo = "SELECT * FROM `comida_tiene_ingredientes`";

        try {
            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Comida comida = new Comida();
                comida.setIdComida(res.getInt("id_comida"));
                comidas.add(comida);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla comida_tiene_ingredientes");
        }
        return comidas;
    }
    
    public List<Comida> listaDeComidasMenoresACantidadCalorias(Double cantidadCalorias) {
        ArrayList<Comida> comidas = new ArrayList();
        String sql = "SELECT * FROM `comida` WHERE calorias_por_porcion <= ?";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setDouble(1, cantidadCalorias);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Comida comida = new Comida();
                comida.setIdComida(rs.getInt("cod_comida"));
                comida.setNomComida(rs.getString("nombre_comida"));
                comida.setCaloriasPor100Grm(rs.getDouble("calorias_por_porcion"));
                comida.setDetalle(rs.getString("detalle"));
                comida.setTipo(rs.getString("tipo_comida"));
                String ingredientesQuery
                        = "SELECT * FROM `comida_tiene_ingredientes` cti "
                        + "JOIN ingredientes i on i.id_ingrediente = cti.id_ingrediente "
                        + "WHERE cti.id_comida = ?";
                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, (comida.getIdComida()));
                ResultSet resAux = psAux.executeQuery();

                List<Ingrediente> ingredientesList = new ArrayList<>();
                while (resAux.next()) {
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
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla ingredientes");
        }
        return comidas;
    }
    
    public Boolean validoComidaExistente(String nombreComida, Double calorias, String tipo) {
    String sql = "SELECT 1 FROM `comida` WHERE LOWER(nombre_comida) = LOWER(?) AND calorias_por_porcion = ? AND LOWER(tipo_comida) = LOWER(?) LIMIT 1";

        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setString(1, nombreComida);
            ps.setDouble(2, calorias);
            ps.setString(3, tipo);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                rs.close();
                ps.close();
                return true;
            }

            rs.close();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla comida");
        }

        return false;
    }

}
