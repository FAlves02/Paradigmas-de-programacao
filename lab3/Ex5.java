import java.util.Scanner;

class Counter implements Runnable {

    int begin;
    int delay;

    public Counter(int begin, int delay) {
        this.begin = begin;
        this.delay = delay;
    }

    @Override
    public void run() {
        while(begin > 0) {
            try {
                Thread.sleep(delay);
                System.out.println(Thread.currentThread().getName() + ": " + --begin);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println( "End of: " + Thread.currentThread().getName() );
    }
}



public class Ex5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Num1: ");
        Counter c1 = new Counter(scanner.nextInt(), 1000);
        System.out.print("Num2: ");
        Counter c2 = new Counter(scanner.nextInt(), 500);
        System.out.print("Num3: ");
        Counter c3 = new Counter(scanner.nextInt(), 250);

        Thread t1 = new Thread(c1);
        t1.start();

        Thread t2 = new Thread(c2);
        t2.start();

        Thread t3 = new Thread(c3);
        t3.start();

        Thread running = new Thread(() -> {
            while(t1.isAlive() || t2.isAlive() || t3.isAlive()) {
                try {
                    Thread.sleep(350);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("End of Countdown.");
        });
        running.start();

    }


}
