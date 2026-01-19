import java.util.Scanner;

public class Main {
  public static double PI =3.1416;
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int choice;

    do {
      System.out.println("1. Calcular IMC");
      System.out.println("2. Calcular área de un rectángulo");
      System.out.println("3. Convertir °C a °F");
      System.out.println("4. Calcular área de un círculo");
      System.out.println("5. Salir");
      choice = scanner.nextInt();

      switch (choice) {
        case 1:
          System.out.print("Ingrese su peso (kg): ");
          double peso = scanner.nextDouble();
          System.out.print("Ingrese su altura (m): ");
          double altura = scanner.nextDouble();
          System.out.println("IMC: " + calcularIMC(peso, altura));
          break;

        case 2:
          System.out.print("Ingrese la base: ");
          double base = scanner.nextDouble();
          System.out.print("Ingrese la altura: ");
          double h = scanner.nextDouble();
          System.out.println("Área del rectángulo: " + areaRectangulo(base, h));
          break;

        case 3:
          System.out.print("Ingrese grados Celsius: ");
          double celsius = scanner.nextDouble();
          System.out.println("Grados Fahrenheit: " + celsiusAFahrenheit(celsius));
          break;

        case 4:
          System.out.print("Ingrese el radio: ");
          double radio = scanner.nextDouble();
          System.out.println("Área del círculo: " + areaCirculo(radio));
          break;

        case 5:
          System.out.println("Saliendo del programa...");
          break;

        default:
          System.out.println("Opción inválida. Intente nuevamente.");
      }
      System.out.println();

    } while (choice != 5);

    scanner.close();
  }

  /**
   * Calcula el imc
   * @param peso Peso de la persona en kilogramos.
   * @param altura Altura de la persona en metros.
   * @return El valor del IMC.
   */

  public static double calcularIMC(double peso, double altura) {
    return peso / (altura * altura);
  }

  /**
   * Calcula el área de un rectángulo.
   * @param base Longitud de la base del rectángulo.
   * @param altura Altura del rectángulo.
   * @return El área del rectángulo.
   */

  public static double areaRectangulo(double base, double altura) {
    return base * altura;
  }

  /**
   * Convierte grados Celsius a Fahrenheit.
   * @param celsius Temperatura en grados Celsius.
   * @return Temperatura convertida a grados Fahrenheit.
   */

  public static double celsiusAFahrenheit(double celsius) {
    return (celsius * 1.8) + 32;
  }

  /**
   * Calcula el área de un círculo.
   * @param radio Radio del círculo.
   * @return El área del círculo.
   */

  public static double areaCirculo(double radio) {
    return PI*(radio*radio);
  }
}
