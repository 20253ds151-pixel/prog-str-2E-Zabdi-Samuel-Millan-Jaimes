/**
 * Menú (mínimo):
 * 1) Alta
 * 2) Buscar por ID (solo activas)
 * 3) Baja lógica por ID
 * 4) Listar activas
 * 5) Actualizar nombre por ID (solo activas)
 * 0) Salir
 * 
 * VALIDACIONES OBLIGATORIAS
 * - id > 0
 * - nombre NO vacío
 * - no permitir id repetido
 * - opción inválida en el menú debe mostrar mensaje y volver a pedir
 * 
 * CASOS DE PRUEBA
 * - Alta de 3 personas.
 * - Intento de alta con ID repetido (debe rechazar).
 * - Baja lógica de 1 persona.
 * - Buscar la persona dada de baja (debe decir “no encontrada o inactiva”).
 * - Actualizar nombre de una activa y listar activas.
 */
public class index {
    public static void main(String[] args) {
        // instancia de persona
        persona p1 = new persona();
        // variable para opción del menú
        int opcion;
        // menu de opciones
        do {
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID ");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID ");
            System.out.println("0) Salir");
            // pedir opción
            System.out.print("Seleccione una opción: ");
            opcion = new java.util.Scanner(System.in).nextInt();
            // validar opción
            if (opcion < 0 || opcion > 5) {
                System.out.println("Opción inválida, intente de nuevo.");
                continue;
            }
            switch (opcion) {
                case 1:
                    // alta
                    System.out.println("Ingrese ID:");
                    p1.setId(new java.util.Scanner(System.in).nextInt());
                    System.out.println("Ingrese nombre:");
                    p1.setNombre(new java.util.Scanner(System.in).nextLine());
                    System.out.println("Ingrese estado (true/false):");
                    p1.setEstado(new java.util.Scanner(System.in).nextBoolean());
                    p1.personas(p1.getId(), p1.getNombre(), p1.getEstado());
                    p1.listadopersonas();
                    break;
                case 2:
                    // buscar por id
                    System.out.println("Ingrese ID a buscar:");
                    p1.setId(new java.util.Scanner(System.in).nextInt());
                    p1.buscarid(p1.getId());
                    break;
                case 3:
                    // baja logica
                    System.out.println("Ingrese ID a dar de baja:");
                    p1.setId(new java.util.Scanner(System.in).nextInt());
                    p1.bajalogica(p1.getId());
                    break;
                case 4:
                    // status de las listas
                    System.out.println("Personas activas:");
                    p1.listaractivas();
                    System.out.println("Personas Inactivas:");
                    p1.listarInactivas();
                    break;
                case 5:
                    // actualizar nombre por id
                    System.out.println("Ingrese ID a actualizar:");
                    p1.setId(new java.util.Scanner(System.in).nextInt());
                    System.out.println("Ingrese nuevo nombre:");
                    p1.setNombre(new java.util.Scanner(System.in).nextLine());
                    p1.actualizPersona(p1.getId(), p1.getNombre());
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 0);

    }

}
