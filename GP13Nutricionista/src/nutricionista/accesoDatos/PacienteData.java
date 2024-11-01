/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import nutricionista.entidades.Paciente;

/**
 *
 * @author crist
 */
public class PacienteData {
    
    private Connection conection = null;
    
    
    public PacienteData(){
    
        conection = Conexion.getConexion();
    
    }
    
    //Métodos
    
    public void actualizarPesoAct(double peso_act, int id){
        String modificar = "UPDATE `paciente` SET `peso_actual`= ? WHERE `id_paciente`= ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(modificar);
            
            ps.setDouble(1, peso_act);
            ps.setInt(2, id);
            
            int filas_actualizadas = ps.executeUpdate();
            
            if(filas_actualizadas == 1){
                JOptionPane.showMessageDialog(null, "Peso Actual modificado con éxito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (actualizarPesoAct)");
        }
    }
    
    public void cambiarPesoDeseado(double peso_deseado, int id){
        String modificar = "UPDATE `paciente` SET `peso_buscado`= ? WHERE `id_paciente`= ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(modificar);
            
            ps.setDouble(1, peso_deseado);
            ps.setInt(2, id);
            
            int filas_actualizadas = ps.executeUpdate();
            
            if(filas_actualizadas == 1){
                JOptionPane.showMessageDialog(null, "Peso Buscado modificado con éxito");
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (cambiarPesoDeseado)");
        }
    
    }
    
    public List<Paciente> listarPacientes(){
        
        ArrayList<Paciente> pacientes = new ArrayList();
        String mostrarTodo = "SELECT * FROM `paciente`";
        
        try {
            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
            
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(res.getInt("id_paciente"));
                paciente.setNombreCompleto(res.getString("nombre_completo"));
                paciente.setEdad(res.getInt("edad"));
                paciente.setAltura(res.getDouble("altura"));
                paciente.setPesoActual(res.getDouble("peso_actual"));
                paciente.setPesoBuscado(res.getDouble("peso_buscado"));
                
                pacientes.add(paciente);
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (listarPacientes)");
        }
    
        return pacientes;
    }
    
    
    public void cargarPaciente(Paciente paciente){
        
        String cargar = "INSERT INTO `paciente`(`nombre_completo`, `edad`, `altura`, `peso_actual`, `peso_buscado`) "
                + "VALUES (?, ?, ?, ?, ?)";
        
        try {
            PreparedStatement ps = conection.prepareStatement(cargar, Statement.RETURN_GENERATED_KEYS);
            
            ps.setString(1, paciente.getNombreCompleto());
            ps.setInt(2, paciente.getEdad());
            ps.setDouble(3, paciente.getAltura());
            ps.setDouble(4, paciente.getPesoActual());
            ps.setDouble(5, paciente.getPesoBuscado());
            ps.executeUpdate();
            
            ResultSet res = ps.getGeneratedKeys();
            
            if(res.next()){
                paciente.setIdPaciente(res.getInt(1));
                JOptionPane.showMessageDialog(null, "Paciente cargado con éxito");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (cargarPaciente)");
        }
    
    }
    
    
    public void modificarPaciente(Paciente paciente) throws Exception{
        
        String modificar = "UPDATE `paciente` SET `nombre_completo`= ?,`edad`= ?,`altura`= ?,`peso_actual`= ?,`peso_buscado`= ? WHERE `id_paciente`= ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(modificar);
            
            ps.setString(1, paciente.getNombreCompleto());
            ps.setInt(2, paciente.getEdad());
            ps.setDouble(3, paciente.getAltura());
            ps.setDouble(4, paciente.getPesoActual());
            ps.setDouble(5, paciente.getPesoBuscado());
            ps.setInt(6, paciente.getIdPaciente());
            int filas_actualizadas = ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            throw new Exception("Ocurrio un error al modificar el paciente");
        }
    }
    
    
    
    
    public void eliminarPaciente(int id){
        
        String eliminar = "DELETE FROM `paciente` WHERE `id_paciente` = ?";
        
        try {
            PreparedStatement ps = conection.prepareStatement(eliminar);
            
            ps.setInt(1, id);
            
            int res = ps.executeUpdate();
            
            if(res == 1){
                JOptionPane.showMessageDialog(null, "Paciente eliminado con éxito");
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (eliminarPaciente)");
        }
    
    }
    
    
    public List<Paciente> buscarPacientesPorNombre(String nombre){
        ArrayList<Paciente> pacientes = new ArrayList();
        String mostrarTodo = "SELECT * FROM `paciente` WHERE `nombre_completo` LIKE ? ";
        
        try {
            PreparedStatement ps = conection.prepareStatement(mostrarTodo);
            ps.setString(1, nombre);
            ResultSet res = ps.executeQuery();
            
            while(res.next()){
                
                Paciente paciente = new Paciente();
                paciente.setIdPaciente(res.getInt("id_paciente"));
                paciente.setNombreCompleto(res.getString("nombre_completo"));
                paciente.setEdad(res.getInt("edad"));
                paciente.setAltura(res.getDouble("altura"));
                paciente.setPesoActual(res.getDouble("peso_actual"));
                paciente.setPesoBuscado(res.getDouble("peso_buscado"));
                
                pacientes.add(paciente);
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Paciente (buscarPacientesPorNombre)");
        }
    
        return pacientes;
    }
    
    
    
}
