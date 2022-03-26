import java.util.Scanner;

public class UsaPessoa {

    public UsaPessoa() {}

    public static void main(String[] args){

        Person pessoa1 = new Person();
        Scanner s = new Scanner(System.in);
        System.out.print("nome: ");
        String x = s.nextLine();
        System.out.print("idade: ");
        int n = s.nextInt();
        System.out.print("genero: ");
        char g = s.next().charAt(0);

        pessoa1.setNome(x);
        pessoa1.setGenero(g);
        pessoa1.setIdade(n);
        System.out.println(
                "O objeto pessoa1 chama-se "+pessoa1.getNome()+
                        ", é do sexo "+pessoa1.getGenero()+
                        ", tem "+pessoa1.getIdade()+" anos e diz: ");
        pessoa1.falar();

    }
}
