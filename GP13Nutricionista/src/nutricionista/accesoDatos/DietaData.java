package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.entidades.Dieta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author valer
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
            ps.setInt(7, dieta.getTotalCalorias());
            ps.setInt(8,dieta.getIdDieta());
            int filas_actualiz=ps.executeUpdate();
            
            if(filas_actualiz == 1){
                JOptionPane.showMessageDialog(null, "Dieta modificada con exito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla dieta");
        }
    }
     public void cargarDieta(Dieta dieta){
        String sql="INSERT INTO dieta (nombre,fecha_inicio, fecha_fin, id_paciente,peso_inicial,peso_final,total_calorias)"
                + " VALUES(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps= conection.prepareStatement(sql);
            ps.setString(1, dieta.getNombre());
            ps.setDate(2, (Date) dieta.getFechaInicio());
            ps.setDate(3, (Date)dieta.getFechaFin());
            ps.setInt(4, dieta.getPaciente().getIdPaciente());
            ps.setDouble(5, dieta.getPesoInicial());
            ps.setDouble(6, dieta.getPesoFinal());
            ps.setInt(7, dieta.getTotalCalorias());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showInternalMessageDialog(null, "error al acceder a la tabla dieta");
        }
        
    }
}
