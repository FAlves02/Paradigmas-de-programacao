import java.util.Scanner;

public class FazCalculo2 {

    public static double askInput(String param) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduza o valor de " + param + ": ");
        return scanner.nextDouble();
    }

    public static void main(String[] args) {
        double a = askInput("a");
        double b = askInput("b");
        Calculadora calc = new Calculadora(a, b);
        System.out.println(calc);

    }

}
