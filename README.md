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

## Exceções
### GlobalExceptionHandler e SimulationException
Estes arquivos configuram e retornam exceções tratadas para o front-end, fornecendo uma forma clara de lidar com erros e retorná-los de forma compreensível para o usuário.

## Formulário
### SimulacaoForm
Define os valores que devem ser coletados no formulário enviado pelo front-end para criar uma nova simulação.

## Repositórios
### ProdutoRepositorio e SimulacaoRepositorio
Estes repositórios gerenciam o acesso e a manipulação dos dados nas tabelas `produto` e `simulacao`, respectivamente, utilizando Spring Data JPA.

O `ProdutoRepositorio` utiliza uma consulta SQL personalizada para filtrar produtos compatíveis com a idade do usuário, baseada nos limites de idade mínima e máxima definidos para cada produto.

## Serviços
### ProdutoServico
Classe de serviço responsável pela lógica de negócio relacionada aos produtos. Utiliza o `ProdutoRepositorio` para acessar dados da tabela `produto`.

### SimulacaoServico
Classe de serviço que gerencia a lógica de negócio das simulações de seguro prestamista. Utiliza os repositórios `SimulacaoRepositorio` e `ProdutoRepositorio` para acessar os dados do banco de dados e fornece métodos para validar e calcular uma simulação. Caso os valores não atendam aos critérios de validação, uma exceção é lançada e tratada, retornando uma mensagem de erro para o front-end.

## CalculadoraApplication
Classe principal que inicia a aplicação e executa a API.

## Como Executar a Aplicação
1. Certifique-se de ter o Java 11 ou superior instalado.
2. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git


