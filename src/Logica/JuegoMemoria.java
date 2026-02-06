/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import Interfaces.IJuego;

import javax.swing.*;
/**
 *
 * @author Nathan
 */
public class JuegoMemoria implements IJuego {

    private Jugador j1, j2;
    private Jugador turno;
    private Carta carta1, carta2;
    private JButton boton1, boton2;
    private JLabel lblTurno, lblPuntaje;
    private Tablero tablero;

    public JuegoMemoria(Jugador j1, Jugador j2,
                        JLabel lblTurno, JLabel lblPuntaje) {
        this.j1 = j1;
        this.j2 = j2;
        this.turno = j1;
        this.lblTurno = lblTurno;
        this.lblPuntaje = lblPuntaje;
        tablero = new Tablero();
        actualizarInfo();
    }

    public void iniciarJuego() {
        actualizarInfo();
    }

    public void seleccionarCarta(Carta c, JButton b) {
        if (c.estaDescubierta()) return;

        c.mostrar(b);

        if (carta1 == null) {
            carta1 = c;
            boton1 = b;
        } else {
            carta2 = c;
            boton2 = b;
            verificarPareja(carta1, carta2);
        }
    }

    public void verificarPareja(Carta c1, Carta c2) {
        Timer t = new Timer(700, e -> {
            if (c1.getId().equals(c2.getId())) {
                turno.sumarAcierto();
            } else {
                c1.ocultar(boton1);
                c2.ocultar(boton2);
                cambiarTurno();
            }

            carta1 = null;
            carta2 = null;
            actualizarInfo();

            if (!tablero.quedanParejas()) {
                finalizarJuego();
            }
        });
        t.setRepeats(false);
        t.start();
    }

    public void cambiarTurno() {
        turno = (turno == j1) ? j2 : j1;
    }

    public void finalizarJuego() {
        String msg;
        if (j1.getAciertos() > j2.getAciertos())
            msg = "Ganador: " + j1.getNombre();
        else if (j2.getAciertos() > j1.getAciertos())
            msg = "Ganador: " + j2.getNombre();
        else
            msg = "Empate";

        JOptionPane.showMessageDialog(null, msg);
    }

    private void actualizarInfo() {
        lblTurno.setText("Turno: " + turno.getNombre());
        lblPuntaje.setText(j1.getNombre() + ": " + j1.getAciertos()
                + " | " + j2.getNombre() + ": " + j2.getAciertos());
    }

    public Tablero getTablero() {
        return tablero;
    }
}

 