package ex2;

import ex1.Citadino;
import ex1.Familiar;
import ex1.Jipe;

public class TestaBuzinar1 {
    public static void main(String[] args) {

        ex1.Citadino citadino = new Citadino();
        ex1.Jipe jipe = new Jipe();
        ex1.Familiar familiar = new Familiar();

        citadino.buzinar();
        jipe.buzinar();
        familiar.buzinar();

        /*
        Interpretação do exercício 3: o resultado não foi alterado porque não existe instânciação direta de Carro.
         */

    }
}
