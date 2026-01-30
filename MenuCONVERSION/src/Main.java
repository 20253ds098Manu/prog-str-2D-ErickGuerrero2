import java.util.*;

public class Main {
    static int ContadorCaF = 0, ContadorFaC = 0, ContadorKmaM = 0, ContadorMaKm = 0;

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n¿Que desea hacer?");
            System.out.println("1) °C a °F");
            System.out.println("2) °F a °C");
            System.out.println("3) Km a Millas");
            System.out.println("4) Millas a Km");
            System.out.println("5) Salir");

            while (!leer.hasNextInt()) {
                System.out.println("Opción no válida, intente de nuevo:");
                leer.next();
            }

            opcion = leer.nextInt();

            if (opcion < 1 || opcion > 5) {
                System.out.println("Opción fuera de rango");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + celsiusAFahrenheit(leer));
                    ContadorCaF++;
                    break;

                case 2:
                    System.out.println("Resultado: " + fahrenheitACelsius(leer));
                    ContadorFaC++;
                    break;

                case 3:
                    System.out.println("Resultado: " + kmAMillas(leer));
                    ContadorKmaM++;
                    break;

                case 4:
                    System.out.println("Resultado: " + millasAKm(leer));
                    ContadorMaKm++;
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
            }

        } while (opcion != 5);

        int total = ContadorCaF + ContadorFaC + ContadorKmaM + ContadorMaKm;
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + ContadorCaF);
        System.out.println("°F a °C: " + ContadorFaC);
        System.out.println("Km a Millas: " + ContadorKmaM);
        System.out.println("Millas a Km: " + ContadorMaKm);

        leer.close();
    }

    public static double celsiusAFahrenheit(Scanner leer) {
        double c;
        System.out.println("Elegiste °C a °F");
        System.out.println("Ingrese los grados Celsius:");
        while (!leer.hasNextDouble()) {
            System.out.println("Dato inválido, intente de nuevo:");
            leer.next();
        }
        c = leer.nextDouble();
        return (c * 9 / 5) + 32;
    }

    public static double fahrenheitACelsius(Scanner leer) {
        double f;
        System.out.println("Elegiste °F a °C");
        System.out.println("Ingrese los grados Fahrenheit:");
        while (!leer.hasNextDouble()) {
            System.out.println("Dato inválido, intente de nuevo:");
            leer.next();
        }
        f = leer.nextDouble();
        return (f - 32) * 5 / 9;
    }
    public static double kmAMillas(Scanner leer) {
        double km;
        System.out.println("Elegiste Km a Millas");
        System.out.println("Ingrese los kilómetros:");
        while (!leer.hasNextDouble()) {
            System.out.println("Dato inválido, intente de nuevo:");
            leer.next();
        }
        km = leer.nextDouble();
        return km * 0.621371;
    }

    public static double millasAKm(Scanner leer) {
        double millas;
        System.out.println("Elegiste Millas a Km");
        System.out.println("Ingrese las millas:");
        while (!leer.hasNextDouble()) {
            System.out.println("Dato inválido, intente de nuevo:");
            leer.next();
        }
        millas = leer.nextDouble();
        return millas / 0.621371;
    }
}
