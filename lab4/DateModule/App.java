package DateModule;

import java.util.Scanner;

class Menu extends Thread {

    private Scanner scanner = new Scanner(System.in);
    private Crono cronoThread;

    public Menu() {
        this.cronoThread = new Crono();
    }

    @Override
    public void run() {
        while(true) {
            System.out.print("Input: ");
            String input = scanner.nextLine();
            switch (input) {
                case "run" -> {
                    cronoThread.start();
                }
                case "reset" -> {
                    cronoThread.reset();
                }
                case "pause" -> {
                    cronoThread.pause();
                }
                case "go" -> {
                    cronoThread.go();
                }
                case "view" ->{
                    System.out.println(cronoThread.getDate());
                }
                default -> {
                    System.out.println("Choose a valid option");
                }
            }
        }
    }
}

public class App {
    public static void main(String[] args) {

        Thread menu = new Menu();
        menu.start();

    }
}
