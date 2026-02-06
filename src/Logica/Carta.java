/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author nasry
 */


import javax.swing.*;

public abstract class Carta {

    protected boolean descubierta;
    protected String id;
    protected ImageIcon imagen;

    public Carta(String id, ImageIcon imagen) {
        this.id = id;
        this.imagen = imagen;
        this.descubierta = false;
    }

    public abstract void mostrar(JButton boton);
    public abstract void ocultar(JButton boton);

    public boolean estaDescubierta() {
        return descubierta;
    }

    public String getId() {
        return id;
    }
}