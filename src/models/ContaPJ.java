package models;

import controllers.iConta;
import controllers.iLogin;
import services.Receber;

public class ContaPJ extends Conta implements iConta, iLogin {

    private String senha;
    private String login;

    public ContaPJ() {
    }

    public ContaPJ(String senha, String login) {
        this.senha = senha;
        this.login = login;
    }

    public ContaPJ(String senha, String login, int id, String nome, String agencia, String conta, double saldo) {
        super(id, nome, agencia, conta, saldo);
        this.senha = senha;
        this.login = login;
    }

    public ContaPJ(int id, String nome, String agencia, String conta, double saldo) {
        super(id, nome, agencia, conta, saldo);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public double getSaldo() {
        return super.getSaldo();
    }

    @Override
    public double sacar(double valor) {

        if (super.getSaldo() >= valor) {

            return super.getSaldo() - valor;

        } else {
            System.err.println("Saldo insuficiente para realizar o saque!");
        }

        return super.getSaldo();
    }

    @Override
    public double depositar(double valor) {
        if (valor >= 0) {
            return getSaldo() + valor;

        } else {
            System.err.println("Impossível depositar valor negativo!");
            return getSaldo();

        }
    }

    @Override
    public boolean logon(String login, String senha) {

        if (this.login.equals(getLogin()) && this.senha.equals(getSenha())) {
            System.out.println("Conta conectada!!!");
            return true;
        } else {
            System.out.println("Login ou senha inválido!!!");
            return false;

        }

    }

    @Override
    public boolean logof(String login) {
        System.out.println("Login desconectado!!!");
        return true;

    }

    @Override
    public String toString() {
        return "\nNome: " + getNome()
                + "\nAgencia: " + getAgencia()
                + "\nConta: " + getConta()
                + "\nSaldo: " + getSaldo();
    }

}
