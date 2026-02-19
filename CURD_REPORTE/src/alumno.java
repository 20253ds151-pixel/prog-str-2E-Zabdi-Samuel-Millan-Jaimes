import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class alumno {
    int id;
    String nombre;
    double promedio;
    boolean activo;

    // --- CONSTRUCTOR ---
    public alumno(int id, String nombre, double promedio) {
        this.id = id;
        this.nombre = nombre;
        this.promedio = promedio;
        this.activo = true;
    }

    // --- OPERACIONES ---
    public static int buscarIndice(alumno[] lista, int contador, int id) {
        // Buscamos el índice del alumno con el ID dado, solo entre los activos
        for (int i = 0; i < contador; i++) {
            if (lista[i].id == id)
                return i;
        }
        return -1;
    }

    public static void generarReporteArchivo(alumno[] lista, int contador) {
        double suma = 0, max = -1, min = 11;
        int activos = 0, excelentes = 0;
        alumno aMax = null, aMin = null;
        // --- CÁLCULOS ---
        for (int i = 0; i < contador; i++) {
            // Solo consideramos alumnos activos para el reporte
            if (lista[i].activo) {
                activos++;
                suma += lista[i].promedio;
                // Contamos cuántos tienen promedio >= 8.0
                if (lista[i].promedio >= 8.0)
                    excelentes++;
                // Verificamos si es el nuevo máximo o mínimo
                if (lista[i].promedio > max) {
                    max = lista[i].promedio;
                    aMax = lista[i];
                }
                // Para el mínimo, también consideramos solo los activos
                if (lista[i].promedio < min) {
                    min = lista[i].promedio;
                    aMin = lista[i];
                }
            }
        }

        if (activos == 0) {
            System.out.println("No hay alumnos activos para generar el reporte.");
            return;
        }

        // --- GENERACION DEL ARCHIVO ---
        // Usamos try-with-resources para asegurar el cierre del archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("reporte_alumnos.txt"))) {
            writer.println("========== REPORTE DE ALUMNOS ==========");
            writer.println("Promedio General Activos: " + (suma / activos));
            writer.println("Mejor Promedio: ID " + aMax.id + " | " + aMax.nombre + " (" + aMax.promedio + ")");
            writer.println("Menor Promedio: ID " + aMin.id + " | " + aMin.nombre + " (" + aMin.promedio + ")");
            writer.println("Alumnos con promedio >= 8.0: " + excelentes);
            writer.println("========================================");

            System.out.println(">>> Reporte generado con éxito en 'reporte_alumnos.txt'");
        } catch (IOException e) {
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }
    }
}
