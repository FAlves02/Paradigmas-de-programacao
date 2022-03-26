public class Person {
    private String nome;
    private char genero;
    private int idade;

    public Person() {}
    public Person(String n, char g){
        this.nome = n;
        this.genero = g;
    }
    public Person(String n, char g, int i){
        this(n,g);
        this.idade = i;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void falar() {

    }

    public static void main(String[] args) {

    }

}

