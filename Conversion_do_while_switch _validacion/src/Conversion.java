import java.util.Scanner;

/**
 * Instrucciones
 * 1) Crea un programa que muestre un menú repetitivo:
 * 1) °C a °F
 * 2) °F a °C
 * 3) Km a Millas
 * 4) Millas a Km
 * 5) Salir
 * 2) El programa debe:
 * - Repetirse con do-while hasta que el usuario elija “Salir”.
 * - Validar que la opción sea un número entre 1 y 5.
 * - Validar que la temperatura o distancia ingresada sea numérica.
 * 3) Agrega un contador por cada tipo de conversión realizado.
 * 4) Al salir, imprime un resumen:
 * - Total de conversiones.
 * - Cuántas conversiones de cada tipo se hicieron.
 * 
 * Restricciones
 * - Si el usuario escribe un dato no numérico, NO debe crashear: debes volver a
 * pedirlo.
 * - Si escribe una opción inválida, mostrar mensaje y volver al menú.
 */
public class Conversion {
    public static void main(String[] args) {
        /**
         * declaracion de variables
         */
        Scanner scanner = new Scanner(System.in);
        int opcion;
        int contadorCtoF = 0;
        int contadorFtoC = 0;
        int contadorKmToMiles = 0;
        int contadorMilesToKm = 0;
        /**
         * lógica del programa
         */
        do {
            /**
             * menu de opciones
             */
            System.out.println("Menu de conversiones:");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");
            System.out.print("Elige una opcion (1-5): ");
            /**
             * validacion de la opcion ingresada
             */
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un numero valido entre 1 y 5.");
                scanner.next();
            }
            opcion = scanner.nextInt();
            /**
             * estructura switch para las conversiones
             */
            switch (opcion) {
                // Conversiones
                case 1:
                    // Conversion de Celsius a Fahrenheit
                    System.out.print("Ingresa la temperatura en °C: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingresa un numero valido para la temperatura.");
                        scanner.next();
                    }
                    double celsius = scanner.nextDouble();
                    double fahrenheit = (celsius * 9 / 5) + 32;
                    System.out.printf("%.2f °C son %.2f °F%n", celsius, fahrenheit);
                    contadorCtoF++;
                    break;
                case 2:
                    // Conversion de Fahrenheit a Celsius
                    System.out.print("Ingresa la temperatura en °F: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingresa un numero valido para la temperatura.");
                        scanner.next();
                    }
                    fahrenheit = scanner.nextDouble();
                    celsius = (fahrenheit - 32) * 5 / 9;
                    System.out.printf("%.2f °F son %.2f °C%n", fahrenheit, celsius);
                    contadorFtoC++;
                    break;
                case 3:
                    // Conversion de Kilometros a Millas
                    System.out.print("Ingresa la distancia en Km: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingresa un numero valido para la distancia.");
                        scanner.next();
                    }
                    double km = scanner.nextDouble();
                    double miles = km * 0.621371;
                    System.out.printf("%.2f Km son %.2f Millas%n", km, miles);
                    contadorKmToMiles++;
                    break;
                case 4:
                    // Conversion de Millas a Kilometros
                    System.out.print("Ingresa la distancia en Millas: ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("Por favor, ingresa un numero valido para la distancia.");
                        scanner.next();
                    }
                    miles = scanner.nextDouble();
                    km = miles / 0.621371;
                    System.out.printf("%.2f Millas son %.2f Km%n", miles, km);
                    contadorMilesToKm++;
                    break;
                case 5:
                    // Salir
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    // Opcion invalida
                    System.out.println("Opcion invalida. Por favor, elige un numero entre 1 y 5.");
                    scanner.nextLine(); // Limpiar el buffer
                    break;
            }
            // fin del do-while
        } while (opcion != 5);
        // Resumen de conversiones
        int totalConversiones = contadorCtoF + contadorFtoC + contadorKmToMiles + contadorMilesToKm;
        System.out.println("Resumen de conversiones:");
        System.out.println("Total de conversiones: " + totalConversiones);
        System.out.println("Conversiones de °C a °F: " + contadorCtoF);
        System.out.println("Conversiones de °F a °C: " + contadorFtoC);
        System.out.println("Conversiones de Km a Millas: " + contadorKmToMiles);
        System.out.println("Conversiones de Millas a Km: " + contadorMilesToKm);
        scanner.close();
    }
}
