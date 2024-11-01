package strategy;

public class PagamentoCartao implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println(String.format("Pagamento com Cartão no valor de R$ %.2f foi realizado.", valor));
    }
}
