import java.util.Scanner;

public class Juego {
    private Jugador[] jugadores; // Arreglo de jugadores que participan en el juego
    private int turnoActual; // Índice del jugador actual en su turno

    // Constructor de la clase Juego
    public Juego(Jugador[] jugadores) {
        this.jugadores = jugadores; // Asigna el arreglo de jugadores proporcionado al atributo jugadores
        this.turnoActual = 0; // Inicializa el turno actual en 0 al comenzar el juego
    }

    // Método privado para avanzar al siguiente turno de jugador
    private void siguienteTurno() {
        turnoActual = (turnoActual + 1) % jugadores.length; // Actualiza el índice del jugador actual para el siguiente turno
    }

    // Método para llevar a cabo el juego PIG
    public void jugar() {
        System.out.println("\nComenzando el juego PIG");

        boolean juegoTerminado = false;

        // Bucle principal del juego, continúa hasta que se alcancen los 100 puntos por alguno de los jugadores
        while (!juegoTerminado) {
            jugadores[turnoActual].turno(); // Realiza el turno del jugador actual
            siguienteTurno(); // Avanza al siguiente turno

            // Verifica si algún jugador ha alcanzado los 100 puntos o más
            for (Jugador jugador : jugadores) {
                if (jugador.getPuntosAcumulados() >= 100) {
                    juegoTerminado = true; // Establece juegoTerminado en true para finalizar el bucle
                    break; // Sale del bucle si se ha encontrado un ganador
                }
            }
        }

        System.out.println("Juego terminado. ¡Gracias por jugar!");
    }
}
