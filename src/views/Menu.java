package views;

import controllers.ControllerContaCorrente;
import controllers.ControllerContaPJ;
import controllers.ControllerContaPoupanca;
import models.PermitirAcesso;
import static services.Constante.*;
import services.Receber;
import static views.Views.*;

public class Menu {

    protected static void inicio() {
        PermitirAcesso chave = new PermitirAcesso();
        chave.setLogin("admin");
        chave.setSenha("0000");
        String login = user();
        String senha = senha();

        if (chave.logon(login, senha)) {
            while (true) {
                System.out.println("\n-----------------------------");
                System.out.println("-------------Banco--------------");
                System.out.println("-----------------------------\n");

                System.out.println("(0) #- SAIR -#");
                System.out.println("(1) Cadastrar");
                System.out.println("(2) Consultar Contas");
                System.out.println("(3) Sacar");
                System.out.println("(4) Depositar");
                System.out.println("(5) Consultar Saldo");

                System.out.print("\nInforme a opção desejada: ");

                switch (Receber.inteiro()) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        cadastrar();
                        break;
                    case 2:
                        consultar();
                        break;
                    case 3:
                        saque();
                        break;
                    case 4:
                        deposito();
                        break;
                    case 5:
                        saldo();
                        break;

                    default:
                        System.out.println("\nOpção Invalida!!!\n");

                }
            }
        } else {
            System.out.println("Acesso não Permitido");
        }

    }

    protected static void cadastrar() {
        System.out.println("\n-----------------------------");
        System.out.println("----------CADASTRO-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Conta PJ");
        System.out.println("(2) Conta Poupança");
        System.out.println("(3) Conta Corrente");
        System.out.println("(0) Voltar");
        System.out.print("\nInforme a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 ->
                ControllerContaPJ.add(ControllerContaPJ.cadastrar());

            case 2 ->
                ControllerContaPoupanca.add(ControllerContaPoupanca.cadastrar());

            case 3 ->
                ControllerContaCorrente.add(ControllerContaCorrente.cadastrar());

            case 0 ->
                inicio();
            default -> {
                System.out.println("\nOpção Invalida!!!\n");

            }
        }
    }

    protected static void consultar() {
        System.out.println("\n-----------------------------");
        System.out.println("----------CONSULTA-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Contas PJ");
        System.out.println("(2) Contas Poupança");
        System.out.println("(3) Contas Corrente");
        System.out.println("(0) Voltar");
        System.out.print("\nInforme a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 ->
                consultaPJTodos();
            case 2 ->
                consultaPoupancaTodos();
            case 3 ->
                consultaCorrenteTodos();
            case 0 ->
                inicio();
            default -> {
                System.out.println("\nOpção Invalida!!!\n");

            }
        }
    }

    protected static void saque() {
        System.out.println("\n-----------------------------");
        System.out.println("----------Saque-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Saque em Conta PJ");
        System.out.println("(2) Saque em Conta Poupança");
        System.out.println("(3) Saque em Conta Corrente");
        System.out.println("(0) Voltar");
        System.out.print("\nInforme a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 ->

                contaPJ.altera(contaPJ.recebeSaque(contaPJ.getConta(user(), senha())));

            case 2 ->

                contaPoupanca.altera(contaPoupanca.recebeSaque(contaPoupanca.getConta(user(), senha())));

            case 3 ->
                contaCorrente.altera(contaCorrente.recebeSaque(contaCorrente.getConta(user(), senha())));

            case 0 ->
                inicio();
            default -> {
                System.out.println("\nOpção Invalida!!!\n");

            }
        }
    }

    protected static void deposito() {
        System.out.println("\n-----------------------------");
        System.out.println("----------Deposito-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Deposito em Conta PJ");
        System.out.println("(2) Deposito em Conta Poupança");
        System.out.println("(3) Deposito em Conta Corrente");
        System.out.println("(0) Voltar");
        System.out.print("\nInforme a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 ->

                contaPJ.altera(contaPJ.recebeDeposito(contaPJ.getConta(user(), senha())));

            case 2 ->

                contaPoupanca.altera(contaPoupanca.recebeDeposito(contaPoupanca.getConta(user(), senha())));

            case 3 ->

                contaCorrente.altera(contaCorrente.recebeDeposito(contaCorrente.getConta(user(), senha())));

            case 0 ->
                inicio();
            default -> {
                System.out.println("\nOpção Invalida!!!\n");

            }
        }
    }

    protected static void saldo() {
        System.out.println("\n-----------------------------");
        System.out.println("----------SALDO-----------");
        System.out.println("-----------------------------\n");

        System.out.println("(1) Conta PJ");
        System.out.println("(2) Conta Poupança");
        System.out.println("(3) Conta Corrente");
        System.out.println("(0) Voltar");
        System.out.print("\nInforme a opção desejada: ");

        switch (Receber.inteiro()) {

            case 1 ->
                consultaSaldoPJ(user(), senha());
            case 2 ->
                consultaSaldoPoupanca(user(), senha());

            case 3 ->
                consultaSaldoCorrente(user(), senha());

            case 0 ->
                inicio();
            default -> {
                System.out.println("\nOpção Invalida!!!\n");

            }
        }
    }

}
