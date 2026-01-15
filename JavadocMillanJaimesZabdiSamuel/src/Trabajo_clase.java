import java.util.Scanner;

public class Trabajo_clase {
    /**
     * -Requisitos obligatorios:
     * Debes tener mínimo 4 métodos, uno por operación (IMC, área rectángulo, área
     * círculo , conversión, y una opción para salir -> 4) .
     * Cada método debe tener Javadoc completo con:
     * Descripción (1–2 líneas)
     * 
     * @param para cada parámetro
     * @return si aplica
     */
    public static void main(String[] args) {
        System.out.println("Este es un ejemplo de Javadoc.");
        Scanner sc = new Scanner(System.in);
        int choice;

        do {

            System.out.println("Menu:");
            System.out.println("1. IMC");
            System.out.println("2. Area Rectángulo");
            System.out.println("3. Area Círculo");
            System.out.println("4. Conversión");
            System.out.println("5. Salir");
            System.out.print("QUE OBCION ELIGIREMOS: ");

            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("seleccionaste la Option de IMC .");
                    double pesoKg = obtenerP(sc, "Ingresa el peso en KG:");
                    double alturaM = optenerA(sc, "Ingresa la altura en M -> 1.80:");
                    double IMC = calcularIMC(pesoKg, alturaM);
                    System.out.println("IMC: " + IMC);
                    break;
                case 2:
                    System.out.println("selecteccionaste Option Area de Rectangulo.");
                    System.out.println("El area del rectangulo es: " + areaRectangulo(sc, "Ingresa la base:", "Ingresa la altura:"));
                    break;
                case 3:
                    System.out.println("seleccionaste Option Area de Circulo.");
                    System.out
                            .println("El area del circulo es: " + areaCirculo(sc, "Ingresa el radio del circulo:"));
                    break;
                case 4:
                    System.out.println("seleccionaste Option de Conversion.");
                    conversion(sc, "Ingresa los metros a convertir:");
                    break;
                case 5:
                    System.out.println("Salir del programa...");
                    break;
                default:
                    System.out.println("Error: Opcion invalida .");
            }
            System.out.println();

        } while (choice != 5);
    }
    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc
     * @param mensaje
     * @return
     */
    public static double obtenerP(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }
    /**
     * Metodo que retorna un valor capturado por terminal
     * @param sc
     * @param mensaje
     * @return
     */
    public static double optenerA(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        return sc.nextDouble();
    }
    /**
     * Metodo que devuelve el IMC con formula -> peso/altura²
     * @param pesoKg
     * @param alturaM
     * @return
     */
    public static double calcularIMC(double pesoKg, double alturaM) {
        return pesoKg / (alturaM * alturaM);
    }
    /**
     * Metodo que calcula el area de un rectangulo
     * @param sc
     * @param baseMsg
     * @param alturaMsg
     * @return
     */
    public static double areaRectangulo(Scanner sc, String baseMsg, String alturaMsg) {
        System.out.println(baseMsg);
        double base = sc.nextDouble();
        System.out.println(alturaMsg);
        double altura = sc.nextDouble();
        return base * altura;
    }
    /**
     * Metodo que calcula el area de un circulo
     * @param sc
     * @param mensaje
     * @return
     */
    public static double areaCirculo(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        double radio = sc.nextDouble();
        return Math.PI * radio * radio;
    }
    /**
     * Metodo que convierte metros a centimetros
     * @param sc
     * @param mensaje
     */
    public static void conversion(Scanner sc, String mensaje) {
        System.out.println(mensaje);
        double metros = sc.nextDouble();
        double centimetros = metros * 100;
        System.out.println(metros + " metros son " + centimetros + " centimetros.");
    }

}