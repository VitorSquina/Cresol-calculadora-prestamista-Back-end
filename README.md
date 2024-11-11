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

Estes controladores expõem as rotas da API para:
- Listar produtos
- Listar simulações
- Criar novas simulações

### Entidades
As entidades representam as tabelas do banco de dados e possuem várias colunas que armazenam informações sobre uma simulação de seguro prestamista. As principais entidades são:

- **Produto**: Representa os produtos disponíveis para simulação.
- **Simulacao**: Representa as simulações de seguro prestamista.

Quando há divergências entre os nomes dos atributos e os nomes dos campos no banco de dados, a anotação `@Column` é usada para definir explicitamente o nome do campo no banco.

### Exceções
- **GlobalExceptionHandler** e **SimulationException**: Configuram e retornam exceções tratadas para o front-end, fornecendo uma forma clara de lidar com erros e retorná-los de forma compreensível para o usuário.

### Formulário
- **SimulacaoForm**: Define os valores que devem ser coletados no formulário enviado pelo front-end para criar uma nova simulação.

### Repositórios
- **ProdutoRepositorio** e **SimulacaoRepositorio**: Gerenciam o acesso e a manipulação dos dados nas tabelas `produto` e `simulacao`, respectivamente, utilizando Spring Data JPA.

  O `ProdutoRepositorio` utiliza uma consulta SQL personalizada para filtrar produtos compatíveis com a idade do usuário, baseada nos limites de idade mínima e máxima definidos para cada produto.

### Serviços
- **ProdutoServico**: Classe de serviço responsável pela lógica de negócio relacionada aos produtos. Utiliza o `ProdutoRepositorio` para acessar dados da tabela `produto`.
- **SimulacaoServico**: Classe de serviço que gerencia a lógica de negócio das simulações de seguro prestamista. Utiliza os repositórios `SimulacaoRepositorio` e `ProdutoRepositorio` para acessar os dados do banco de dados e fornece métodos para validar e calcular uma simulação, importante resaltar que, ao ser informado o aniversario do usuario, o sistema ira calcular sua idade e filtrar no banco atravez do `ProdutoRepositorio` todos os produtos que se enquadram nos criteiros de idade, e o sistema ira selecionar o primeiro como produto selecionado. Caso os valores não atendam aos critérios de validação, uma exceção é lançada e tratada, entre eles verificação de cpf, verificação de meses da simulação, atendendo aos criterios de ser menor que 120 e maior que 1, e também tratando outros erros, retornando uma mensagem de erro para o front-end.

### CalculadoraApplication
Classe principal que inicia a aplicação e executa a API.




