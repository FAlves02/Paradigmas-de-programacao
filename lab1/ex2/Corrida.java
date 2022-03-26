public class Corrida {

    public Corrida(){ }

    public static void main(String[] args) {

        Carro carro1 = new Carro();
        Carro carro2 = new Carro();
        carro1.setMatricula("11-AA-11");
        carro2.setMatricula("22-BB-22");


        Condutor condutor1 = new Condutor();
        Condutor condutor2 = new Condutor();
        condutor1.setNome("Antonio");
        condutor1.setIdade(25);
        condutor1.setDestreza(10);
        condutor2.setNome("Manuel");
        condutor2.setIdade(27);
        condutor2.setDestreza(85);

        carro1.setCondutor(condutor1);
        carro2.setCondutor(condutor2);

        carro1.ligar();
        carro2.ligar();

       if (carro1.isOn() && carro2.isOn()) {
           carro1.acelerar();
           carro2.acelerar();
           carro1.acelerar();
           carro2.travar(2);
           carro1.acelerar();
           carro1.acelerar();
           carro1.travar(20);
           carro2.acelerar();
           System.out.println("Velocidade do carro1: " +
                   carro1.getVelocidadeAtual());
           System.out.println("Velocidade do carro2: " +
                   carro2.getVelocidadeAtual());
           carro1.desligar();
           carro2.desligar();
       }
    }
}
