package controllers;

import services.*;
import java.sql.*;
import java.util.ArrayList;
import models.ContaCorrente;

public class ControllerContaCorrente {

    public static ContaCorrente cadastrar() {
        ContaCorrente d = new ContaCorrente();
        System.out.println("\nCADASTRAR Conta Corrente\n");

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

    public static void add(ContaCorrente d) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "INSERT INTO contaCorrente (senha,login,nome,agencia,conta,saldo) VALUES (?,?,?,?,?,?)";

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, d.getSenha());
            statement.setString(2, d.getLogin());
            statement.setString(3, d.getNome());
            statement.setString(4, d.getAgencia());
            statement.setString(5, d.getConta());
            statement.setDouble(6, d.getSaldo());

            if (statement.executeUpdate() > 0) {
                System.out.println("\n--------------------------------");
                System.out.println("Conta Corrente Cadastrado com Sucesso!!!");
                System.out.println("--------------------------------\n");
            } else {
                System.err.println("\n------------------------------");
                System.err.println("Falha ao Cadastrar o Conta Corrente!!!");
                System.err.println("------------------------------\n");
            }

        } catch (SQLException e) {
            System.err.println(e);
        }

        BancoDados.fecha(conn);
    }

    public ArrayList<ContaCorrente> getAll() {
        ArrayList<ContaCorrente> lista = new ArrayList<>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM contaCorrente";
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new ContaCorrente(
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

    public ArrayList<ContaCorrente> getConta(String login, String senha) {
        ArrayList<ContaCorrente> lista = new ArrayList<>();
        Connection conn = BancoDados.conectar();

        try {
            String sql = "SELECT * FROM contaCorrente WHERE login = '" + login + "' && senha = " + senha;
            Statement statement = conn.createStatement();

            ResultSet resultado = statement.executeQuery(sql);

            while (resultado.next()) {
                lista.add(new ContaCorrente(
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

    public ContaCorrente recebeDeposito(ArrayList<ContaCorrente> lista) {

        ContaCorrente d = lista.get(0);
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

    public ContaCorrente recebeSaque(ArrayList<ContaCorrente> lista) {

        ContaCorrente d = lista.get(0);
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

    public void altera(ContaCorrente d) {
        Connection conn = BancoDados.conectar();

        try {
            String sql = "UPDATE contaCorrente "
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
