package application;

import controller.Carrinho;
import factory.ProdutoFactory;
import model.Estoque;
import model.Produto;
import strategy.Pagamento;
import strategy.PagamentoBoleto;
import strategy.PagamentoCartao;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // criando instâncias das classes
        ProdutoFactory factory = new ProdutoFactory();
        Carrinho carrinho = new Carrinho();
        Estoque estoque = new Estoque();

        // criando produtos
        Produto mouse = factory.criarProduto("Mouse Gamer", 150.0, 10);
        Produto teclado = factory.criarProduto("Teclado Mecânico", 250.0, 5);
        Produto fones = factory.criarProduto("Fones Bluetooth", 200.0, 8);
        Produto monitor = factory.criarProduto("Monitor 24' Full HD", 1200.0, 3);
        Produto laptop = factory.criarProduto("Laptop Intel Core i7", 4000.0, 2);
        Produto impressora = factory.criarProduto("Impressora Multifuncional", 800.0, 4);
        Produto webcam = factory.criarProduto("Webcam HD", 300.0, 6);
        Produto hdd = factory.criarProduto("HD Externo 2TB", 600.0, 5);
        Produto roteador = factory.criarProduto("Roteador Wi-Fi 6", 400.0, 7);

        // adicionando produtos ao estoque
        estoque.adicionarProduto(mouse);
        estoque.adicionarProduto(teclado);
        estoque.adicionarProduto(fones);
        estoque.adicionarProduto(monitor);
        estoque.adicionarProduto(laptop);
        estoque.adicionarProduto(impressora);
        estoque.adicionarProduto(webcam);
        estoque.adicionarProduto(hdd);
        estoque.adicionarProduto(roteador);

        // mostrando a lista de produtos no estoque
        System.out.println("\nLista de produtos no estoque: ");
        List<Produto> listaEstoque = estoque.listarProdutos();
        listaEstoque.forEach(produto -> System.out.println(produto.toString()));

        // adicionando produtos no carrinho
        carrinho.adicionarProduto(mouse);
        carrinho.adicionarProduto(teclado);
        carrinho.adicionarProduto(mouse);
        carrinho.adicionarProduto(mouse);
        carrinho.adicionarProduto(mouse);
        carrinho.adicionarProduto(mouse);

        // mostrando a lista de produtos no carrinho antes da compra
        System.out.println("\nLista de produtos no carrinho antes da compra: ");
        List<Produto> listaCarrinho = carrinho.listarProdutos();
        listaCarrinho.forEach(produto -> System.out.println(produto.toString()));

        // escolhendo método de pagamento
        Pagamento pagamentoBoleto = new PagamentoBoleto();
        Pagamento pagamentoCartao = new PagamentoCartao();

        // finalizando a compra
        carrinho.finalizarCompra(pagamentoCartao, estoque);

        // mostrando a lista de produtos no estoque após a compra
        System.out.println("\nLista de produtos no estoque após a compra: ");
        listaEstoque.forEach(produto -> System.out.println(produto.toString()));
    }
}
