
// feito por artur e enzo

import java.util.Scanner;


class Contador extends Thread {

    private int n;

    public Contador(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        while(n >= 0) {
            System.out.println(Thread.currentThread().getName() + ": " + n--);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}


public class Ex5 {

    public static int askUser(String msg) {
        System.out.print(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {

        int n1 = askUser("Num1: ");
        int n2 = askUser("Num2: ");
        int n3 = askUser("Num3: ");

        Thread c1 = new Contador(n1);
        c1.start();

        Thread c2 = new Contador(n2);
        c2.start();

        Thread c3 = new Contador(n3);
        c3.start();

        while(c1.isAlive() || c2.isAlive() || c3.isAlive()) {

        }
        System.out.println( "Contadores a zero." );

    }

}
