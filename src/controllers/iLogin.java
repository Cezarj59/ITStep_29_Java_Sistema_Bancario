package controllers;

public interface iLogin {

    public boolean logon(String usuario, String senha);

    public boolean logof(String usuario);
}
