// feito por enzo

class Func implements Runnable {
    String nome;
    int delay;
    int pecasProduzidas = 0;
    static int TOTAL_PECAS = 50;

    public Func(String nome, int delay) {
        this.nome = nome;
        this.delay = delay;
    }

    public void trabalhar() {
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

    @Override
    public void run() {
        trabalhar();
    }


}

public class Ex2 {
    public static void main(String[] args) {
        Func manuel = new Func("Manuel", 3000);
        Func pedro = new Func("Pedro", 5000);
        Thread threadManuel = new Thread(manuel);
        threadManuel.start();
        Thread threadPedro = new Thread(pedro);
        threadPedro.start();
    }

}

