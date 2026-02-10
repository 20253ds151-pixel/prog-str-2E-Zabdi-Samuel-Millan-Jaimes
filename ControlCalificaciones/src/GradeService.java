public class GradeService {
    public double calcularPromedio(double p1, double p2, double p3) {
        return (p1 + p2 + p3) / 3.0;
    }

    public double calcularFinal(double promedio, int asistencia) {
        return (promedio * 0.7) + (asistencia * 0.3);
    }

    public String determinarEstado(double calificacionFinal, int asistencia, boolean entregoProyecto) {
        if (asistencia < 80) {
            return "REPROBADO por asistencia";
        }
        if (!entregoProyecto) {
            return "REPROBADO por proyecto";
        }
        return (calificacionFinal >= 70) ? "APROBADO" : "REPROBADO por calificación";
    }
}
