package controllers;

import java.sql.*;
import java.util.ArrayList;
import models.ContaPJ;
import services.*;

public class ControllerContaPJ {

    public static ContaPJ cadastrar() {
        ContaPJ d = new ContaPJ();
        System.out.println("\nCADASTRAR Conta PJ\n");

        System.out.print("Informe o Nome: ");
        d.setNome(Receber.texto());
        System.out.print("Informe a Agência: ");
        d.setAgencia(Receber.texto());
        System.out.print("Informe a Conta: ");
        d.setConta(Receber.texto());
        System.out.print("Informe o Login: ");
        d.setLogin(Receber.texto());
        System.out.print("Informe a Senha: ");
        d.setSenha(Receber.texto());
        return d;
    }

    public static void add(ContaPJ d) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO contaPJ (senha,login,nome,agencia,conta,saldo) VALUES (?,?,?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, d.getSenha());
            statement.setString(2, d.getLogin());
            statement.setString(3, d.getNome());
            statement.setString(4, d.getAgencia());
            statement.setString(5, d.getConta());
            statement.setDouble(6, d.getSaldo());

            if (statement.executeUpdate() > 0) {
                System.out.println("\n--------------------------------");
                System.out.println("Conta PJ Cadastrado com Sucesso!!!");
                System.out.println("--------------------------------\n");
            } else {
                System.err.println("\n------------------------------");
                System.err.println("Falha ao Cadastrar o Conta PJ!!!");
                System.err.println("------------------------------\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);
    }

    public ArrayList<ContaPJ> getAll() {
        ArrayList<ContaPJ> lista = new ArrayList<>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM contaPJ";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new ContaPJ(
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("agencia"),
                        resultado.getString("conta"),
                        resultado.getDouble("saldo")
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }

    public ArrayList<ContaPJ> getConta(String login, String senha) {
        ArrayList<ContaPJ> lista = new ArrayList<>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM contaPJ WHERE login = '" + login + "' && senha = "+ senha;
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new ContaPJ(
                        resultado.getString("senha"),
                        resultado.getString("login"),
                        resultado.getInt("id"),
                        resultado.getString("nome"),
                        resultado.getString("agencia"),
                        resultado.getString("conta"),
                        resultado.getDouble("saldo")
                ));

            }

        } catch (SQLException e) {
            System.out.println("ERRO AO BUSCAR: " + e);
        }

        BancoDados.fecha(conn);

        return lista;
    }

    public ContaPJ recebeDeposito(ArrayList<ContaPJ> lista) {

        ContaPJ d = lista.get(0);
        System.out.print("Digite o valor do deposito: ");
        double deposito = Receber.numeroDecimal();

        d.setId(d.getId());
        d.setNome(d.getNome());
        d.setAgencia(d.getAgencia());
        d.setConta(d.getConta());
        d.setLogin(d.getLogin());
        d.setSenha(d.getSenha());
        d.setSaldo(d.depositar(deposito));

        return d;
    }
    
     public ContaPJ recebeSaque(ArrayList<ContaPJ> lista) {

        ContaPJ d = lista.get(0);
        System.out.print("Digite o valor do Saque: ");
        double saque = Receber.numeroDecimal();

        d.setId(d.getId());
        d.setNome(d.getNome());
        d.setAgencia(d.getAgencia());
        d.setConta(d.getConta());
        d.setLogin(d.getLogin());
        d.setSenha(d.getSenha());
        d.setSaldo(d.sacar(saque));

        return d;
    }

    public void altera(ContaPJ d) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "UPDATE contaPJ "
                    + "SET nome = ?, "
                    + "agencia = ?, "
                    + "conta = ?, "
                    + "login = ?, "
                    + "senha = ?, "
                    + "saldo = ? "
                    + "WHERE id = ? ";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, d.getNome());
            statement.setString(2, d.getAgencia());
            statement.setString(3, d.getConta());
            statement.setString(4, d.getLogin());
            statement.setString(5, d.getSenha());
            statement.setDouble(6, d.getSaldo());
            statement.setInt(7, d.getId());

            if (statement.executeUpdate() > 0) {
                System.out.println("\n--------------------------------");
                System.out.println("Operação efetuada com Sucesso!!!");
                System.out.println("--------------------------------\n");
            } else {
                System.err.println("\n------------------------------");
                System.err.println("Falha ao efetuar a Operação!!!");
                System.err.println("------------------------------\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);
    }
}
