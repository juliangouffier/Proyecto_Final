/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

/**
 *
 * @author Hernan
 */
public class Comida {
    private int idComida;
    private String nomComida;
    private int caloriasPor100Grm;
    private String tipo;
    private String detalle;
    private Ingrediente ingredientes;

    public Comida() {
    }

    public Comida(String nomComida, int caloriasPor100Grm, String tipo, String detalle, Ingrediente ingredientes) {
        this.nomComida = nomComida;
        this.caloriasPor100Grm = caloriasPor100Grm;
        this.tipo = tipo;
        this.detalle = detalle;
        this.ingredientes = ingredientes;
    }

    public Comida(int idComida, String nomComida, int caloriasPor100Grm, String tipo, String detalle, Ingrediente ingredientes) {
        this.idComida = idComida;
        this.nomComida = nomComida;
        this.caloriasPor100Grm = caloriasPor100Grm;
        this.tipo = tipo;
        this.detalle = detalle;
        this.ingredientes = ingredientes;
    }

    public int getIdComida() {
        return idComida;
    }

    public void setIdComida(int idComida) {
        this.idComida = idComida;
    }

    public String getNomComida() {
        return nomComida;
    }

    public void setNomComida(String nomComida) {
        this.nomComida = nomComida;
    }

    public int getCaloriasPor100Grm() {
        return caloriasPor100Grm;
    }

    public void setCaloriasPor100Grm(int caloriasPor100Grm) {
        this.caloriasPor100Grm = caloriasPor100Grm;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Ingrediente getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Ingrediente ingredientes) {
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Comida{" + "idComida=" + idComida + ", nomComida=" + nomComida + ", caloriasPor100Grm=" + caloriasPor100Grm + ", tipo=" + tipo + ", detalle=" + detalle + ", ingredientes=" + ingredientes + '}';
    }
    
    
}
