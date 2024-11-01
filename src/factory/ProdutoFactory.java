package factory;

import model.Produto;
import exception.ProdutoException;

public class ProdutoFactory {

    public Produto criarProduto(String nome, double preco, int quantidade) {
        validarProduto(nome, preco, quantidade);
        return new Produto(nome, preco, quantidade);
    }

    // valida as informações para a criação dos produtos
    private void validarProduto(String nome, double preco, int quantidade) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new ProdutoException("O nome do produto não pode ser nulo ou vazio!");
        }
        if (preco <= 0) {
            throw new ProdutoException("O preço do produto deve ser maior que zero!");
        }
        if (quantidade < 0) {
            throw new ProdutoException("A quantidade do produto não pode ser negativa!");
        }
    }
}

