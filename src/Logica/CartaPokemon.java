/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import javax.swing.*;

/**
 *
 * @author jerem
 */

public class CartaPokemon extends Carta {

    public CartaPokemon(String id, ImageIcon imagen) {
        super(id, imagen);
    }

    @Override
    public void mostrar(JButton boton) {
        boton.setIcon(imagen);
        descubierta = true;
    }

    @Override
    public void ocultar(JButton boton) {
        boton.setIcon(null);
        descubierta = false;
    }
}
