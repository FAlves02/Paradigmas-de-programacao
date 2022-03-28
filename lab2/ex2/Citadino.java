package ex2;

public class Citadino extends Carro {

    public	void ligarACManual(){
        System.out.println("AC	ligado!");
    }

    @Override
    public	void buzinar()	{
        toString();
        System.out.println("Buzina	do	citadino");
    }

    @Override
    public String toString() {
        return "citadino";
    }
}
