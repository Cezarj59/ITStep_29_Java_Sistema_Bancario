package models;

import controllers.iLogin;

public class PermitirAcesso implements iLogin {

    private String login;
    private String senha;

    public PermitirAcesso() {
    }

    public PermitirAcesso(String login, String senha) {
        this.login = login;
        this.senha = senha;
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
    public boolean logon(String login, String senha) {

        if (getLogin().equals(login) && getSenha().equals(senha)) {
            System.out.println("Conta conectada!!!");
            return true;
        } else {
            System.out.println("Login ou senha inválido!!!");
            return false;
        }
        
    }

    @Override
    public boolean logof(String usuario) {
        System.out.println("Login desconectado!!!");
        return true;
    }
}
