/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;

import GUI.PantallaInicio;
import GUI.VentanaTablero;
import Interfaces.IJuego;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

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
    private JFrame ventana;


    public JuegoMemoria(Jugador j1, Jugador j2,
                    JLabel lblTurno, JLabel lblPuntaje,
                    JFrame ventana) {
    this.j1 = j1;
    this.j2 = j2;
    this.turno = j1;
    this.lblTurno = lblTurno;
    this.lblPuntaje = lblPuntaje;
    this.ventana = ventana;
    tablero = new Tablero();
    actualizarInfo();
}


    public void iniciarJuego() {
        actualizarInfo();
    }

    public void seleccionarCarta(Carta c, JButton b) {
        if (c.estaDescubierta()) {
            return;
        }

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

    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    panel.setBackground(new Color(59, 76, 202));
    panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

    JLabel lblTitulo = new JLabel();
    lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
    lblTitulo.setFont(new Font("Verdana", Font.BOLD, 26));
    lblTitulo.setForeground(new Color(255, 222, 0));

    JLabel lblResultado = new JLabel();
    lblResultado.setAlignmentX(Component.CENTER_ALIGNMENT);
    lblResultado.setFont(new Font("Verdana", Font.PLAIN, 16));
    lblResultado.setForeground(Color.WHITE);

    if (j1.getAciertos() > j2.getAciertos()) {
        lblTitulo.setText("VICTORIA DE " + j1.getNombre().toUpperCase());
    } else if (j2.getAciertos() > j1.getAciertos()) {
        lblTitulo.setText("VICTORIA DE " + j2.getNombre().toUpperCase());
    } else {
        lblTitulo.setText("EMPATE");
    }

    lblResultado.setText(
            j1.getNombre() + ": " + j1.getAciertos() +
            "  |  " +
            j2.getNombre() + ": " + j2.getAciertos()
    );

    JOptionPane.showMessageDialog(
            ventana,
            panel,
            "Resultado del Duelo",
            JOptionPane.PLAIN_MESSAGE
    );

    ventana.dispose();

    new GUI.PantallaInicio();
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
