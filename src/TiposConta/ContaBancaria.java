package TiposConta;
import java.util.Scanner;


public abstract class ContaBancaria {
    protected String senha;
    protected double saldo = 0;
    protected int numero;


    public abstract void saque(double valor);

    public abstract void deposito(double valor);

    public abstract void extrato();

    public void alterarSenha(Scanner sc, String senha) {
        System.out.println("Digite a senha anterior: ");
        if (sc.nextLine().equals(this.senha)) {
            this.senha = senha;
        } else {
            System.out.println("Senha incorreta!");
        }
    }
}
