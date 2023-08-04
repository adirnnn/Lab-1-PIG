import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al juego PIG");

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Cuántos jugadores van a participar? (1-4): ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Jugador[] jugadores = new Jugador[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Nombre del Jugador " + (i + 1) + ": ");
            String nombre = scanner.nextLine();
            jugadores[i] = new Jugador(nombre);
        }

        Juego juego = new Juego(jugadores);
        juego.jugar();
    }
}
