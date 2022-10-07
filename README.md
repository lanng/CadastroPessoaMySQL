## Implementação de interface Pessoa com registro no banco de dados em MySQL

***
**Repositório para documentar a evolução do projeto simples como forma de apredizado.
Projeto realizado para entrega de trabalho da faculdade utilizando a liguagem Java
Com banco de dados em MySQL**

Enunciado fornecido: 

*Utilizando a classe Pessoa, implemente uma aplicação que realize o cadastro de
pessoas em um Banco de Dados. A aplicação deve permitir a realização de 
inserção, exclusão e alteração de um registro. Além disso, a aplicação também 
deve proporcionar a visualização de todos os registros gravados no BD.*

***
### Classe  Pessoa irá ter os seguintes dados:
* Nome
* CPF
* RG
* Data Nascimento
* Endereço Completo
* Nacionalidade

***
- [x] Implementar a interface gráfica para inserção de dados.
- [x] Implementar a classe Pessoa com seus atributos e metodos.
- [x] Implementar a classe do banco de dados para realizar a conexão com o server (ConnectionFactory).
- [x] Implementar a classe para realizar o CRUD (PersonDAO).
- [x] Implementar os metodos para inserir os registros no banco de dados.
***
### Possiveis melhorias

- Validação de campos unicos (RG e CPF) para não inserir repetidos.
- Validação de seleção de múltiplas linhas na hora de atualizar/deletar os registros
- Melhorias estéticas em geral
***
### Como rodar o projeto

1. Requisitos:
   - MySQL
   - JDK 19
   - Editar a string de conexão em ConnectionFactory.java conforme os seus dados


2. Rodando o projeto
   - Clone o repositório:
    ```
    git clone https://github.com/lanng/CadastroPessoaMySQL.git
    ```
   - Acessar o diretório:
    ```
    cd CadastroPessoaMySQL
    ```
   - Abrir com sua IDE preferida e rodar pela classe FormPerson no método Main.