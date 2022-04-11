package CalendarModule;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CalendarModule.Crono crono = new CalendarModule.Crono();
        while(true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();
            switch (input) {
                case "run" -> {
                    crono.start();
                }
                case "reset" -> {
                    crono.reset();
                }
                case "pause" -> {
                    crono.pause();
                }
                case "go" -> {
                    crono.go();
                }
                case "view" ->{
                    System.out.println(crono.getDate());
                }
                default -> {
                    System.out.println("Choose a valid option");
                }
            }
        }
    }
}
