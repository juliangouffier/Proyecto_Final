/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nutricionista.entidades;

/**
 *
 * @author Hernan
 */
public class Menu {
    private int idMenu;
    private int dia;
    private Renglon reg;
    private boolean estado;

    public Menu() {
    }

    public Menu(int dia, Renglon reg, boolean estado) {
        this.dia = dia;
        this.reg = reg;
        this.estado = estado;
    }

    public Menu(int idMenu, int dia, Renglon reg, boolean estado) {
        this.idMenu = idMenu;
        this.dia = dia;
        this.reg = reg;
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

    public Renglon getReg() {
        return reg;
    }

    public void setReg(Renglon reg) {
        this.reg = reg;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Menu{" + "idMenu=" + idMenu + ", dia=" + dia + ", reg=" + reg + ", estado=" + estado + '}';
    }
    
}
