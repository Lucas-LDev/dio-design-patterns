# Projeto E-commerce Simples:
## Este projeto é um sistema básico de e-commerce implementado em Java, utilizando os padrões de projeto Factory e Strategy para melhorar a organização e flexibilidade do código. O sistema gerencia produtos, estoques, clientes e métodos de pagamento, simulando um processo simplificado de compra.

## Padrões de Projeto Utilizados
- Factory: O padrão Factory foi implementado para centralizar a criação de produtos, permitindo que as validações de dados sejam realizadas em um único lugar. Isso evita verificações redundantes ou acopladas no método main ou na classe Produto, melhorando a legibilidade e a organização do código.

- Strategy: O padrão Strategy foi aplicado para definir diferentes métodos de pagamento, como cartão de crédito e boleto bancário. Esse padrão facilita a escolha e a extensão de novos métodos de pagamento sem a necessidade de modificar o código principal. Basta instanciar um pagamento com a estratégia desejada, proporcionando flexibilidade e facilitando a manutenção do sistema.

## Funcionalidades do Sistema:
- Gerenciamento de Produtos e Estoque: Criação e controle de produtos, incluindo atualização das quantidades em estoque após cada compra.
- Carrinho de Compras: Adição de produtos ao carrinho, cálculo do total e finalização da compra.
- Métodos de Pagamento Flexíveis: Escolha entre diferentes opções de pagamento através do padrão Strategy, permitindo fácil expansão de métodos de pagamento.