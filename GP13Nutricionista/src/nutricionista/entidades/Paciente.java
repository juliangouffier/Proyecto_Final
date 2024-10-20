/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutricionista.entidades;

/**
 *
 * @author valer
 */
public class Paciente {
    private int idPaciente;
    private String nombreCompleto;
    private int edad;
    private double altura;
    private double pesoActual;
    private double pesoBuscado;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nombreCompleto, int edad, double altura, double pesoActual, double pesoBuscado) {
        this.idPaciente = idPaciente;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public Paciente(String nombreCompleto, int edad, double altura, double pesoActual, double pesoBuscado) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.altura = altura;
        this.pesoActual = pesoActual;
        this.pesoBuscado = pesoBuscado;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPesoActual() {
        return pesoActual;
    }

    public void setPesoActual(double pesoActual) {
        this.pesoActual = pesoActual;
    }

    public double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nombreCompleto=" + nombreCompleto + ", edad=" + edad + ", altura=" + altura + ", pesoActual=" + pesoActual + ", pesoBuscado=" + pesoBuscado + '}';
    }
    
    
   
}
