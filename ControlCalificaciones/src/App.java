import java.util.Scanner;

public class App {
    // METODO PRINCIPAL
public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        // Input del programa 
        String nombre = leerTextoNoVacio(sc, "Nombre del alumno: ");
        double p1 = leerDoubleEnRango(sc, "Parcial 1 (0-100): ", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Parcial 2 (0-100): ", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Parcial 3 (0-100): ", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia (0-100): ", 0, 100);
        boolean entregoProyecto = leerBoolean(sc, "¿Entregó proyecto? (true/false): ");

        // Procesamiento de datos 
        double promedio = service.calcularPromedio(p1, p2, p3);
        double notaFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(notaFinal, asistencia, entregoProyecto);

        // Output
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, notaFinal, estado);
    }





    // --- MÉTODOS DE INPUT ---

    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto;
        do {
            System.out.print(msg);
            texto = sc.nextLine().trim();
        } while (texto.isEmpty());
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) break;
            }
            sc.nextLine();
            System.out.println("Error: Ingrese un valor entre " + min + " y " + max);
        }
        sc.nextLine(); 
        return valor;
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.print(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) break;
            }
            sc.nextLine(); 
            System.out.println("Error: Ingrese un entero entre " + min + " y " + max);
        }
        sc.nextLine(); 
        return valor;
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.next().toLowerCase();
            if (input.equals("true")) return true;
            if (input.equals("false")) return false;
            System.out.println("Error: Solo se acepta 'true' o 'false'");
        }
    }

    // --- MÉTODO OUTPUT PARA LOD DATOS A REFLEJAR ---

    public static void imprimirReporte(String nom, double p1, double p2, double p3, 
                                     double prom, int asis, boolean proj, 
                                     double fin, String est) {
        System.out.println("\n--- REPORTE FINAL ---");
        System.out.println("Alumno: " + nom);
        System.out.printf("Parciales: [%.2f, %.2f, %.2f]\n", p1, p2, p3);
        System.out.printf("Promedio Parcial: %.2f\n", prom);
        System.out.println("Asistencia: " + asis + "%");
        System.out.println("Proyecto Entregado: " + (proj ? "Sí" : "No"));
        System.out.printf("Calificación Final: %.2f\n", fin);
        System.out.println("ESTADO: " + est);
        System.out.println("----------------------");
    }
}
