public class persona {
    int id;
    String nombre;
    boolean estado;
    persona[] personas = new persona[20];

    public persona() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void personas(int id, String nombre, boolean estado) {
        // Validar que los ID sean unicos y no se repitan y rechasa la creación de una persona con un ID ya existente
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                System.out.println("Error: ID ya existe. No se puede crear la persona.\n");
                return;
            }
            // Validar que el ID sea mayor a 0 y el nombre no esté vacío
        if (id > 0 && !nombre.isEmpty()) {
            System.out.println("Datos válidos. Persona creada.\n");
        } else {
            System.out.println("Datos inválidos. ID debe ser mayor a 0 y nombre no puede estar vacío.\n");
        }
        }
        // Agregar persona al arreglo
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new persona();
                personas[i].setId(id);
                personas[i].setNombre(nombre);
                personas[i].setEstado(estado);
                break;
            }
        }
        // Listar todas las personas
        for (persona p : personas) {
            if (p != null) {
                System.out.println("ID: " + p.getId() + "\tNombre: " + p.getNombre() + "\tEstado: " + (p.getEstado() ? "Activo" : "Inactivo")+"\n");
            }
        }
    }

    public persona buscarid(int id) {
        // Buscar persona por ID
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                System.out.println("Persona encontrada: " + p.getNombre()+"\n");
                return p;
            }
        }
        // Si no se encuentra la persona o está inactiva
        System.out.println("Persona no encontrada.\n");
        return null;
    }

    public persona bajalogica(int id) {
        // Dar de baja lógica a una persona por ID
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setEstado(false);
                System.out.println("Persona dada de baja lógica: " + p.getNombre()+"\n");
                return p;
            }
        }
        // Si no se encuentra la persona
        System.out.println("Persona no encontrada. \n");
        return null;
    }

    public void listaractivas() {
        // Listar personas activas
        for (persona p : personas) {
            if (p != null && p.getEstado()) {
                System.out.println("ID: " + p.getId() + "\t Nombre: " + p.getNombre()+"\n");
            }
        }
    }

    public void listarInactivas() {
        // Listar personas inactivas
        for (persona p : personas) {
            if (p != null && !p.getEstado()) {
                System.out.println("ID: " + p.getId() + "\t Nombre: " + p.getNombre()+"\n");
            }
        }
    }

    public persona actualizPersona(int id, String nuevoNombre) {
        // Actualizar el nombre de una persona por ID
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setNombre(nuevoNombre);
                System.out.println("Persona actualizada:\n ID: " + p.getId() + "\t Nuevo Nombre: " + p.getNombre()+"\n");
                return p;
            }
        }
        System.out.println("Persona no encontrada. \n");
        return null;
    }
}
