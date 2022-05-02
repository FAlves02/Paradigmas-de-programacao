public class Movimento extends Thread{

    private Conta conta;
    private int valor;
    private String nomeUtilizador;

    public Movimento(Conta conta, int valor, String nomeUtilizador) {
        this.conta = conta;
        this.valor = valor;
        this.nomeUtilizador = nomeUtilizador;
        start();
    }

    public void run() {
        synchronized (conta) {
            conta.setSaldo(
                    conta.getSaldo() + valor
            );
        }
    }

}
