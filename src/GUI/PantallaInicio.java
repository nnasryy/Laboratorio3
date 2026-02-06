/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author nasry
 */
import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JFrame {


    private JTextField txtJugador1;
    private JTextField txtJugador2;
    private JButton btnIniciar;

    public PantallaInicio() {
       
        setTitle("Pokemon Memory Game - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 350);
        setLocationRelativeTo(null); 
        setResizable(false);
        
   
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelPrincipal.setBackground(Color.WHITE);
        add(panelPrincipal);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10); 

  
        JLabel lblTitulo = new JLabel("NUEVA PARTIDA", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelPrincipal.add(lblTitulo, gbc);

       
        gbc.gridwidth = 1; 
        gbc.gridy = 1;
        panelPrincipal.add(new JLabel("Jugador 1:"), gbc);

        txtJugador1 = new JTextField(15);
        txtJugador1.setPreferredSize(new Dimension(0, 30));
        gbc.gridx = 1;
        panelPrincipal.add(txtJugador1, gbc);

    
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelPrincipal.add(new JLabel("Jugador 2:"), gbc);

        txtJugador2 = new JTextField(15);
        txtJugador2.setPreferredSize(new Dimension(0, 30));
        gbc.gridx = 1;
        panelPrincipal.add(txtJugador2, gbc);

 
        btnIniciar = new JButton("INICIAR AVENTURA");
        btnIniciar.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnIniciar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnIniciar.setBackground(new Color(41, 128, 185)); 
        btnIniciar.setForeground(Color.WHITE);
        btnIniciar.setFocusPainted(false);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(30, 10, 10, 10); 
        panelPrincipal.add(btnIniciar, gbc);

//TRY CATCH, para espacios en blanco
        btnIniciar.addActionListener(e -> {
            try {
                String n1 = txtJugador1.getText().trim();
                String n2 = txtJugador2.getText().trim();

                if (n1.isEmpty() || n2.isEmpty()) {
                    throw new IllegalArgumentException("¡Ambos entrenadores deben tener un nombre!");
                }

                System.out.println("Iniciando: " + n1 + " vs " + n2);
            
            } catch (IllegalArgumentException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Campos Vacíos", JOptionPane.WARNING_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error inesperado: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

}
