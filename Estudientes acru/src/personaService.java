public class PersonaService {

    private Persona[] personas;

    public PersonaService() {
//iniciamos arreglo
        this.personas = new Persona[20];
    }

    //Alta
    public void alta(int id, String nombre) {
        boolean existe = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                if (personas[i].getId() == id) {
                    existe = true;
                }
            }
        }

        if (existe == true) {
            System.out.println("Error: El ID ya existe.");
        } else {
            boolean guardado = false;
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = new Persona(id, nombre);
                    System.out.println("Persona guardada correctamente.");
                    guardado = true;
                    break;
                }
            }
            if (guardado == false) {
                System.out.println("Error: No hay espacio (Arreglo lleno).");
            }
        }
    }

    //  Buscar por ID (solo activas)
    public void buscar(int id) {
        boolean encontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                if (personas[i].getId() == id) {
                    if (personas[i].isActiva()) {
                        System.out.println(personas[i].toString());
                        encontrado = true;
                    }
                }
            }
        }
        if (encontrado == false) {
            System.out.println("No se encontro persona activa con ese ID.");
        }

    }

    //Baja lógica por ID
    public void baja(int id) {
        boolean bajaOk = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                if (personas[i].getId() == id) {
                    personas[i].setActiva(false);
                    System.out.println("Persona dada de baja.");
                    bajaOk = true;
                }
            }
        }

    }

    //Listar activas
    public void listar() {
        System.out.println("--- Lista ---");
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                if (personas[i].isActiva()) {
                    System.out.println(personas[i].toString());
                }
            }
        }
    }

    // Actualizar nombre por ID (solo activas)
    public void actualizar(int id, String nuevoNombre) {
        boolean actualizado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null) {
                if (personas[i].getId() == id) {
                    if (personas[i].isActiva()) {
                        personas[i].setNombre(nuevoNombre);
                        System.out.println("Nombre actualizado.");
                        actualizado = true;
                    }
                }
            }
        }
        if (actualizado == false) {
            System.out.println("No se pudo actualizar (No existe o inactiva).");
        }
    }
}