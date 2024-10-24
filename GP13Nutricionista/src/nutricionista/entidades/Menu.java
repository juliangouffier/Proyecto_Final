/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

import java.util.List;

/**
 *
 * @author Hernan
 */
public class Menu {
    private int idMenu;
    private int dia;
    private List<Renglon> renglones;
    private boolean estado;

    public Menu() {
    }

    public Menu(int dia, List<Renglon> renglones, boolean estado) {
        this.dia = dia;
        this.renglones = renglones;
        this.estado = estado;
    }

    public Menu(int idMenu, int dia, List<Renglon> renglones, boolean estado) {
        this.idMenu = idMenu;
        this.dia = dia;
        this.renglones = renglones;
        this.estado = estado;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List<Renglon> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<Renglon> renglones) {
        this.renglones = renglones;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", dia=" + dia + ", renglones=" + renglones + ", estado=" + estado + '}';
    }
    
}
