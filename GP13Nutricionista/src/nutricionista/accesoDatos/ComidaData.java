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

    public Comida modificarComida(int idComida, String nombreComida, String tipoComida, Double cantidadCalorias, String detalle) {
        String query = "UPDATE `comida` SET `nombre_comida` = ?, `calorias_por_porcion` = ?, `tipo_comida` = ?, `detalle` = ? WHERE `cod_comida` = ?";
        Comida comida = null;

        try {
            PreparedStatement ps = conection.prepareStatement(query);
            ps.setString(1, nombreComida);
            ps.setDouble(2, cantidadCalorias);
            ps.setString(3, tipoComida);
            ps.setString(4, detalle);
            ps.setInt(5, idComida);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            if (rowsAffected > 0) {
                comida = new Comida();
                String selectQuery = "SELECT * FROM `comida` WHERE `cod_comida` = ?";
                PreparedStatement selectPs = conection.prepareStatement(selectQuery);
                selectPs.setInt(1, idComida);
                ResultSet res = selectPs.executeQuery();

                if (res.next()) {
                    comida.setIdComida(res.getInt("cod_comida"));
                    comida.setNomComida(res.getString("nombre_comida"));
                    comida.setCaloriasPor100Grm(res.getDouble("calorias_por_porcion"));
                    comida.setDetalle(res.getString("detalle"));
                    comida.setTipo(res.getString("tipo_comida"));

                    String ingredientesQuery
                            = "SELECT * FROM `comida_tiene_ingredientes` cti "
                            + "JOIN ingredientes i ON i.id_ingrediente = cti.id_ingrediente "
                            + "WHERE `cti.cod_comida` = ?";
                    PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                    psAux.setInt(1, idComida);
                    ResultSet resAux = psAux.executeQuery();

                    List<Ingrediente> ingredientesList = new ArrayList<>();
                    while (resAux.next()) {
                        Ingrediente ingrediente = new Ingrediente();
                        ingrediente.setIdIngrediente(resAux.getInt("id_ingrediente"));
                        ingrediente.setNomIngrediente(resAux.getString("nombre_ingrediente"));
                        ingredientesList.add(ingrediente);
                    }
                    comida.setIngredientes(ingredientesList);

                    resAux.close();
                    psAux.close();
                }
                res.close();
                selectPs.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Comida (modificarComida): " + ex.getMessage());
        }

        return comida;
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
        String query = "INSERT INTO `comida_tiene_ingredientes` VALUES (`id_comida` = ? AND `id_ingrediente` = ?)";
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
}
