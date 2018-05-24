# API GraphQL com SpringBoot + SpringData + Flyway (PostgreSQL 10.3)
Aplicação que cria uma API GraphQL juntamente com SpringBoot + SpringData + Flyway + PostgreSQL.
O conceito de API GraphQL pode ser encontrada na página oficial: https://graphql.org/learn/

## Ações necessárias para utilização
Para rodar a aplicação da maneira como ela já está configurada, basta criar um banco de dados com o nome 'mygraphql_db' em seu PostgreSQL na porta padrão 5432. O usuário e senha do banco devem ser 'postgres'.

Caso queira realizar modificações quanto ao:
 - Tipo de banco utilizado;
 - Porta;
 - Nome do banco de dados;
 - Usuário e senha.

Basta modificar o arquivo de propriedades da aplicação, localizado em '/resource/application.properties'.
