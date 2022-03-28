package ex1;

import java.util.Scanner;

public class TestaBuzinar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("indique o nome da subclasse (citadino, familiar ou jipe): ");
        String subclass = scanner.nextLine();
        switch (subclass) {
            case "citadino" -> {
                Citadino citadino = new Citadino();
//                citadino.buzinar();
                citadino.ligarACManual();
            }
            case "familiar" -> {
                Familiar familiar = new Familiar();
//                familiar.buzinar();
                familiar.desligarAirbagPassageiro();
            }
            case "jipe" -> {
                Jipe jipe = new Jipe();
//                jipe.buzinar();
                jipe.ligarTracao4x4();
            }
            default -> System.out.println("opção indisponível.");
        }
    }
}