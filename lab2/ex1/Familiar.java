package ex1;

public class Familiar extends Carro{

    public	void desligarAirbagPassageiro(){
        System.out.println("Airbag	desligado!");
    }

    @Override
    public	void buzinar()	{
        toString();
        System.out.println("Buzina	do	familiar");
        super.buzinar();
    }

    @Override
    public String toString() {
        return "familiar";
    }

}
