public class TestApp {
    public static void main(String[] args) {

        Conta conta = new Conta();

        for (int i = 0; i < 1000; i++) {
            new Movimento(conta, 10, "artur");
        }

        for (int i = 0; i < 1000; i++) {
            new Movimento(conta, 10, "artur");
        }

        System.out.println(conta.getSaldo());

    }
}
