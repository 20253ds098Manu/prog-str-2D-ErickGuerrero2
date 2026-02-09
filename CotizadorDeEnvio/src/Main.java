import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ShippingCalculator calculadora = new ShippingCalculator();

        //INPUT
        double pesoKg = leerDoubleEnRango(leer, "Dame el peso en Kg (Rango = 0.1-50)", 0.1, 50.0);
        int distanciaKm = leerIntEnRango(leer, "Dame los Km (Rango = 1-2000)", 1, 2000);
        int tipoServicio = leerIntEnRango(leer, "Seleccione el tipo de servicio (Estandar=1 Express=2)", 1, 2);
        boolean esZonaRemota = leerBoolean(leer, "Su paquete va hacia alguna zona remota? (true/false)");

        //PROCESO
        double subtotal = calculadora.calcularSubtotal(pesoKg, distanciaKm, tipoServicio, esZonaRemota);
        double iva = calculadora.calcularIVA(subtotal);
        double total = calculadora.calcularTotal(subtotal, iva);

        //OUTPUT
        imprimirTicket(tipoServicio, pesoKg, distanciaKm, esZonaRemota, subtotal, iva, total);
    }

    public static double leerDoubleEnRango(Scanner leer, String msg, double min, double max) {
        double value;
        while (true) {
            System.out.println(msg);
            if (leer.hasNextDouble()) {
                value = leer.nextDouble();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("No esta en el rango");
            } else {
                System.out.println("No es un dato numerico");
                leer.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner leer, String msg, int min, int max) {
        int value;
        while (true) {
            System.out.println(msg);
            if (leer.hasNextInt()) {
                value = leer.nextInt();
                if (value >= min && value <= max) {
                    return value;
                }
                System.out.println("Opcion no valida o fuera de rango");
            } else {
                System.out.println("No es un valor entero");
                leer.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner leer, String msg) {
        while (true) {
            System.out.println(msg);
            if (leer.hasNextBoolean()) {
                return leer.nextBoolean();
            } else {
                System.out.println("Opcion Invalida");
                leer.next();
            }
        }
    }

    public static void imprimirTicket(int servicio, double peso, int distancia, boolean zona, double subtotal, double iva, double total) {
        System.out.print("El tipo de servicio fue el: ");
        if (servicio == 1) {
            System.out.println("estandar");
        } else {
            System.out.println("express");
        }
        System.out.println("El peso fue de " + peso + " kg");
        System.out.println("La distancia fue de " + distancia + " km");
        if (zona) {
            System.out.println("Se encontraba en zona remota");
        } else {
            System.out.println("No se encontraba en zona remota");
        }
        System.out.println("Su subtotal fue: " + subtotal);
        System.out.println("El iva fue de: " + iva);
        System.out.println("El total sera de: " + total);
    }
}