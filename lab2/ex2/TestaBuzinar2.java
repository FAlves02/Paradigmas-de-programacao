package ex2;

import ex1.Citadino;
import ex1.Familiar;
import ex1.Jipe;

import java.util.Scanner;

public class TestaBuzinar2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("indique o nome da subclasse (citadino, familiar ou jipe): ");
        String subclass = scanner.nextLine();
        switch (subclass) {
            case "citadino" -> {
                ex1.Citadino citadino = new Citadino();
//                citadino.buzinar();
                citadino.ligarACManual();
            }
            case "familiar" -> {
                ex1.Familiar familiar = new Familiar();
//                familiar.buzinar();
                familiar.desligarAirbagPassageiro();
            }
            case "jipe" -> {
                ex1.Jipe jipe = new Jipe();
//                jipe.buzinar();
                jipe.ligarTracao4x4();
            }
            default -> System.out.println("opção indisponível.");
        }
    }
}

        /*
        Interpretação do exercício 6: como o método "buzinar" de Carro é abstrato, as subclasses de Carro são obrigadas a implementar
        o mesmo.
         */