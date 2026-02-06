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
        cartas.clear();
        ArrayList<Carta> base = new ArrayList<>();

        try {
            // 1. Cargar las 12 imágenes fijas p1-p12
            for (int i = 1; i <= 12; i++) {
                ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/p" + i + ".png"));
                base.add(new CartaPokemon("P" + i, img));
            }

            // 2. Crear un par de cada imagen fija → 12 pares = 24 cartas
            for (Carta c : base) {
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
            }

            // 3. Crear 6 pares adicionales aleatorios desde las 12 imágenes → 12 cartas
            Random r = new Random();
            for (int i = 0; i < 6; i++) {
                Carta c = base.get(r.nextInt(base.size()));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
            }

            // 4. Mezclar todas las cartas
            Collections.shuffle(cartas);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error cargando imágenes: " + e.getMessage());
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

 