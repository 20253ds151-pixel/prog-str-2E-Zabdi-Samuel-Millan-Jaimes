import java.util.Scanner;

public class index {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        alumno[] alumnos = new alumno[25];
        int contador = 0;
        int opcion;
        int id;
        String nom;
        int idx;
        double pro , nuevopro;

        // --- MENÚ PRINCIPAL ---
        do {
            System.out.println("\n--- MENÚ ESCOLAR (ARCHIVOS) ---");
            System.out.println("1) Alta ");
            System.out.println("2) Buscar");
            System.out.println("3) Actualizar");
            System.out.println("4) Baja");
            System.out.println("5) Listar");
            System.out.println("6) Reporte (TXT)");
            System.out.println("0) Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();

            // --- PROCESO DE OPCIONES ---
            switch (opcion) {
                case 1 : {
                    // Permitimos registrar hasta 25 alumnos activos
                    if (contador < 25) {
                        System.out.print("ID: ");
                        id = sc.nextInt();
                        // Validamos que el ID sea positivo y no esté repetido entre los activos
                        if (id > 0 && alumno.buscarIndice(alumnos, contador, id) == -1) {
                            sc.nextLine();
                            System.out.print("Nombre: ");
                            nom = sc.nextLine();
                            System.out.print("Promedio (0-10): ");
                            pro = sc.nextDouble();
                            // Validamos que el nombre no esté vacío y el promedio esté en rango
                            if (!nom.isEmpty() && pro >= 0 && pro <= 10) {
                                alumnos[contador++] = new alumno(id, nom, pro);
                                System.out.println("Registrado.");
                            } else
                                System.out.println("Datos inválidos.");
                        } else
                            System.out.println("ID inválido o repetido.");
                    }
                    break;
                }
                case 2 : {
                    System.out.print("ID a buscar: ");
                    idx = alumno.buscarIndice(alumnos, contador, sc.nextInt());
                    // Solo mostramos el alumno si está activo
                    if (idx != -1 && alumnos[idx].activo)
                        System.out.println("Alumno: " + alumnos[idx].nombre + " [" + alumnos[idx].promedio + "]");
                    else
                        System.out.println("No encontrado.");
                    break;
                }
                case 3 : {
                    System.out.print("ID para promedio: ");
                    idx = alumno.buscarIndice(alumnos, contador, sc.nextInt());
                    // Solo permitimos actualizar el promedio si el alumno está activo
                    if (idx != -1 && alumnos[idx].activo) {
                        System.out.print("Nuevo promedio: ");
                        nuevopro = sc.nextDouble();
                        // Validamos que el nuevo promedio esté en rango
                        if (nuevopro >= 0 && nuevopro <= 10)
                            alumnos[idx].promedio = nuevopro;
                    }
                    break;
                }
                case 4 : {
                    System.out.print("ID para baja: ");
                    idx = alumno.buscarIndice(alumnos, contador, sc.nextInt());
                    // Solo permitimos dar de baja si el alumno está activo
                    if (idx != -1)
                        alumnos[idx].activo = false;
                    break;
                }
                case 5 : {
                    // Listamos solo los alumnos activos
                    for (int i = 0; i < contador; i++) {
                        if (alumnos[i].activo)
                            System.out.println(alumnos[i].id + " - " + alumnos[i].nombre);
                    }
                    break;
                }
                case 6 :  
                // Generamos el reporte solo con los alumnos activos
                alumno.generarReporteArchivo(alumnos, contador);
                break;
                default:
                    System.out.println("Opcion no valida");
            }
        } while (opcion != 0);
    }
}
