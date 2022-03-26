
public class Calculadora {

    private double a;
    private double b;

    public Calculadora(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double soma(double a, double b){
        return a + b;
    }
    public double soma(){
        return a + b;
    }

    public double sub(double a, double b){
        return a - b;
    }

    public double sub(){
        return a - b;
    }

    public double div(double a, double b){
        return a * b;
    }

    public double div(){
        return a * b;
    }

    public double mult(double a, double b){
        return a / b;
    }

    public double mult(){
        return a / b;
    }

    @Override
    public String toString() {
        return "Calculadora{" +
                "soma: " + soma(a, b) +
                ", sub: " + sub(a, b) +
                ", mult: " + mult(a, b) +
                ", div: " + div(a, b) +
                '}';
    }
}
