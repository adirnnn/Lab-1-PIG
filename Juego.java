import java.util.Scanner;

public class Juego {
    private Jugador[] jugadores;
    private int turnoActual;

    public Juego(Jugador[] jugadores) {
        this.jugadores = jugadores;
        this.turnoActual = 0;
    }

    private void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.length;
    }

    public void jugar() {
        System.out.println("\nComenzando el juego PIG");

        boolean juegoTerminado = false;

        while (!juegoTerminado) {
            jugadores[turnoActual].turno();
            siguienteTurno();

            for (Jugador jugador : jugadores) {
                if (jugador.getPuntosAcumulados() >= 100) {
                    juegoTerminado = true;
                    break;
                }
            }
        }

        System.out.println("Juego terminado. ¡Gracias por jugar!");
    }
}
