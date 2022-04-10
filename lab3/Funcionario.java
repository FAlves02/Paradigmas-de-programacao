public class Funcionario extends Thread {
    String nome;
    int delay;
    int pecasProduzidas = 0;
    static int TOTAL_PECAS = 50;

    public Funcionario(String nome, int delay) {
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