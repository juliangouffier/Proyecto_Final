/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gp13nutricionista;

import java.sql.Connection;
import nutricionista.accesoDatos.Conexion;
import nutricionista.accesoDatos.PacienteData;
import nutricionista.entidades.Paciente;

/**
 *
 * @author Hernán Amieva Lopez, Julian Agustin Gouffier, Julian Copete Diez, Valeria Agustina Chica, Cristián Cravero 
 * 
 * GRUPO 13
 * 
 */
public class GP13Nutricionista {

    public static void main(String[] args) {
        
        
        Connection con=Conexion.getConexion();
        
        Paciente paciente1 = new Paciente(1 ,"Cristian Cravero", 23, 1.7, 70.2, 75.0);
        
        PacienteData pacienteData = new PacienteData();
        
        //pacienteData.cargarPaciente(paciente1);
        //pacienteData.modificarPaciente(paciente1);
        
        
        //Se listan todos los pacientes existentes
        System.out.println("Listar pacientes");
        
        for(Paciente pc : pacienteData.listarPacientes()){
            System.out.println("-----");
            System.out.println("Id: "+pc.getIdPaciente());
            System.out.println("Nombre: "+pc.getNombreCompleto());
            System.out.println("Edad: "+pc.getEdad());
            System.out.println("Altura: "+pc.getAltura());
            System.out.println("Peso Actual: "+pc.getPesoActual());
            System.out.println("Peso Buscado: "+pc.getPesoBuscado());
        }
        
        //Modificar peso actual
        pacienteData.actualizarPesoAct(75.0, 1);
        
        //Modificar peso buscado
        pacienteData.cambiarPesoDeseado(75.0, 1);
        
        
        //Se muestra la modificacion
        System.out.println("Listar pacientes");
        
        for(Paciente pc : pacienteData.listarPacientes()){
            System.out.println("-----");
            System.out.println("Id: "+pc.getIdPaciente());
            System.out.println("Nombre: "+pc.getNombreCompleto());
            System.out.println("Edad: "+pc.getEdad());
            System.out.println("Altura: "+pc.getAltura());
            System.out.println("Peso Actual: "+pc.getPesoActual());
            System.out.println("Peso Buscado: "+pc.getPesoBuscado());
        }
        
    }
    
}
