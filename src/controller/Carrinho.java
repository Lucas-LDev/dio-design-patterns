package controller;

import model.Estoque;
import model.Produto;
import strategy.Pagamento;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos;

    public Carrinho() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        for (Produto p: produtos) {
            // se o produto for igual (por conta do nome) ele apenas acrescenta mais 1
            if (p.getNome().equalsIgnoreCase(produto.getNome())) {
                p.setQuantidade(p.getQuantidade() +1);
                return;
            }
        }
        produtos.add(produto.clonar());
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto p : produtos) {
            total += p.getPreco() * p.getQuantidade();
        }
        return total;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }

    public void finalizarCompra(Pagamento metodoPagamento, Estoque estoque) {
        if (produtos.isEmpty()) {
            System.out.println("O carrinho está vazio! Adicione produtos no carrinho antes de finalizar a compra.");
            return;
        }

        double total = calcularTotal();
        metodoPagamento.processarPagamento(total);

        // diminuindo a quantidade dos produtos no estoque depois do pagamento
        for (Produto produtoCarrinho : produtos) {
            for (Produto produtoEstoque : estoque.listarProdutos()) {
                // verifica se o produto do carrinho é o mesmo do estoque
                if (produtoCarrinho.getNome().equals(produtoEstoque.getNome())) {
                    int novaQuantidade = produtoEstoque.getQuantidade() - produtoCarrinho.getQuantidade();
                    produtoEstoque.setQuantidade(novaQuantidade);
                    break;
                }
            }
        }

        System.out.println("Compra finalizada com sucesso!");
        System.out.println("Total da compra: R$ " + String.format("%.2f", total));

        // limpa o carrinho após a compra
        produtos.clear();
    }

}
