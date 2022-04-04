public class Ex2 extends Thread implements Runnable{
    String nome;
    int delay;
    int pecasProduzidas = 0;
    static int TOTAL_PECAS = 50;

    public Ex2(String nome, int delay) {
        this.nome = nome;
        this.delay = delay;
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


        Funcionario manuel = new Funcionario("Manuel", 3000);
        Funcionario pedro = new Funcionario("\tPedro", 5000);

        Thread t1 = new Thread(manuel);
        t1.start();

        Thread t2 = new Thread(pedro);
        t2.start();

        System.out.println("Main terminado.");
    }
}