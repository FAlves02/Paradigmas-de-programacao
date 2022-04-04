import java.util.Timer;
import java.util.TimerTask;

public class Ex4 extends Thread {
    String nome;
    int pecasProduzidas = 0;
    int delay;
    static int TOTAL_PECAS = 50;

    public Ex4(String nome, int delay) {
        this.nome = nome;
        this.delay = delay;
    }

    public int getPecasProduzidas() {
        return pecasProduzidas;
    }

    public void run() {
        System.out.println(nome + " - Comecei.");
        while (pecasProduzidas < TOTAL_PECAS) {
            try {
                Thread.sleep(delay);
                System.out.println(nome + ": " + ++pecasProduzidas);
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        System.out.println(nome + " -Terminei.");
    }


    public static void main(String[] args) {

        Ex4 manuel = new Ex4("Manuel", 500);
        Ex4 pedro = new Ex4("Pedro", 300);

        Thread t0 = new Thread(manuel);
        t0.setDaemon(true);
        t0.start();

        Thread t1 = new Thread(pedro);
        t1.setDaemon(true);
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Peças do pedro: " + pedro.getPecasProduzidas() + " Peças do manunel: " + manuel.getPecasProduzidas());

        System.out.println("Main terminado.");
    }
}