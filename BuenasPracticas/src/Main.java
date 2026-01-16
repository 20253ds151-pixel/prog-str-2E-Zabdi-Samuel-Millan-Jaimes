
/**
 * Buenas Prácticas de Programación
 * Ejemplo de código mal escrito
 * Versión original:
 * 
 * import java.util.Scanner;
 * public class Main{
 * public static void main(String[]a){
 * Scanner sc=new Scanner(System.in);
 * System.out.print("n:");
 * int n=sc.nextInt();
 * int s=0;
 * for(int i=1;i<=n;i++){
 * s+=i;
 * }
 * System.out.println("r:"+s);
 * } }
 */

import java.util.Scanner;

/**
 * version mejorada siguiendo buenas prácticas de programación
 */
public class Main {
    /**
     * Programa que calcula la suma de los primeros N números enteros positivos.
     * Aplicando buenas prácticas de programación
     */
    public static void main(String[] args) {
        int numeroLimite = solicitarNumeroEnteroPositivo();
        long suma = calcularSumaEnterosPositivos(numeroLimite);
        mostrarResultado(numeroLimite, suma);
    }

    /**
     * Solicita al usuario un número entero positivo y lo devuelve.
     * 
     * @param numeroLimite límite hasta el cual se sumarán los enteros positivos
     * @return la suma de los primeros N números enteros positivos
     */
    private static int solicitarNumeroEnteroPositivo() {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Ingrese un número entero positivo n: ");
            numero = scanner.nextInt();
            if (numero <= 0) {
                System.out.println("Por favor, ingrese un número válido mayor que cero.");
            }
        } while (numero <= 0);

        return numero;
    }

    /**
     * Calcula la suma de los primeros N números enteros positivos.
     * 
     * @param numeroLimite límite hasta el cual se sumarán los enteros positivos
     * @return la suma de los primeros N números enteros positivos
     */
    private static long calcularSumaEnterosPositivos(int numeroLimite) {
        long suma = 0;
        for (int i = 1; i <= numeroLimite; i++) {
            suma += i;
        }
        return suma;
    }

    /**
     * Muestra el resultado de la suma en la consola.
     * 
     * @param suma la suma de los primeros N números enteros positivos
     */
    private static void mostrarResultado(int numeroLimite, long suma) {
        System.out.println("------------------------------------------");
        System.out.println("La suma de los números del 1 al " + numeroLimite + " es: " + suma);
        System.out.println("------------------------------------------");
    }
}