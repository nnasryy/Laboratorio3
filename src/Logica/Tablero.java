/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Interfaces.ITablero;

import javax.swing.*;
import java.util.*;

/**
 *
 * @author Nathan
 */
public class Tablero implements ITablero {

    private ArrayList<Carta> cartas;

    public Tablero() {
        cartas = new ArrayList<>();
        crearTablero();
    }

    @Override
    public void crearTablero() {
        try {
            cartas.clear();

            for (int i = 1; i <= 18; i++) {
                ImageIcon img = new ImageIcon(
                        getClass().getResource("/Imagenes/p" + i + ".png")
                );

                cartas.add(new CartaPokemon("P" + i, img));
                cartas.add(new CartaPokemon("P" + i, img));
            }

            Collections.shuffle(cartas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Error cargando imágenes"
            );
        }
    }


    public void mezclarCartas() {
        Collections.shuffle(cartas);
    }

    public boolean quedanParejas() {
        for (Carta c : cartas) {
            if (!c.estaDescubierta()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Carta> getCartas() {
        return cartas;
    }
}

 