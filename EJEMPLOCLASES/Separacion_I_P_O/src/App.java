import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShippingCalculator calc = new ShippingCalculator();
        Ticket ticket = new Ticket();

        double peso = leerDoubleEnRango(sc, "Ingrese peso (0.1 - 50.0 kg): ", 0.1, 50.0);
        int distancia = leerIntEnRango(sc, "Ingrese distancia (1 - 2000 km): ", 1, 2000);
        int servicio = leerIntEnRango(sc, "Tipo de servicio (1: Estándar, 2: Express): ", 1, 2);
        boolean remota = leerBoolean(sc, "¿Es zona remota? (true/false): ");

        double subtotal = calc.calcularSubtotal(peso, distancia, servicio, remota);
        double iva = calc.calcularIVA(subtotal);
        double total = calc.calcularTotal(subtotal, iva); 
        ticket.imprimirTicket(servicio, peso, distancia, remota, subtotal, iva, total);
    }

    // Métodos obligatorios de validación
    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextDouble()) {
                System.out.print("Error. " + msg);
                sc.next();
            }
            valor = sc.nextDouble();
        } while (valor < min || valor > max);
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        do {
            System.out.print(msg);
            while (!sc.hasNextInt()) {
                System.out.print("Error. " + msg);
                sc.next();
            }
            valor = sc.nextInt();
        } while (valor < min || valor > max);
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Error: Use 'true' o 'false'.");
        }
    }
}
