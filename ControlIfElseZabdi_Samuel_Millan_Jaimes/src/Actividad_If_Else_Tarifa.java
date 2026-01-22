
/**
 * Tu programa debe pedir al usuario:
 * edad (int)
 * esEstudiante (boolean: true/false)
 * Reglas:
 * Si edad es menor a 0 o mayor a 120: imprime "Edad inválida" y termina el
 * programa.
 * Si edad < 12: tarifa = 50
 * Si edad entre 12 y 17:
 * si esEstudiante = true -> tarifa = 60
 * si esEstudiante = false -> tarifa = 80
 * Si edad >= 18:
 * si esEstudiante = true -> tarifa = 90
 * si esEstudiante = false -> tarifa = 120
 * -Debes imprimir al final:
 * Edad ingresada
 * Si es estudiante o no
 * Tarifa final
 */
import java.util.Scanner;

public class Actividad_If_Else_Tarifa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        /**
         * En esta parte del codigo preguntamos la edad y se valida, de ser correcta
         * se pregunta si es estudiante o no para determinar la tarifa correspondiente.
         */
        System.out.print("Ingresa tu edad: ");
        int edad = sc.nextInt();
        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            sc.close();
            return;
        }
        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = sc.nextBoolean();
        /**
         * Aqui se aplican las reglas para determinar la tarifa segun la edad y si es
         * estudiante o no.
         */
        condiciones(edad, esEstudiante);
        /**
         * Finalmente se imprimen los resultados solicitados.
         */
        imprimirResultados(edad, esEstudiante, condiciones(edad, esEstudiante));
        sc.close();

    }
    /** 
     * metodo donde se aplican las condiciones para determinar la tarifa 
     * segun la edad y si es estudiante o no.
     * @param edad La edad del usuario
     * @param esEstudiante Indica si el usuario es estudiante
     * @return La tarifa calculada basada en las condiciones dadas
     */ 
    public static int condiciones (int edad, boolean esEstudiante){
        int tarifa;
        if (edad < 12) {
            tarifa = 50;
        } else if (edad >= 12 && edad <= 17) {
            if (esEstudiante == true) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        } else {
            if (esEstudiante == true) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }
        return tarifa;
    } 
    /**
     * Metodo para imprimir los resultados finales
     * @param edad
     * @param esEstudiante
     * @param tarifa
     */
    public static void imprimirResultados(int edad, boolean esEstudiante, int tarifa) {
        System.out.println("Edad ingresada: " + edad);
        System.out.println("Es estudiante: " + esEstudiante);
        System.out.println("Tarifa final: " + tarifa);
    }
}
