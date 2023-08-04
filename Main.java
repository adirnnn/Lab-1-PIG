// Adrián 231361
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Se muestra un mensaje de bienvenida
        System.out.println("Bienvenido al juego PIG");

        // Se crea un objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Se solicita al usuario el número de jugadores que participarán en el juego (lo programe simplemente para hacer mi vida más fácil al testearlo pero me parece buena implementación)
        System.out.print("¿Cuántos jugadores van a participar? (1-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        // Crea un arreglo de objetos Jugador para almacenar los jugadores
        Jugador[] jugadores = new Jugador[numPlayers];

        // Solicita el nombre de cada jugador y crea un objeto Jugador con el nombre ingresado (Simplemente por orden; OCD :/)
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Nombre del Jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores[i] = new Jugador(nombre);
        }

        // Crea un objeto Juego con los jugadores creados y comienza el juego
        Juego juego = new Juego(jugadores);
        juego.jugar();
    }
}
