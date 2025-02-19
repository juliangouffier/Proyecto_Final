/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Hernan
 */
public class Menu {
    private int idMenu;
    private String dia;
    private List<Renglon> renglones;
    private double caloriasDelMenu;

    public Menu() {
    }

    public Menu(int idMenu) {
        this.idMenu = idMenu;
    }

    public Menu(String dia, List<Renglon> renglones, double caloriasDelMenu) {
        this.dia = dia;
        this.renglones = renglones;
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public Menu(int idMenu, String dia, List<Renglon> renglones, double caloriasDelMenu) {
        this.idMenu = idMenu;
        this.dia = dia;
        this.renglones = renglones;
        this.caloriasDelMenu = caloriasDelMenu;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public List<Renglon> getRenglones() {
        return renglones;
    }

    public void setRenglones(List<Renglon> renglones) {
        this.renglones = renglones;
    }

    public double getCaloriasDelMenu() {
        return caloriasDelMenu;
    }

    public void setCaloriasDelMenu(double caloriasDelMenu) {
        this.caloriasDelMenu = caloriasDelMenu;
    }

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", dia=" + dia + ", renglones=" + renglones + ", caloriasDelMenu=" + caloriasDelMenu + '}';
    }    
}
