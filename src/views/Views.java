package views;

import java.util.ArrayList;
import models.*;
import static services.Constante.*;
import services.Receber;

public class Views {

    public static String user() {
        System.out.println("\nInforme Login e Senha da Conta.");
        System.out.print("Digite o Login: ");
        String user = Receber.texto();
        return user;

    }

    public static String senha() {
        System.out.print("Digite a Senha: ");
        String senha = Receber.texto();
        return senha;
    }

    public static void consultaPJTodos() {
        ArrayList<ContaPJ> conta = contaPJ.getAll();
        System.out.println("\n----Consulta Conta PJ----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta PJ Cadastrados!!!\n");
        } else {
            for (ContaPJ c : conta) {
                System.out.println(c.toString());

            }
        }

    }

    public static void consultaCorrenteTodos() {
        ArrayList<ContaCorrente> conta = contaCorrente.getAll();
        System.out.println("\n----Consulta Conta Corrente----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta Corrente Cadastrados!!!\n");
        } else {
            for (ContaCorrente c : conta) {
                System.out.println(c.toString());

            }
        }

    }

    public static void consultaPoupancaTodos() {
        ArrayList<ContaPoupanca> conta = contaPoupanca.getAll();
        System.out.println("\n----Consulta Conta Poupança----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta Poupança Cadastrados!!!\n");
        } else {
            for (ContaPoupanca c : conta) {
                System.out.println(c.toString());

            }
        }

    }

    public static void consultaSaldoPJ(String login, String senha) {
        ArrayList<ContaPJ> conta = contaPJ.getConta(login, senha);
        System.out.println("\n----Consulta Conta PJ----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta PJ Cadastrados!!!\n");
        } else {
            for (ContaPJ c : conta) {
                System.out.println(c.toString());

            }
        }

    }

    public static void consultaSaldoCorrente(String login, String senha) {
        ArrayList<ContaCorrente> conta = contaCorrente.getConta(login, senha);
        System.out.println("\n----Consulta Conta Corrente----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta Corrente Cadastrados!!!\n");
        } else {
            for (ContaCorrente c : conta) {
                System.out.println(c.toString());

            }
        }

    }

    public static void consultaSaldoPoupanca(String login, String senha) {
        ArrayList<ContaPoupanca> conta = contaPoupanca.getConta(login, senha);
        System.out.println("\n----Consulta Conta Poupança----");
        if (conta.isEmpty()) {
            System.out.println("\nNão há Conta Poupança Cadastrados!!!\n");
        } else {
            for (ContaPoupanca c : conta) {
                System.out.println(c.toString());

            }
        }

    }

}


