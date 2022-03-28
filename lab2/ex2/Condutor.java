package ex2;

public class Condutor {
    private	String	nome;
    private	int	idade;
    private	int	destreza;

    public	Condutor(){}
    public	void setNome(String	nome){
        this.nome	=	nome;}

    public	void setIdade(int	idade){
        this.idade	=	idade;}

    public	void setDestreza(int	destreza){
        this.destreza	=	destreza;				}

    public	String getNome(){
        return	this.nome;}
    public	int	getIdade(){
        return	this.idade;}
    public	int	getDestreza(){
        return	this.destreza;}
}
