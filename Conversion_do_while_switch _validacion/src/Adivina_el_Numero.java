import java.util.Scanner;

/**
 * Instrucciones
 * 1) El programa debe generar un número secreto aleatorio del 1 al 100.
 * 2) Pedir al usuario que adivine el número.
 * 3) Reglas:
 * - El usuario tiene máximo 7 intentos.
 * - Si el usuario acierta, mostrar “¡Ganaste!” y terminar.
 * - Si el usuario falla, decir si el número secreto es “mayor” o “menor”.
 * 4) Debe existir una bandera boolean para controlar si ganó o no.
 * 5) Validación:
 * - No aceptar números fuera de 1 a 100.
 * - No aceptar entrada no numérica (no debe crashear).
 * 
 * - Contar cuántas veces el usuario se pasó del rango (menor o mayor).
 * -contar cuantas veces ingreso un dato no numérico
 * - Al final, si pierde, mostrar el número secreto.
 */
public class Adivina_el_Numero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Generar número secreto aleatorio entre 1 y 100
        int numeroSecreto = (int) (Math.random() * 100) + 1;
        // Inicializar variables
        // Flag para controlar si el usuario ganó
        boolean gano = false;
        int fueraDeRango = 0;
        int intento = 0;
        int noNumerico = 0;
        int intentoUsuario = 1;
        // Definir número máximo de intentos
        final int MAX_INTENTOS = 7;
        // Inicio del juego
        System.out.println("¡Bienvenido al juego de Adivina el Número!");
        System.out.println("Tienes " + MAX_INTENTOS + " intentos para adivinar el número secreto entre 1 y 100.");
        // Bucle principal del juego
        do {
            // Solicitar entrada del usuario
            System.out.print("Adivina el número (entre 1 y 100): ");
            System.out.println("numero de intentos: " + intentoUsuario + " de " + MAX_INTENTOS);
            String entrada = scanner.nextLine();
            // Validar entrada numérica
            try {
                // Intentar convertir la entrada a un número entero
                intento = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                // Manejo de entrada no numérica
                // Incrementar el contador de entradas no numéricas
                noNumerico++;
                intento++;
                intentoUsuario++;
                System.out.println("Entrada no numérica. Por favor, ingresa un número válido.");
                continue;
            }

            if (intento < 1 || intento > 100) {
                // Manejo de número fuera de rango
                // Incrementar el contador de números fuera de rango
                fueraDeRango++;
                intento++;
                intentoUsuario++;
                System.out.println("Número fuera de rango. Debe estar entre 1 y 100.");
                continue;
            }
            // Incrementar el contador de intentos válidos
            intento++;
            intentoUsuario++;

            if (intento == numeroSecreto) {
                // Usuario adivinó correctamente
                // Establecer la bandera de victoria
                gano = true;
                System.out.println("¡Ganaste!");
            } else if (intento < numeroSecreto) {
                System.out.println("El número secreto es mayor.");
            } else {
                System.out.println("El número secreto es menor.");

            }

        } while (!gano && intentoUsuario < MAX_INTENTOS);
        // Resultados finales
        if (!gano) {
            // Usuario no adivinó el número
            System.out.println("¡Perdiste! El número secreto era: " + numeroSecreto);
        }
        // Mostrar estadísticas de validación
        System.out.println("Número de intentos fuera de rango: " + fueraDeRango);
        System.out.println("Número de entradas no numéricas: " + noNumerico);
        System.out.println("Gracias por jugar. ¡Hasta la próxima!");
        scanner.close();
    }

}
