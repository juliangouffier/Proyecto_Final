/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

import java.util.Objects;

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

    public Ingrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
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
        return nomIngrediente;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.idIngrediente;
        hash = 89 * hash + Objects.hashCode(this.nomIngrediente);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ingrediente other = (Ingrediente) obj;
        if (this.idIngrediente != other.idIngrediente) {
            return false;
        }
        return Objects.equals(this.nomIngrediente, other.nomIngrediente);
    }
    
    
}
