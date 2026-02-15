import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        PersonaService servicio = new PersonaService();
        ValidarValor validar = new ValidarValor();
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("1) Alta alumno");
            System.out.println("2) Buscar por ID (solo activos)");
            System.out.println("3) Actualizar promedio por ID (solo activos)");
            System.out.println("4) Baja lógica por ID");
            System.out.println("5) Listar activos");
            System.out.println("6) Reportes");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese ID: ");
                    int idAlta = sc.nextInt();
                    sc.nextLine();

                    if (validar.validarIdPositivo(idAlta)) {
                        System.out.println("Ingrese Nombre: ");
                        String nombreAlta = sc.nextLine();

                        if (validar.validarTexto(nombreAlta)) {
                            System.out.println("Ingrese Promedio (0-10): ");
                            double promAlta = sc.nextDouble();
                            sc.nextLine();

                            if (validar.validarPromedio(promAlta)) {
                                servicio.alta(idAlta, nombreAlta, promAlta);
                            } else {
                                System.out.println("Error: El promedio debe estar entre 0 y 10.");
                            }
                        } else {
                            System.out.println("Error: El nombre no puede estar vacío.");
                        }
                    } else {
                        System.out.println("Error: El ID debe ser mayor a 0.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese ID a buscar: ");
                    int idBuscar = sc.nextInt();
                    servicio.buscar(idBuscar);
                    break;

                case 3:
                    System.out.println("Ingrese ID del alumno: ");
                    int idAct = sc.nextInt();

                    if (validar.validarIdPositivo(idAct)) {
                        System.out.println("Ingrese nuevo promedio: ");
                        double nuevoProm = sc.nextDouble();

                        if (validar.validarPromedio(nuevoProm)) {
                            servicio.actualizarPromedio(idAct, nuevoProm);
                        } else {
                            System.out.println("Error: El promedio debe estar entre 0 y 10.");
                        }
                    } else {
                        System.out.println("Error: ID invalido.");
                    }
                    break;

                case 4:
                    System.out.println("Ingrese ID para dar de baja: ");
                    int idBaja = sc.nextInt();
                    servicio.baja(idBaja);
                    break;

                case 5:
                    servicio.listar();
                    break;

                case 6:
                    servicio.reportes();
                    break;

                case 0:
                    System.out.println("Gracias por usar nuestro servicio crack 7w7");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
        sc.close();
    }
}