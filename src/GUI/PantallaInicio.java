/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import Logica.Jugador;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
/**
 *
 * @author nasry
 */

public class PantallaInicio extends JFrame {

    private JTextField txtJ1, txtJ2;

    public PantallaInicio() {
        setTitle("Pokémon Memory Battle");
        setSize(450, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panelFondo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon img = new ImageIcon(getClass().getResource("/Imagenes/pF.jpeg"));
                g.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), this);
                
                g.setColor(new Color(255, 255, 255, 150)); 
                g.fillRect(50, 40, 350, 240);
            }
        };

        panelFondo.setLayout(new BoxLayout(panelFondo, BoxLayout.Y_AXIS));
        panelFondo.setBorder(new EmptyBorder(50, 60, 50, 60));

        JLabel lblTitulo = new JLabel("PÓKEMON MEMORY");
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(59, 76, 202));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        txtJ1 = crearCampoEstilizado();
        txtJ2 = crearCampoEstilizado();

        JButton btnIniciar = new JButton("¡INICIAR DUELO!");
        btnIniciar.setBackground(new Color(239, 83, 80));
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFont(new Font("Arial", Font.BOLD, 14));
        btnIniciar.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnIniciar.addActionListener(e -> {
            if (txtJ1.getText().trim().isEmpty() || txtJ2.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "¡Ambos entrenadores deben registrarse!");
                return;
            }
            new VentanaTablero(new Jugador(txtJ1.getText()), new Jugador(txtJ2.getText()));
            dispose();
        });

        panelFondo.add(lblTitulo);
        panelFondo.add(Box.createRigidArea(new Dimension(0, 20)));
        panelFondo.add(new JLabel("Entrenador 1:"));
        panelFondo.add(txtJ1);
        panelFondo.add(Box.createRigidArea(new Dimension(0, 10)));
        panelFondo.add(new JLabel("Entrenador 2:"));
        panelFondo.add(txtJ2);
        panelFondo.add(Box.createRigidArea(new Dimension(0, 20)));
        panelFondo.add(btnIniciar);

        add(panelFondo);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JTextField crearCampoEstilizado() {
        JTextField campo = new JTextField();
        campo.setMaximumSize(new Dimension(200, 30));
        campo.setBorder(BorderFactory.createLineBorder(new Color(59, 76, 202), 2));
        return campo;
    }
}
