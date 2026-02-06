/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Logica.Carta;

/**
 *
 * @author nasry
 */
public interface IJuego {

    void iniciarJuego();

    void cambiarTurno();

    void verificarPareja(Carta c1, Carta c2);

    void finalizarJuego();
}
