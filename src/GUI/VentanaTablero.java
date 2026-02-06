package GUI;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class VentanaTablero extends JFrame {

    private JuegoMemoria motorJuego;
    private JLabel lblTurno;
    private JLabel lblPuntaje;
    private JPanel panelCartas;

    public VentanaTablero(String nombreJ1, String nombreJ2) {
        
        setTitle("Pokemon Memory Game");
        setSize(800, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        JPanel panelInfo = new JPanel(new GridLayout(2, 1));
        panelInfo.setBackground(Color.WHITE);
        panelInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblTurno = new JLabel("Cargando...", SwingConstants.CENTER);
        lblTurno.setFont(new Font("Arial", Font.BOLD, 20));

        lblPuntaje = new JLabel("Puntaje", SwingConstants.CENTER);
        lblPuntaje.setFont(new Font("Arial", Font.PLAIN, 16));

        panelInfo.add(lblTurno);
        panelInfo.add(lblPuntaje);
        add(panelInfo, BorderLayout.NORTH);


        panelCartas = new JPanel(new GridLayout(6, 6, 8, 8));
        panelCartas.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panelCartas.setBackground(new Color(230, 230, 230));
        add(panelCartas, BorderLayout.CENTER);


        Jugador jugador1 = new Jugador(nombreJ1);
        Jugador jugador2 = new Jugador(nombreJ2);


        motorJuego = new JuegoMemoria(jugador1, jugador2, lblTurno, lblPuntaje);
        

        renderizarTablero();
    }

    private void renderizarTablero() {
  
        Tablero logicaTablero = motorJuego.getTablero();
        
        for (Carta carta : logicaTablero.getCartas()) {
            JButton boton = new JButton("?"); 
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.setFocusPainted(false);
            boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

  
            boton.addActionListener(e -> {
                motorJuego.seleccionarCarta(carta, boton);
            });

            panelCartas.add(boton);
        }
    }
}