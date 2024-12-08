package nutricionista.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author gouff
 */
public class Dieta {
    
    private int idDieta;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFin;
    private Paciente paciente;
    private Double pesoInicial;
    private Double pesoFinal;
    private Double totalCalorias;
    private List<Menu> menues;
    private Double pesoBuscado;

    public Dieta() {
    }

    public Dieta(int idDieta, String nombre, Date fechaInicio, Date fechaFin, Paciente paciente, Double pesoInicial, Double pesoFinal, Double totalCalorias, List<Menu> menues, Double pesoBuscado) {
        this.idDieta = idDieta;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.paciente = paciente;
        this.pesoInicial = pesoInicial;
        this.pesoFinal = pesoFinal;
        this.totalCalorias = totalCalorias;
        this.menues = menues;
        this.pesoBuscado = pesoBuscado;
    }

    public int getIdDieta() {
        return idDieta;
    }

    public void setIdDieta(int idDieta) {
        this.idDieta = idDieta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
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

    public Double getTotalCalorias() {
        return totalCalorias;
    }

    public void setTotalCalorias(Double totalCalorias) {
        this.totalCalorias = totalCalorias;
    }

    public List<Menu> getMenues() {
        return menues;
    }

    public void setMenues(List<Menu> menues) {
        this.menues = menues;
    }

    public Double getPesoBuscado() {
        return pesoBuscado;
    }

    public void setPesoBuscado(Double pesoBuscado) {
        this.pesoBuscado = pesoBuscado;
    }
}
