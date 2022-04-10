//feito por artur

public class Ex1 {
    public static void main(String[] args) {
        Funcionario manuel = new Funcionario("Manuel", 3000);
        Funcionario pedro = new Funcionario("Pedro", 5000);
        manuel.start();
        pedro.start();
    }
}