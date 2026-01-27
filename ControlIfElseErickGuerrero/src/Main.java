import java.util.*;
public class Main{
    public static void main(String[] args) {
        int tarifa = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("¿Cual es su edad?");
        int edad = leer.nextInt();
        if (edad < 0 || edad > 120){
            System.out.println("Edad invalida");
            return;
        }
        System.out.println("¿Es usted un estudiante? \n Si = true No = false");
        boolean estudiante = leer.nextBoolean();
        if (edad < 12){
            tarifa = 50;
        }
        else if (edad<=17){
            if (estudiante){
                tarifa = 60;
            }
            else{
                tarifa = 80;
            }
        }
        else if (edad>=18){
            if (estudiante){
                tarifa = 90;}
            else {
                tarifa =120;}


        }
        System.out.println("Usted tiene " + edad + " años");
        if (estudiante){
            System.out.println("Es un estudiante");
        }
        else{
            System.out.println("No es un estudiante");
        }
        System.out.println("Su tarifa es de: " + tarifa);
        leer.close();

    }
}