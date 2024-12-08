/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

import java.util.Date;

/**
 *
 * @author gouff
 */
public class HistorialDto {

    private int id;
    private String nombreDieta;
    private String nombrePaciente;
    private Boolean alcanzoPesoBuscado;
    private Date fechaInicio;
    private Date fechaFin;
    private Double pesoInicial;
    private Double pesoFinal;
    private Double totalCaloriasDieta;
    private Double pesoBuscado;
    private String estado;

    public HistorialDto() {
    }

    public HistorialDto(int id, String nombreDieta, String nombrePaciente, Boolean alcanzoPesoBuscado, Date fechaInicio, Date fechaFin, Double pesoInicial, Double pesoFinal, Double totalCaloriasDieta, Double pesoBuscado, String estado) {
        this.id = id;
        this.nombreDieta = nombreDieta;
        this.nombrePaciente = nombrePaciente;
        this.alcanzoPesoBuscado = alcanzoPesoBuscado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCaloriasDieta = totalCaloriasDieta;
        this.pesoBuscado = pesoBuscado;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreDieta() {
        return nombreDieta;
    }

    public void setNombreDieta(String nombreDieta) {
        this.nombreDieta = nombreDieta;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Boolean getAlcanzoPesoBuscado() {
        return alcanzoPesoBuscado;
    }

    public void setAlcanzoPesoBuscado(Boolean alcanzoPesoBuscado) {
        this.alcanzoPesoBuscado = alcanzoPesoBuscado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Double getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Double pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public Double getPesoFinal() {
        return pesoFinal;
    }

    public void setPesoFinal(Double pesoFinal) {
        this.pesoFinal = pesoFinal;
    }

    public Double getTotalCaloriasDieta() {
        return totalCaloriasDieta;
    }

    public void setTotalCaloriasDieta(Double totalCaloriasDieta) {
        this.totalCaloriasDieta = totalCaloriasDieta;
    }

    public Double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(Double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
