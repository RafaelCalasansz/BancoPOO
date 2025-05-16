package TiposConta;


public class ContaEspecial extends ContaCorrente{
    private double limite;

    public ContaEspecial(String senha, double limite) {
        super(senha);
        this.limite = limite;
    }

    @Override
    public void saque(double valor) {

        if (valor <= saldo+limite) {
            if (valor>saldo) {
                limite-=(valor-saldo);
                saldo=0;
            } else {
                saldo-=valor;
            }
        } else {
            System.out.println("Saldo insuficiente");
        }

        qntdTransacoes++;
    }

    @Override
    public void extrato() {
        super.extrato();
        System.out.println("limite: " + limite);
        System.out.println("Saldo total: " + (saldo+limite));
    }
}
