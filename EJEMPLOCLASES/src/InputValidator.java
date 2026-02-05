import java.util.Scanner;

public class InputValidator {
    public int optenerNumeroEntero(String mensaje, Scanner scanner) {
        int numero;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                numero = scanner.nextInt();
                if (numero > 0) {
                    break;
                } else {
                    System.out.println("Por favor, ingrese un número entero positivo.");
                }
            } else {
                System.out.println("Entrada inválida. Por favor, ingrese un número entero.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }
        return numero;
    }
}
