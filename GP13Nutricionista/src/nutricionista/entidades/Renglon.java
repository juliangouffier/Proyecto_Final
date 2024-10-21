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
    private int subTotalCalorias;

    public Renglon() {
    }

    public Renglon(int numRenglon, Comida comida, double cantGrm, int subTotalCalorias) {
        this.numRenglon = numRenglon;
        this.comida = comida;
        this.cantGrm = cantGrm;
        this.subTotalCalorias = subTotalCalorias;
    }
    
    
}
