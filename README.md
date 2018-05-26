# API GraphQL com SpringBoot + SpringData + Flyway (PostgreSQL 10.3)
Aplicação que cria uma API GraphQL juntamente com SpringBoot + SpringData + Flyway + PostgreSQL.
O conceito e dicas sobre API GraphQL pode ser encontrado na página oficial: https://graphql.org/learn/

## Ações necessárias para utilização
Para rodar a aplicação da maneira como ela já está configurada, basta criar um banco de dados com o nome 'mygraphql_db' em seu PostgreSQL na porta padrão 5432. O usuário e senha do banco devem ser 'postgres'.

Caso queira realizar modificações quanto ao:
 - Tipo de banco utilizado;
 - Porta;
 - Nome do banco de dados;
 - Usuário e senha.

Basta modificar o arquivo de propriedades da aplicação, localizado em '/resource/application.properties'.

# Testando a API Graph
Ao executar a aplicação, dois endpoints ficarão automaticamente disponíveis. São eles o "/graphql" e o "/graphiql". 

/graphql: Endpoint responsável por realizar as ações, ou seja, em testes fora do "/graphiql" (que será explicado logo abaixo) ou em alguma aplicação que esteja consumindo esta API, este endpoint que deverá ser usado para realizar as requisições.

/graphiql: Nos disponibilizará a interface gráfica GraphiQL, onde poderemos ter acesso a documentação de nossa API e também realizar Queries e Mutations de forma mais elegante, sem precisarmos recorrer a ferramentas mais verbosas para testar este tipo de API, como o Postman. Por baixo dos panos as Queries e Mutations realizadas dentro desta ferramenta, serão encaminhadas para o endpoint "/graphql".

## Testes através do GraphiQL (interface gráfica do GraphQL)
Exemplo de realização de uma Query (exemplo funcionando, baseado nos dados desta aplicação) que retorna todos os usuários do banco, trazendo o nome/idade de cada um, juntamente do nome do filme favorito dos mesmos:
```js
{
  getAllUser { 
    name 
    movie {
      name
    }
  }
}
```

Exemplo de realização de uma Mutation (exemplo funcionando, baseado nos dados desta aplicação) que cria um filme (com os dados do nome e diretor) no banco e retorna como resposta o objeto filme criado com os campos 'id, name e director' preenchidos:
```js
mutation {
  saveMovie(name: "Filme Teste 6", director: "Diretor Teste 6") {
    id
    name
    director
  }
}
```

## Testes através do Postman
Embora o Postman não seja a ferramenta ideal para testes de API GraphQL, muita gente o usa por causa das API Rest. Por este motivo, deixarei aqui a sintaxe para realizar testes usando-o. Mas recomendo fortemente, caso você queira usar uma ferramente a parte para testes, a utilização do Insomnia (https://insomnia.rest/), pois ele já possui uma forma específica para trabalhar com API GraphQL (https://support.insomnia.rest/article/61-graphql).

Exemplo de realização de uma Query no Postman (exemplo funcionando, baseado nos dados desta aplicação):
![](screenshots/query_postman.png)


Exemplo de realização de uma Mutation no Postman (exemplo funcionando, baseado nos dados desta aplicação):
![](screenshots/mutation_postman.png)



