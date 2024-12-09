/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

/**
 *
 * @author Hernan
 */
public class Renglon {
    private int numRenglon;
    private Comida comida;
    private double cantGrm;
    private double subTotalCalorias;
    private String estado;

    public Renglon() {
    }

    public Renglon(int numRenglon, Comida comida, double cantGrm, double subTotalCalorias, String estado) {
        this.numRenglon = numRenglon;
        this.comida = comida;
        this.cantGrm = cantGrm;
        this.subTotalCalorias = subTotalCalorias;
        this.estado = estado;
    }

    public int getNumRenglon() {
        return numRenglon;
    }

    public void setNumRenglon(int numRenglon) {
        this.numRenglon = numRenglon;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public double getCantGrm() {
        return cantGrm;
    }

    public void setCantGrm(double cantGrm) {
        this.cantGrm = cantGrm;
    }

    public double getSubTotalCalorias() {
        return subTotalCalorias;
    }

    public void setSubTotalCalorias(double subTotalCalorias) {
        this.subTotalCalorias = subTotalCalorias;
    }

    @Override
    public String toString() {
        return "Renglon{" + "numRenglon=" + numRenglon + ", comida=" + comida + ", cantGrm=" + cantGrm + ", subTotalCalorias=" + subTotalCalorias + '}';
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
