public class Conta {

    private int saldo;

    public Conta() {
        saldo = 1000;
    }

    public synchronized void movimento(int valor, String nome){
        new Movimento(this, valor, nome);
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
