package GUI;

import Logica.*;
import javax.swing.*;
import java.awt.*;

/**
 *
 * @author nasry
 */

public class VentanaTablero extends JFrame {

    public VentanaTablero(Jugador j1, Jugador j2) {

        setTitle("Juego de Memoria");
        setSize(700, 700);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel lblTurno = new JLabel();
        JLabel lblPuntaje = new JLabel();

        JPanel top = new JPanel(new GridLayout(2, 1));
        top.add(lblTurno);
        top.add(lblPuntaje);

        add(top, BorderLayout.NORTH);

        JuegoMemoria juego =
                new JuegoMemoria(j1, j2, lblTurno, lblPuntaje);

        JPanel tablero = new JPanel(new GridLayout(6, 6));
        for (Carta c : juego.getTablero().getCartas()) {
            JButton b = new JButton();
            b.addActionListener(e ->
                    juego.seleccionarCarta(c, b));
            tablero.add(b);
        }

        add(tablero, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
} 
