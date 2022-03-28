package ex3;

public class Jipe extends Carro {

    public	void ligarTracao4x4(){
        System.out.println("Tração	ligada!");
    }

    @Override
    public	void buzinar()	{
        toString();
        System.out.println("Buzina	do	jipe");
    }

    @Override
    public String toString() {
        return "jipe";
    }

}
