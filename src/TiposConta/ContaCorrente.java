package TiposConta;


public class ContaCorrente extends ContaBancaria {

    protected int qntdTransacoes;

    public ContaCorrente(String senha) {
        this.senha = senha;
    }

    @Override
    public void saque(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente");
        }
        qntdTransacoes++;
    }

    public void deposito(double valor) {
        saldo += valor;
        qntdTransacoes++;
    }

    @Override
    public void extrato() {
        System.out.println("Saldo atual: " + saldo);
        System.out.println("Quantidade de transacoes: " + qntdTransacoes);
    }
}
