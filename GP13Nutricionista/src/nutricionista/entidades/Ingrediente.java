/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

/**
 *
 * @author Hernan
 */
public class Ingrediente {
    private int idIngrediente;
    private String nomIngrediente;

    public Ingrediente() {
    }

    public Ingrediente(String nomIngrediente) {
        this.nomIngrediente = nomIngrediente;
    }

    public Ingrediente(int idIngrediente, String nomIngrediente) {
        this.idIngrediente = idIngrediente;
        this.nomIngrediente = nomIngrediente;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getNomIngrediente() {
        return nomIngrediente;
    }

    public void setNomIngrediente(String nomIngrediente) {
        this.nomIngrediente = nomIngrediente;
    }

    @Override
    public String toString() {
        return "Ingrediente{" + "idIngrediente=" + idIngrediente + ", nomIngrediente=" + nomIngrediente + '}';
    }
    
    
}
