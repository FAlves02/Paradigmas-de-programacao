public class Carro {

    private String matricula;
    private int velocidadeAtual = 0;
    private final int velocidadeMaxima = 200;
    private boolean on = false;
    private Condutor condutor;



    public void ligar() {
        System.out.println("VRUMMMMMMMMMMMM");
        on = true;
    }

    public void desligar() {
        System.out.println("MMMmmmmm");
        on = false;
    }

    public void acelerar() {
        if(on){
            velocidadeAtual +=  (int) ((int) velocidadeAtual + condutor.getDestreza() * 0.10);
            if (velocidadeAtual > velocidadeMaxima)
                velocidadeAtual = velocidadeMaxima;
        }
    }

    public boolean isOn() {
        return on;
    }

    public void travar(int intensidadeTravagem) {
        if(on) {
            if (intensidadeTravagem > velocidadeMaxima)
                intensidadeTravagem = velocidadeMaxima;
            else if (intensidadeTravagem < 0)
                intensidadeTravagem = 0;
            velocidadeAtual -= intensidadeTravagem;
            if (velocidadeAtual > velocidadeMaxima)
                velocidadeAtual = velocidadeMaxima;
            else if (velocidadeAtual < 0)
                velocidadeAtual = 0;
        }
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    public void setVelocidadeAtual(int velocidadeAtual) {
        this.velocidadeAtual = velocidadeAtual;
    }

    public int getVelocidadeMaxima() {
        return velocidadeMaxima;
    }
}
