import java.util.Random;
import java.util.Scanner;

public class Jugador {
    private String nombre; // Nombre del jugador
    private int puntosAcumulados; // Puntos totales acumulados por el jugador
    private int puntosRonda; // Variable para rastrear los puntos obtenidos en cada ronda

    // Constructor de la clase Jugador
    public Jugador(String nombre) {
        this.nombre = nombre;
        this.puntosAcumulados = 0; // Inicializa los puntos acumulados en 0 para cada jugador
        this.puntosRonda = 0; // Inicializa los puntos de la ronda en 0 para cada jugador
    }

    // Método para lanzar los dados y obtener la suma de sus resultados
    public int lanzarDado() {
        // Simula el lanzamiento de ambos dados y obtiene la suma de ambos resultados
        int dado1 = new Random().nextInt(6) + 1;
        int dado2 = new Random().nextInt(6) + 1;
        System.out.println("Dado 1: " + dado1 + ", Dado 2: " + dado2);

        // Comprueba si alguno de los dados es 1
        if (dado1 == 1 || dado2 == 1) {
            return 1; // Devuelve 1 si alguno de los dados es 1, esto es para que luego se resetee el total de puntos
        }

        return dado1 + dado2; // Devuelve la suma de los resultados de los dados
    }

    // Método para reiniciar los puntos de la ronda al comienzo de cada ronda
    public void reiniciarRonda() {
        puntosRonda = 0; // Reinicia los puntos de la ronda a 0 al inicio de cada ronda
    }

    // Método para llevar a cabo el turno del jugador
    public void turno() {
        if (puntosAcumulados >= 100) {
            System.out.println(nombre + " ya ha alcanzado o superado los 100 puntos y ha ganado el juego.");
            return;
        }

        System.out.println("Turno de " + nombre);

        reiniciarRonda(); // Reinicia los puntos de la ronda al inicio del turno

        boolean continuar = true;

        // Bucle while para permitir que el jugador lance los dados y acumule puntos en la ronda
        while (continuar) {
            int dado = lanzarDado();
            System.out.println(nombre + " lanzó los dados y obtuvo: " + dado);

            if (dado == 1) {
                System.out.println(nombre + " sacó un 1, perdió los puntos acumulados.");
                puntosAcumulados = 0; // Resetea los puntos acumulados a 0 si se obtiene un 1 en algún dado
                puntosRonda = 0; // Reinicia los puntos de la ronda a 0 si se obtiene un 1 en algún dado. Tecnicamente no necesario pero evita errores ocasionales
                continuar = false; // Finaliza el turno del jugador
            } else {
                puntosRonda += dado; // Acumula los puntos obtenidos en la ronda actual
                System.out.println("Puntos acumulados en esta ronda: " + puntosRonda);

                if (puntosAcumulados + puntosRonda >= 100) {
                    System.out.println(nombre + " alcanzó o superó los 100 puntos y ganó el juego.");
                    puntosAcumulados += puntosRonda; // Suma los puntos de la ronda a los puntos totales acumulados
                    continuar = false; // Finaliza el turno del jugador
                } else if (puntosRonda >= 20) {
                    System.out.println(nombre + " alcanzó 20 o más puntos en esta ronda y finalizó su turno.");
                    puntosAcumulados += puntosRonda; // Suma los puntos de la ronda a los puntos totales acumulados
                    continuar = false; // Finaliza el turno del jugador
                } else {
                    System.out.print("¿Desea lanzar de nuevo? (s/n): ");
                    Scanner scanner = new Scanner(System.in);
                    String input = scanner.nextLine();
                    continuar = input.equalsIgnoreCase("s"); // Continua el turno si el jugador ingresa "s"
                }
            }
        }

        System.out.println(nombre + " finalizó el turno. Puntos acumulados: " + puntosAcumulados);
        System.out.println();
    }

    // Método para obtener los puntos acumulados del jugador
    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }
}
