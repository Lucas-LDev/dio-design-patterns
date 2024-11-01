package strategy;

public class PagamentoBoleto implements Pagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println(String.format("Pagamento com Boleto no valor de R$ %.2f foi realizado.", valor));
    }
}
