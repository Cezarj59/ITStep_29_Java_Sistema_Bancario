package models;

import controllers.iConta;
import controllers.iLogin;
import services.Receber;

public class ContaPoupanca extends Conta implements iConta {

    private String senha;
    private String login;

    public ContaPoupanca() {
    }

    public ContaPoupanca(String senha, String login) {
        this.senha = senha;
        this.login = login;
    }

    public ContaPoupanca(String senha, String login, int id, String nome, String agencia, String conta, double saldo) {
        super(id, nome, agencia, conta, saldo);
        this.senha = senha;
        this.login = login;
    }

    public ContaPoupanca(int id, String nome, String agencia, String conta, double saldo) {
        super(id, nome, agencia, conta, saldo);
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    
    

   
    @Override
    public double getSaldo() {
        return super.getSaldo();
    }

    @Override
    public double sacar(double valor) {

        if (super.getSaldo() >= valor) {
            System.out.println("\n\nSaque efetuado com sucesso!\n\n");
            return super.getSaldo() - valor;

        } else {
            System.err.println("Saldo insuficiente para realizar o saque!");
            return super.getSaldo();
        }

    }

    @Override
    public double depositar(double valor) {
        if (valor >= 0) {
            System.err.println("\n$$$ Deposito Efetuado com Sucesso!!! $$$\n");
            return super.getSaldo() + valor;

        } else {
            System.err.println("Impossível depositar valor negativo!");
            return super.getSaldo();
        }

    }

  
    
    @Override
    public String toString() {
        return "\nNome: " + getNome()
                + "\nAgencia: " + getAgencia()
                + "\nConta: " + getConta()
                + "\nSaldo: " + getSaldo();
    }
}
