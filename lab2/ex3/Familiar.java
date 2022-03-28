package ex3;

public class Familiar extends Carro {

    public	void desligarAirbagPassageiro(){
        System.out.println("Airbag	desligado!");
    }

    @Override
    public	void buzinar()	{
        toString();
        System.out.println("Buzina	do	familiar");
    }

    @Override
    public String toString() {
        return "familiar";
    }

}
