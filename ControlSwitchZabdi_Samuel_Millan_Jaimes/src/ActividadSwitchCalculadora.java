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
    /* atributos o variables de la clase */
    public Scanner sc = new Scanner(System.in);
    public int opcion = 0;
    public double a = 0, b = 0, resultado = 0;
    public String operacion = "";

    /* metodo principal */
    public void main(String[] args) {
        /**
         * En esta parte del codigo se piden los datos al usuario, se calcula el
         * resultado
         * segun la opcion seleccionada y finalmente se imprimen los resultados.
         */
        pedirDatos(opcion, a, b);
        double resultado = calcularResultado(opcion, a, b);
        imprimirResultados(operacion, a, b, resultado);
        sc.close();
    }

    /**
     * metodo para pedir los datos al usuario
     * 
     * @param opcion La opción de operación seleccionada por el usuario
     * @param a      El primer número ingresado por el usuario
     * @param b      El segundo número ingresado por el usuario
     */
    public void pedirDatos(int opcion, double a, double b) {
        System.out.println("Menú de Operaciones:");
        System.out.println("1) Sumar");
        System.out.println("2) Restar");
        System.out.println("3) Multiplicar");
        System.out.println("4) Dividir");
        System.out.print("Elige una opción (1-4): ");
        opcion = sc.nextInt();
        System.out.print("Ingresa el primer número (a): ");
        a = sc.nextDouble();
        System.out.print("Ingresa el segundo número (b): ");
        b = sc.nextDouble();
    }

    /**
     * metodo para calcular el resultado basado en la opcion seleccionada
     * 
     * @param opcion La opción de operación seleccionada por el usuario
     * @param a      El primer número ingresado por el usuario
     * @param b      El segundo número ingresado por el usuario
     * @return El resultado de la operación realizada
     */
    public double calcularResultado(int opcion, double a, double b) {
        switch (opcion) {
            case 1:
                operacion = "Suma";
                resultado = a + b;
                break;
            case 2:
                operacion = "Resta";
                resultado = a - b;
                break;
            case 3:
                operacion = "Multiplicación";
                resultado = a * b;
                break;
            case 4:
                operacion = "División";
                if (b == 0) {
                    System.out.println("No se puede dividir entre cero");
                } else {
                    resultado = a / b;
                }
                break;
            default:
                System.out.println("Opción inválida");
        }
        return resultado;
    }

    /**
     * metodo para imprimir los resultados finales
     * 
     * @param operacion La operación realizada
     * @param a         El primer número ingresado por el usuario
     * @param b         El segundo número ingresado por el usuario
     * @param resultado El resultado de la operación realizada
     */
    public void imprimirResultados(String operacion, double a, double b, double resultado) {
        System.out.printf("Operación: %s%n", operacion);
        System.out.printf("Valores ingresados: a = %.2f, b = %.2f%n", a, b);
        System.out.printf("Resultado: %.2f%n", resultado);
    }
}
