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
        mezclarCartas();
    }

    @Override
    public void crearTablero() {
        try {
            cartas.clear();
            ArrayList<Carta> base = new ArrayList<>();

            // 1. Cargar SIEMPRE las 12 imágenes p1–p12
            for (int i = 1; i <= 12; i++) {
                ImageIcon img = new ImageIcon(
                        getClass().getResource("/Imagenes/p" + i + ".png")
                );
                base.add(new CartaPokemon("P" + i, img));
            }

            // 2. Agregar un PAR fijo de cada imagen (24 cartas)
            for (Carta c : base) {
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
            }

            // 3. Calcular cuántas cartas faltan (12)
            int faltantes = 36 - cartas.size(); // = 12

            Random r = new Random();

            // 4. Agregar las cartas faltantes SIEMPRE EN PARES
            while (faltantes > 0) {
                Carta c = base.get(r.nextInt(base.size()));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
                cartas.add(new CartaPokemon(c.getId(), c.imagen));
                faltantes -= 2;
            }

            // 5. Mezclar todo
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
