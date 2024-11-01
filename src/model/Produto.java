package model;

public class Produto {
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.format("Produto → Nome: %s | Preço: %.2f | Quantidade: %d", getNome(), getPreco(), getQuantidade());
    }

    // clona o produto para que eu possa visualizar corretamente a quantidade dele no carrinho, e só diminua a quantidade após a finalização da compra
    public Produto clonar() {
        return new Produto(this.nome, this.preco, 1);
    }

}
