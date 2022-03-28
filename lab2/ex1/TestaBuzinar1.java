package ex1;

public class TestaBuzinar1 {
    public static void main(String[] args) {

        Citadino citadino = new Citadino();
        Jipe jipe = new Jipe();
        Familiar familiar = new Familiar();

        citadino.buzinar();
        jipe.buzinar();
        familiar.buzinar();

        /*
        Interpretação do exercício 4: como as 3 classes são subclasses de Carro, quando invocamos o método Buzinar,
        todas as subclasses vão ter como output o que está escrito no método Buzinar em Carro.
         */

        /*
        Interpretação do exercício 6: como os métodos foram "override", o resultado será diferente.
         */

        /*
        Interpretação do exercício 8: como colocámos a instrução "super.buzinar();", iremos ter 6 outputs, sendo eles
        os outputs da classe Carro e os outputs que criámos nas próprias subclasses.
         */

        /*
        Interpretação do exercício 11: para visualizar o resultado do "toString" temos de dar um print da instância.
         */

    }
}
