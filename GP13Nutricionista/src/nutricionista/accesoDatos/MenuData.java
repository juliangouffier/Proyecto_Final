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
import nutricionista.entidades.Comida;
import nutricionista.entidades.Ingrediente;
import nutricionista.entidades.Menu;
import nutricionista.entidades.Renglon;

/**
 *
 * @author Hernan
 */
public class MenuData {

    private Connection conection = null;

    public MenuData() {
        conection = Conexion.getConexion();
    }

    public Menu cargarMenu(Menu menu) {

        String cargar = "INSERT INTO `menu`(`dia`, `calorias_menu`) VALUES (?,?)";

        try {
            PreparedStatement ps = conection.prepareStatement(cargar, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, menu.getDia());
            ps.setDouble(2, menu.getCaloriasDelMenu());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                menu.setIdMenu(res.getInt(1));
                return menu;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Menu (cargarMenu)");
        }
        return null;
    }
    
    public void agregarRenglon(Menu menu, Renglon renglon){
        menu.getRenglones().add(renglon);
        String cargar = "INSERT INTO `menu_tiene_renglon`(`id_menu`,`id_renglon`,`estado`) VALUES (?,?,?)";
        try {
            PreparedStatement ps = conection.prepareStatement(cargar, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,menu.getIdMenu());
            ps.setInt(2, renglon.getNumRenglon());
            ps.setInt(3, 1);
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();
            if (res.next()) {
                menu.setIdMenu(res.getInt(1));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla `menu_tiene_renglon`");
        }
    }
    
    public double calcularCaloriasDelDia(Menu menu){
        double caloriasDelMenu = 0;
        Renglon renglon = new Renglon();
        for (Renglon renglones : menu.getRenglones()) {
            caloriasDelMenu = caloriasDelMenu + renglon.getSubTotalCalorias();
        }
        return caloriasDelMenu;
    }
    
    public void imprimirMenuDelDia(Menu menu){
        Renglon renglon = new Renglon();
        for (Renglon renglones : menu.getRenglones()) {
            renglon.toString();
        }
    }
    
    public ArrayList<Menu> traerMenuesPorDieta(Integer dietaId){
        ArrayList<Menu> menues = new ArrayList();
        String sql = "SELECT * FROM dieta_tiene_menu dt "
                + "JOIN menu m on m.cod_menu = dt.id_menu "
                + "WHERE dt.id_dieta = ? AND estado = 1";
        try {
            PreparedStatement ps = conection.prepareStatement(sql);
            ps.setInt(1, dietaId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Menu menu = new Menu();
                menu.setIdMenu(rs.getInt("id_menu"));
                menu.setDia(rs.getString("dia"));
                menu.setCaloriasDelMenu(rs.getDouble("calorias_menu"));
                
                String ingredientesQuery = "SELECT r.nro_renglon, r.cantidad_gramos, r.sub_total_calorias, "
                        + "c.cod_comida, c.nombre_comida, c.calorias_por_porcion, c.detalle, c.tipo_comida "
                        + "FROM menu_tiene_renglon mtr "
                        + "JOIN renglon r on r.nro_renglon = mtr.id_renglon "
                        + "JOIN comida c on c.cod_comida = r.id_comida "
                        + "WHERE mtr.id_menu = ? AND mtr.estado = 1";

                PreparedStatement psAux = conection.prepareStatement(ingredientesQuery);
                psAux.setInt(1, menu.getIdMenu());
                ResultSet resAux = psAux.executeQuery();

                List<Renglon> rengloList = new ArrayList<>();
                while (resAux.next()) {
                    Renglon renglon = new Renglon();
                    renglon.setNumRenglon(resAux.getInt("nro_renglon"));
                    renglon.setCantGrm(resAux.getDouble("cantidad_gramos"));
                    renglon.setSubTotalCalorias(resAux.getDouble("sub_total_calorias"));

                    Comida comida = new Comida();
                    comida.setIdComida(resAux.getInt("cod_comida"));
                    comida.setNomComida(resAux.getString("nombre_comida"));
                    comida.setCaloriasPor100Grm(resAux.getDouble("calorias_por_porcion"));
                    comida.setDetalle(resAux.getString("detalle"));
                    comida.setTipo(resAux.getString("tipo_comida"));
                    renglon.setComida(comida);
                    rengloList.add(renglon);
                }
                menu.setRenglones(rengloList);
                menues.add(menu);
            }
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla menues");
        }
        return menues;
    }
}
