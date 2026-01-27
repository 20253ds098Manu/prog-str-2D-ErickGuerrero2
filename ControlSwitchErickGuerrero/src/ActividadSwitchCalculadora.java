import java.util.*;
public class ActividadSwitchCalculadora {
    public static void main(String[] args){
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Que desea hacer?");
        System.out.println(" 1) Sumar\n 2) Restar\n 3) Multiplicar\n 4) Dividir ");
        int opcion = leer.nextInt();
        if (opcion > 4 || opcion < 0){
            System.out.println("Opcion no valida");
            return;
        }
        switch (opcion) {
            case 1:
                System.out.println("El resultado de su operación es: "+ suma(leer));
                break;
            case 2:
                System.out.println("El resultado de su operación es: "+ resta(leer));
                break;
            case 3:
                System.out.println("El resultado de su operación es: "+ multiplicar(leer));
                break;
            case 4:
                System.out.println("El resultado de su operación es: "+ dividir(leer));
                break;
        }

    }
    public static double suma(Scanner leer){
        double variablea, variableb = 0;
        System.out.println("Elegiste la suma");
        System.out.println("¿Cual es el primer digito para su operacion?");
        variablea = leer.nextDouble();
        System.out.println("¿Cual es el segundo digito para su operacion?");
        variableb = leer.nextDouble();
        return variablea+variableb;
    }
    public static double resta(Scanner leer){
        double variablea, variableb = 0;
        System.out.println("Elegiste la resta");
        System.out.println("¿Cual es el primer digito para su operacion?");
        variablea = leer.nextDouble();
        System.out.println("¿Cual es el segundo digito para su operacion?");
        variableb = leer.nextDouble();
        return variablea-variableb;
    }
    public static double multiplicar(Scanner leer){
        double variablea, variableb = 0;
        System.out.println("Elegiste multiplicar");
        System.out.println("¿Cual es el primer digito para su operacion?");
        variablea = leer.nextDouble();
        System.out.println("¿Cual es el segundo digito para su operacion?");
        variableb = leer.nextDouble();
        return variablea*variableb;
    }
    public static double dividir(Scanner leer){
        double variablea, variableb = 0;
        System.out.println("Elegiste la divición");
        System.out.println("¿Cual es el primer digito para su operacion?");
        variablea = leer.nextDouble();
        System.out.println("¿Cual es el segundo digito para su operacion?");
        variableb = leer.nextDouble();
        if (variableb==0){
            System.out.println("No se puede dividir entre 0");
            return 0;
        }
        return variablea/variableb;
    }
}