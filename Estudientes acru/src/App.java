import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        //Arreglo
        Persona[] personas = new Persona[20];
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1) Alta");
            System.out.println("2) Buscar por ID");
            System.out.println("3) Baja lógica por ID");
            System.out.println("4) Listar activas");
            System.out.println("5) Actualizar nombre por ID");
            System.out.println("0) Salir");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese ID (debe ser > 0): ");
                    int idAlta = sc.nextInt();
                    sc.nextLine();

                    if (idAlta <= 0) {
                        System.out.println("Error: El ID debe ser mayor a 0.");
                    } else {

                        boolean repetido = false;
                        for (int i = 0; i < personas.length; i++) {
                            if (personas[i] != null && personas[i].getId() == idAlta) {
                                repetido = true;
                                break;
                            }
                        }

                        if (repetido) {
                            System.out.println("Error: El ID ya existe.");
                        } else {
                            System.out.println("Ingrese Nombre: ");
                            String nombreAlta = sc.nextLine();

                            if (nombreAlta.equals("")) {
                                System.out.println("Error: El nombre no puede estar vacío pequeñin.");
                            } else {

                                boolean guardado = false;
                                for (int i = 0; i < personas.length; i++) {
                                    if (personas[i] == null) {
                                        personas[i] = new Persona(idAlta, nombreAlta);
                                        System.out.println("Persona guardada correctamente.");
                                        guardado = true;
                                        break;
                                    }
                                }
                                if (!guardado) {
                                    System.out.println("Error: No hay espacio en el arreglo.");
                                }
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.println("Ingrese ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    boolean encontrado = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idBuscar && personas[i].isActiva()) {
                            System.out.println("Encontrado: " + personas[i].toString());
                            encontrado = true;
                            break;
                        }
                    }

                    if (encontrado == false) {
                        System.out.println("No se encontró persona activa con ese ID.");
                    }

                    break;
                case 3:
                    System.out.println("Ingrese ID para dar de baja: ");
                    int idBaja = sc.nextInt();
                    boolean bajaExitosa = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idBaja) {
                            personas[i].setActiva(false);
                            System.out.println("ID " + idBaja + " dado de baja.");
                            bajaExitosa = true;
                            break;
                        }
                    }


                case 4:
                    System.out.println("Lista de Personas Activas");
                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].isActiva()) {
                            System.out.println(personas[i].toString());
                        }
                    }
                    break;

                case 5:
                    System.out.println("Ingrese ID para actualizar: ");
                    int idAct = sc.nextInt();
                    sc.nextLine();
                    boolean actualizado = false;

                    for (int i = 0; i < personas.length; i++) {
                        if (personas[i] != null && personas[i].getId() == idAct && personas[i].isActiva()) {
                            System.out.println("Nombre actual: " + personas[i].getNombre());
                            System.out.println("Ingrese nuevo nombre: ");
                            String nuevoNombre = sc.nextLine();

                            if (!nuevoNombre.equals("")) {
                                personas[i].setNombre(nuevoNombre);
                                System.out.println("Nombre actualizado.");
                            } else {
                                System.out.println("Error: El nombre no puede estar vacío.");
                            }
                            actualizado = true;
                            break;
                        }
                    }
                    if (!actualizado) {
                        System.out.println("No se hay persona activa con ese ID.");
                    }
                    break;

                case 0:
                    break;

                default:

                    System.out.println("Opción inválida, intente de nuevo.");
            }
        }
        sc.close();
    }
}