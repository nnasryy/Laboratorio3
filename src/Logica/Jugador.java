/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

/**
 *
 * @author jerem
 */

public class Jugador {

    private String nombre;
    private int aciertos;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.aciertos = 0;
    }

    public void sumarAcierto() {
        aciertos++;
    }

    public String getNombre() {
        return nombre;
    }

    public int getAciertos() {
        return aciertos;
    }
}