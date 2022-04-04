import java.util.Timer;
import java.util.TimerTask;

public class Ex3 extends TimerTask {
    String nome;
    int pecasProduzidas = 0;
    Timer timer;
    static int TOTAL_PECAS = 50;

    public Ex3(String nome, Timer timer) {
        this.nome = nome;
        this.timer = timer;
    }

    public void run() {
        if (pecasProduzidas < TOTAL_PECAS) {
            System.out.println(nome + ": " + ++pecasProduzidas);
            if (pecasProduzidas == TOTAL_PECAS) {
                System.out.println(nome + "-Terminei");
                this.cancel();
                timer.cancel();
            }
        }
    }


    public static void main(String[] args) {

        Timer timer = new Timer("manuel");

        TimerTask timerTask = new Ex3("Manuel", timer);
        timer.schedule(timerTask, 1000, 3000);

        TimerTask t2 = new Ex3("pedro", timer);
        timer.schedule(t2, 1000, 5000);

        System.out.println("Main terminado.");
    }
}