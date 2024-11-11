# Calculadora Prestamista Back-End

Este projeto é o back-end da Calculadora Prestamista, uma aplicação para realizar simulações de seguro prestamista. O back-end foi desenvolvido em Java com Spring Boot e está organizado em pacotes que gerenciam diferentes partes da aplicação.

## Estrutura dos Pacotes

- **config**: Contém as configurações da aplicação.
- **controllers**: Contém os controladores da API, responsáveis por gerenciar as rotas.
- **entidades**: Define as entidades que representam as tabelas do banco de dados.
- **excecoes**: Trata as exceções e erros que podem ocorrer na aplicação.
- **form**: Define os formulários para entrada de dados nas requisições.
- **repositorios**: Define as interfaces para manipulação das tabelas no banco de dados.
- **servicos**: Contém a lógica de negócios da aplicação.

## Detalhes dos Pacotes

### Config

Contém o arquivo `WebConfig`, responsável pela configuração dos CORS, permitindo que o front-end faça requisições ao back-end. Isso é essencial para que as requisições entre domínios diferentes sejam permitidas.

### Controllers

- **ProdutoController**: Controlador que gerencia as operações relacionadas aos produtos.
- **SimulacaoController**: Controlador que gerencia as operações relacionadas às simulações de seguro.

Estes controladores Spring Boot em Java expõem as rotas da API para:
- Listar produtos
- Listar simulações
- Criar novas simulações

### Entidades

As entidades representam as tabelas do banco de dados e possuem várias colunas que armazenam informações sobre uma simulação de seguro prestamista. As principais entidades são:

- **Produto**: Representa os produtos disponíveis para simulação.
- **Simulacao**: Representa as simulações de seguro prestamista.

Quando há divergências entre os nomes dos atributos e os nomes dos campos no banco de dados, a anotação `@Column` é usada para definir explicitamente o nome do campo no banco. Exemplo:

```java
@Column(name = "valor_segurado")
private BigDecimal valorSegurado;
