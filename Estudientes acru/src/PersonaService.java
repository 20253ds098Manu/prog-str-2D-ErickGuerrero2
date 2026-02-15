public class PersonaService {
    private Persona[] personas;
    public PersonaService() {
        this.personas = new Persona[25];
    }

    public void alta(int id, String nombre, double promedio) {
        boolean existe = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                existe = true;
                break;
            }
        }
        if (existe) {
            System.out.println("Error: El ID ya existe.");
        } else {
            boolean guardado = false;
            for (int i = 0; i < personas.length; i++) {
                if (personas[i] == null) {
                    personas[i] = new Persona(id, nombre, promedio);
                    System.out.println("Persona guardada correctamente.");
                    guardado = true;
                    break;
                }
            }
            if (!guardado) {
                System.out.println("Error: No hay espacio (Arreglo lleno).");
            }
        }
    }

    public void buscar(int id) {
        boolean encontrado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                System.out.println("Encontrado: " + personas[i].toString());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontró persona activa con ese ID.");
        }
    }

    public void actualizarPromedio(int id, double nuevoPromedio) {
        boolean actualizado = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id && personas[i].isActiva()) {
                personas[i].setPromedio(nuevoPromedio);
                System.out.println("Promedio actualizado.");
                actualizado = true;
                break;
            }
        }
        if (!actualizado) {
            System.out.println("No se pudo actualizar (No existe o inactiva).");
        }
    }

    public void baja(int id) {
        boolean bajaOk = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].getId() == id) {
                personas[i].setActiva(false);
                System.out.println("Persona dada de baja.");
                bajaOk = true;
                break;
            }
        }
        if (!bajaOk) {
            System.out.println("No se encontró el ID.");
        }
    }

    public void listar() {
        System.out.println("--- Lista de Activos ---");
        boolean hay = false;
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].isActiva()) {
                System.out.println(personas[i].toString());
                hay = true;
            }
        }
        if (!hay) System.out.println("(Vacío)");
    }

    //aqui se hace el reporte
    public void reportes() {
        System.out.println("REPORTE");
        double sumaPromedios = 0;
        int contadorAlumnos = 0;
        int contadorOcho = 0; // Para promedios >= 8.0

        double mayorProm = -1;
        Persona personaMayor = null;

        double menorProm = 11;
        Persona personaMenor = null;

        for (int i = 0; i < personas.length; i++) {
            if (personas[i] != null && personas[i].isActiva()) {

                double pActual = personas[i].getPromedio();

                sumaPromedios += pActual;
                contadorAlumnos++;

                if (pActual >= 8.0) {
                    contadorOcho++;
                }

                if (pActual > mayorProm) {
                    mayorProm = pActual;
                    personaMayor = personas[i];
                }

                if (pActual < menorProm) {
                    menorProm = pActual;
                    personaMenor = personas[i];
                }
            }
        }

        if (contadorAlumnos > 0) {
            double promedioGeneral = sumaPromedios / contadorAlumnos;

            System.out.println("Promedio general: " + promedioGeneral);

            System.out.println("Alumno MAYOR promedio:");
            if (personaMayor != null) {
                System.out.println(" " + personaMayor.toString());
            }

            System.out.println("Alumno MENOR promedio:");
            if (personaMenor != null) {
                System.out.println(" " + personaMenor.toString());
            }

            System.out.println("Cantidad promedio mayor a 8: " + contadorOcho);

        } else {
            System.out.println("No hay alumnos activos no se puede generar reportes.");
        }
    }
}