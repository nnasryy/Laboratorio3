/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;
import Logica.Jugador;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author nasry
 */
public class PantallaInicio extends JFrame {

    private JTextField txtJ1, txtJ2;

    public PantallaInicio() {
        setTitle("Juego de Memoria - Pokémon");
        setSize(300, 200);
        setLayout(new GridLayout(3, 2));
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        txtJ1 = new JTextField();
        txtJ2 = new JTextField();

        JButton btn = new JButton("Iniciar");

        btn.addActionListener(e -> {
            if (txtJ1.getText().isEmpty() || txtJ2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Ingrese ambos nombres");
                return;
            }
            new VentanaTablero(
                    new Jugador(txtJ1.getText()),
                    new Jugador(txtJ2.getText())
            );
            dispose();
        });

        add(new JLabel("Jugador 1:"));
        add(txtJ1);
        add(new JLabel("Jugador 2:"));
        add(txtJ2);
        add(btn);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
 
