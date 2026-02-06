package GUI;

import Logica.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 *
 * @author nasry
 */
public class VentanaTablero extends JFrame {
 
    public VentanaTablero(Jugador j1, Jugador j2) {
        setTitle("Duelo Pokémon - Tablero");
        setSize(800, 850);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel(new GridLayout(2, 1)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(59, 76, 202));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        top.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblTurno = new JLabel("", SwingConstants.CENTER);
        lblTurno.setFont(new Font("Verdana", Font.BOLD, 18));
        lblTurno.setForeground(new Color(255, 222, 0));

        JLabel lblPuntaje = new JLabel("", SwingConstants.CENTER);
        lblPuntaje.setFont(new Font("Verdana", Font.PLAIN, 14));
        lblPuntaje.setForeground(Color.WHITE);

        top.add(lblTurno);
        top.add(lblPuntaje);
        add(top, BorderLayout.NORTH);

        JuegoMemoria juego = new JuegoMemoria(j1,j2,lblTurno,lblPuntaje,this);


        JPanel tablero = new JPanel(new GridLayout(6, 6, 8, 8)) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon fondo = new ImageIcon(getClass().getResource("/Imagenes/pF2.jpeg"));
                g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        tablero.setBorder(new EmptyBorder(20, 20, 20, 20));

        for (Carta c : juego.getTablero().getCartas()) {
            JButton b = new JButton();
            b.setOpaque(true);
            b.setContentAreaFilled(true);
            b.setBackground(new Color(240, 240, 240));
            b.setFocusPainted(false);
            b.setBorder(BorderFactory.createLineBorder(new Color(204, 0, 0), 3));
            b.setCursor(new Cursor(Cursor.HAND_CURSOR));
            
            b.addActionListener(e -> juego.seleccionarCarta(c, b));
            tablero.add(b);
        }

        add(tablero, BorderLayout.CENTER);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}