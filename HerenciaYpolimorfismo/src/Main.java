public class Main {

    public static void main(String[] args) {

        perro dogo = new perro("Dogo");
        gato rawrl = new gato("rawrl");

        dogo.comer();
        dogo.hacerSonido();
        dogo.marcarTerritorio();

        rawrl.comer();
        rawrl.hacerSonido();


        animal[] animales = new animal[3];
        animales[0] = new perro("Ramonchis");
        animales[1] = new gato("Salem");
        animales[2] = new perro("Firulais");
        for (animal animal : animales) {
            animal.hacerSonido();
        }

        System.out.println("--------------");
        animal miercoles = new perro("Miercoles");

        if (miercoles instanceof perro) {
            perro miercoles1 = (perro) miercoles;
            miercoles1.marcarTerritorio();
        }
    }
}