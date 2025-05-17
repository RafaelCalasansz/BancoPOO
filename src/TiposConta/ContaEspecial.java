package TiposConta;


public class ContaEspecial extends ContaCorrente{
    private double limite;

    public ContaEspecial(String senha, double limite) {
        super(senha);
        this.limite = limite;
    }

    @Override
    public void saque(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque.");
            return;
        }

        if (valor > saldo + limite) {
            System.out.println("Limite insuficiente!");
            return;
        }

        if (valor > saldo) {
            limite -= (valor - saldo);
        }

        saldo -= valor;
        qntdTransacoes++;
    }

    @Override
    public void extrato() {
        super.extrato();
        System.out.println("Limite: " + limite);
        System.out.print("Saldo total: " + (saldo+limite));
    }
}
