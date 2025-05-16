package Main;

import TiposConta.ContaBancaria;
import TiposConta.ContaCorrente;
import TiposConta.ContaEspecial;
import java.util.Scanner;


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        System.out.print("Digite quantas contas deseja criar: ");

        ContaBancaria[] contas = new ContaBancaria[sc.nextInt()];
        sc.nextLine();

        criarContas(contas);

       for (int i = 0; i < contas.length; i++) {
            usarConta(contas[i],i+1);
        }


        sc.close();
    }

    public static void usarConta(ContaBancaria conta,int i) {
        int opcao=0;
        while (opcao!=5) {
            System.out.println("Selecione o que quer fazer com a conta "+ i +":\n" +
                    "1- Deposito\n"
                    +           "2- Saque\n"
                    +                   "3- Ver Extrato\n"
                    +                   "4- Alterar Senha\n"
                    +                   "5- Sair\n");

            opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Qual quantia deseja depositar? ");
                    conta.deposito(sc.nextDouble());
                    sc.nextLine();
                    continue;
                case 2:
                    System.out.print("Qual quantia deseja sacar? ");
                    conta.saque(sc.nextDouble());
                    sc.nextLine();
                    continue;
                case 3:
                    conta.extrato();


                    continue;
                case 4:
                    System.out.print("Qual vai ser a nova senha? ");


                    conta.alterarSenha(sc,sc.nextLine());
                    continue;
                case 5: break;
                default:
                    sc.nextLine();
                    System.out.print("Opcao invalida, tente novamente");


            }
        }
    }

    public static void criarContas(ContaBancaria[] contas) {
        int opcao=0;
        for (int i = 1; i <= contas.length; i++) {
            System.out.println("Escolha um tipo conta: \n" +
                    "[1] - Conta Corrente\n" +
                    "[2] - Conta Especial");


            opcao = sc.nextInt();
            sc.nextLine();


            if (opcao == 1) {


                contas[i - 1] = criarContaCorrente();
            }
            else if (opcao == 2) {


                contas[i - 1] = criarContaEspecial();
            } else {
                throw new RuntimeException("Opcao invalida!");
            }


        }
    }

    public static ContaEspecial criarContaEspecial() {
        String senha;
        double limite;


        System.out.println("Digite sua senha: ");
        senha = sc.nextLine();
        System.out.println("Digite seu limite: ");
        limite = sc.nextDouble();

        sc.nextLine();
        return new ContaEspecial(senha, limite);
    }

    public static ContaCorrente criarContaCorrente() {
        System.out.println("Digite a senha da conta: ");
        return new ContaCorrente(sc.nextLine());
    }
}
