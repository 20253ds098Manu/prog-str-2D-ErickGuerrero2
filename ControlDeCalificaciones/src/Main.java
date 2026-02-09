import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        GradeService servicio = new GradeService();

        //INPUT
        String nombre = leerTextoNoVacio(leer, "¿Cual es su nombre del alumno?");

        double p1 = leerDoubleEnRango(leer, "Introduce la calificacion parcial 1 (0-100)", 0, 100);
        double p2 = leerDoubleEnRango(leer, "Introduce la calificacion parcial 2 (0-100)", 0, 100);
        double p3 = leerDoubleEnRango(leer, "Introduce la calificacion parcial 3 (0-100)", 0, 100);

        int asistencia = leerIntEnRango(leer, "Introduce tu numero de asistencias (0-100)", 0, 100);
        boolean entregoProyecto = leerBoolean(leer, "Entrego el proyecto? (true/false)");

        //PROCESO
        double promedio = servicio.calcularPromedio(p1, p2, p3);
        double calificacionFinal = servicio.calcularFinal(promedio, asistencia);
        String estado = servicio.determinarEstado(calificacionFinal, asistencia, entregoProyecto);

        //OUTPUT
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, entregoProyecto, calificacionFinal, estado);
    }

    //Métodos INPUT

    public static String leerTextoNoVacio(Scanner leer, String msg) {
        while(true) {
            System.out.println(msg);
            String texto = leer.nextLine().trim();
            if(texto.equals("")){
                System.out.println("No puede estar vacio, intente de nuevo");
            } else {
                return texto;
            }
        }
    }

    public static double leerDoubleEnRango(Scanner leer, String msg, double min, double max) {
        while(true){
            System.out.println(msg);
            if(leer.hasNextDouble()){
                double valor = leer.nextDouble();
                if (valor <= max && valor >= min){
                    return valor;
                }
                System.out.println("Valor fuera de rango");
            } else {
                System.out.println("Introduce un valor decimal valido");
                leer.next();
            }
        }
    }

    public static int leerIntEnRango(Scanner leer, String msg, int min, int max) {
        while(true){
            System.out.println(msg);
            if (leer.hasNextInt()){
                int valor = leer.nextInt();
                if (valor <= max && valor >= min){
                    return valor;
                }
                System.out.println("El valor esta fuera del rango");
            } else {
                System.out.println("El valor no es un numero entero");
                leer.next();
            }
        }
    }

    public static boolean leerBoolean(Scanner leer, String msg){
        while(true){
            System.out.println(msg);
            if(leer.hasNextBoolean()){
                return leer.nextBoolean();
            }
            System.out.println("El valor introducido no es booleano (true/false)");
            leer.next();
        }
    }

    //Metodos OUTPUT

    public static void imprimirReporte(String nombre, double p1, double p2, double p3, double prom, int asis, boolean proy, double fin, String est) {
        System.out.println("Alumno: " + nombre);
        System.out.println("Parciales: " + p1 + " - " + p2 + " - " + p3);
        System.out.println("Promedio Parciales: " + prom);
        System.out.println("Asistencia: " + asis);
        System.out.println("Entrego Proyecto: " + proy);
        System.out.println("CALIFICACION FINAL: " + fin);
        System.out.println("ESTADO: " + est);
    }
}