package tragaperras.com.app.mvc.controller;

import java.awt.Color;
import javax.swing.JLabel;

/**
 * Clase para manejar las apuestas del jugador
 * Permite realizar apuestas y evaluar los resultados del juego para actualizar el saldo.
 * 
 * @author luiis
 */
public class Betting {
    private int saldo; // Saldo actual del jugador
    private JLabel mostrarSaldo; // Etiqueta para mostrar el saldo en la interfaz gráfica

    /**
     * Constructor de la clase Betting.
     * 
     * @param saldoInicial Saldo inicial del jugador.
     * @param mostrarSaldo JLabel donde se mostrará el saldo actualizado.
     */
    public Betting(int saldoInicial, JLabel mostrarSaldo) {
        this.saldo = saldoInicial;
        this.mostrarSaldo = mostrarSaldo;
        actualizarSaldo();
    }

    /**
     * Realiza una apuesta, descontando el saldo del jugador si es válida.
     * 
     * @param cantidad Monto de la apuesta.
     */
    public void placeBet(int cantidad) {
        if (cantidad <= 0) {
            mostrarSaldo.setText("Apuesta inválida");
            mostrarSaldo.setForeground(Color.red);
            return;
        }

        if (cantidad > saldo) {
            mostrarSaldo.setText("Saldo insuficiente");
            mostrarSaldo.setForeground(Color.red);
            return;
        }

        saldo -= cantidad;
        actualizarSaldo();
    }

    /**
     * Evalúa el resultado del juego y actualiza el saldo si el jugador gana.
     * 
     * @param key1 Primera clave generada en el juego.
     * @param key2 Segunda clave generada en el juego.
     * @param key3 Tercera clave generada en el juego.
     */
    public void evaluateGame(String key1, String key2, String key3) {
        int ganancia = 0;

        if (key1.equals(key2) && key2.equals(key3)) {
            ganancia = 100; // Jackpot, tres símbolos iguales
        } else if (key1.equals(key2) || key1.equals(key3) || key2.equals(key3)) {
            ganancia = 30; // Premio menor, dos símbolos iguales
        }

        saldo += ganancia;
        mostrarSaldo.setText(ganancia > 0 ? "Ganaste: " + ganancia : "Perdiste");
        actualizarSaldo();
    }

    /**
     * Actualiza la etiqueta de saldo con el valor actual.
     */
    private void actualizarSaldo() {
        mostrarSaldo.setText("Saldo: $" + saldo);
    }
}