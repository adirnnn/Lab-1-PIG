import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int puntosAcumulados;
    private int puntosRonda; // New variable to track points earned in the current round

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosAcumulados = 0;
        this.puntosRonda = 0; // Initialize puntosRonda to 0 for each player
    }

    public int lanzarDado() {
        // Simulate rolling two dice and return the sum of their results
        int dado1 = new Random().nextInt(6) + 1;
        int dado2 = new Random().nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2);

        // Check if either dice is 1
        if (dado1 == 1 || dado2 == 1) {
            return 1; // Return 1 if either dice is 1
        }

        return dado1 + dado2;
    }

    public void reiniciarRonda() {
        puntosRonda = 0; // Reset puntosRonda at the beginning of each round
    }

    public void turno() {
        if (puntosAcumulados >= 100) {
            System.out.println(nombre + " ya ha alcanzado o superado los 100 puntos y ha ganado el juego.");
            return;
        }

        System.out.println("Turno de " + nombre);

        reiniciarRonda(); // Restart the round points counter

        boolean continuar = true;

        while (continuar) {
            int dado = lanzarDado();
            System.out.println(nombre + " lanzó los dados y obtuvo: " + dado);

            if (dado == 1) {
                System.out.println(nombre + " sacó un 1, perdió los puntos acumulados.");
                puntosAcumulados = 0;
                continuar = false;
            } else {
                puntosRonda += dado;
                System.out.println("Puntos acumulados en esta ronda: " + puntosRonda);

                if (puntosAcumulados + puntosRonda >= 100) {
                    System.out.println(nombre + " alcanzó o superó los 100 puntos y ganó el juego.");
                    puntosAcumulados += puntosRonda;
                    continuar = false;
                } else if (puntosRonda >= 20) {
                    System.out.println(nombre + " alcanzó 20 o más puntos en esta ronda y finalizó su turno.");
                    puntosAcumulados += puntosRonda;
                    continuar = false;
                } else {
                    System.out.print("¿Desea lanzar de nuevo? (s/n): ");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    continuar = input.equalsIgnoreCase("s");
                }
            }
        }

        System.out.println(nombre + " finalizó el turno. Puntos acumulados: " + puntosAcumulados);
        System.out.println();
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
}
