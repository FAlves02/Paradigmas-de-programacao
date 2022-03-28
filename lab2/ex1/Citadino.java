package ex1;

public class Citadino extends Carro {

    public	void ligarACManual(){
        System.out.println("AC	ligado!");
    }

    @Override
    public	void buzinar()	{
        toString();
        System.out.println("Buzina	do	citadino");
        super.buzinar();
    }

    @Override
    public String toString() {
        return "citadino";
    }
}
