
/**
 * Tu programa debe:
 * - Mostrar este menú:
 * 1) Sumar
 * 2) Restar
 * 3) Multiplicar
 * 4) Dividir
 * - Pedir al usuario:
 * - opcion (int)
 * - a (double) ->
 * - b (double) -> por la naturaleza del ejercicio, lo vamos a nombrar asi, otra
 * opcion podria ser variableA y variableB por ej, queda a tu consideracion
 * 4. Reglas:
 * - Usa switch(opcion) para elegir operación.
 * - En división:
 * - si b == 0, imprime "No se puede dividir entre cero" y NO calcules
 * resultado.
 * - Si la opción no es 1-4, imprime "Opción inválida".
 * 5. Imprime:
 * - Operación elegida (texto)
 * - Valores ingresados
 * - Resultado (si aplica)
 */
import java.util.Scanner;

public class ActividadSwitchCalculadora {
    /* metodo principal */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        double a = 0;
        double b = 0;
        System.out.println("Menú de Operaciones:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.print("Elige una opción (1-4): ");
        opcion = sc.nextInt();
        /* Se condiciona si no cumple se sale del programa */
        if (opcion < 1 || opcion > 4) {
            System.out.println("Opción inválida");
            sc.close();
            return;
        }
        System.out.print("Ingresa el primer número (a): ");
        a = sc.nextDouble();
        System.out.print("Ingresa el segundo número (b): ");
        b = sc.nextDouble();
        calcularResultado(opcion, a, b);
        sc.close();

    }

    /**
     * metodo para calcular el resultado basado en la opcion seleccionada
     * 
     * @param opcion La opción de operación seleccionada por el usuario
     * @param a El primer número ingresado por el usuario
     * @param b El segundo número ingresado por el usuario
     * @return El resultado de la operación realizada junto con la impresión de los
     * resultados
     */
    public static double calcularResultado(int opcion, double a, double b) {
        double resultado = 0;
        String operacion = "";
        switch (opcion ) {
            case 1:
                resultado = a + b;
                operacion = "Suma";
                break;
            case 2:
                resultado = a - b;
                operacion = "Resta";
                break;
            case 3:
                resultado = a * b;
                operacion = "Multiplicación";
                break;
            case 4:
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                    operacion = "División";
                }
                break;
        }
        imprimirResultados(operacion, a, b, resultado);
        return resultado;
    }

    /**
     * metodo para imprimir los resultados finales
     * 
     * @param operacion La operación realizada
     * @param a El primer número ingresado por el usuario
     * @param b El segundo número ingresado por el usuario
     * @param calculo El resultado de la operación realizada
     */
    public static void imprimirResultados(String operacion, double a, double b, double calculo) {
        System.out.printf("Operación: %s%n", operacion);
        System.out.printf("Valores ingresados: a = %.2f y b = %.2f%n", a, b);
        System.out.printf("Resultado: %.2f%n", calculo);
    }
}
