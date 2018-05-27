
# GraphQL API with SpringBoot + SpringData + Flyway (PostgreSQL 10.3)
Application that creates a GraphQL API together with SpringBoot + SpringData + Flyway + PostgreSQL.
The concept and tips on GraphQL API can be found on the official page: https://graphql.org/learn/

## Actions Required to Use
To run the application the way it is already configured, simply create a database named 'mygraphql_db' in your PostgreSQL on the default port 5432. The database user and password should be 'postgres'.

If you want to make changes to:
 - Type of database used;
 - Port;
 - Name of the database;
 - User and password.

Just modify the application properties file, located in '/resource/application.properties'.

# Testing the Graph API
When you run the application, two endpoints will be automatically available. These are "/graphql" and "/graphiql".

/graphql: Endpoint responsible for performing the actions, in other words, tests outside the "/graphiql" (which will be explained below) or in some application that is consuming our API this endpoint that should be used to carry out the requests.

/graphiql: It will give us the GraphiQL (graphical interface of GraphQL) where we can access documentation of our API and also make Queries and Mutations in a more elegant way, without having to resort to more verbose tools to test this type of API like Postman. Under the wipes the Queries and Mutations performed within this tool will be forwarded to the endpoint "/graphql".

## Tests through GraphiQL (Graphical interface of GraphQL)
Example of performing a Query (example working based on the data of this application) that returns all the users of the database, bringing the name / age of each one, along with the name of the favorite movie of the same ones:
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

Example of performing a Mutation (example working based on the data from this application) that creates a movie (with the name and director data) in the database and returns in response the movie object created with the 'id, name and director' fields filled in:
```js
mutation {
  saveMovie(name: "Filme Teste 6", director: "Diretor Teste 6") {
    id
    name
    director
  }
}
```

## Testing through Postman
Although Postman is not the ideal tool for testing GraphQL APIs, a lot of people use it because of API Rest. For this reason, I will leave the syntax here to perform tests using it. But I strongly recommend, in case you want to use a handy tool for testing, the use of Insomnia (https://insomnia.rest/) because it already has a specific way to work with GraphQL API(https://support.insomnia.rest/article/61-graphql).

Example of performing a Query on Postman (example working, based on the data of this application):
![](screenshots/query_postman.png)


Example of performing a Mutation on Postman (example working, based on data from this application):
![](screenshots/mutation_postman.png)


# Loading database data efficiently with GraphQL and Spring Data
If you are using spring data, just like this project, it is important that relationships between entities are often configured in "lazy" mode so that you can properly use the benefits of GraphQL. So if the consumer of your Graph API reports that only need the data of a given entity, your backend does not need to perform extra unnecessary actions on the database to load data from objects that are attributes of the entity that was actually wanted.
In the example of this project, the "Movie" class is an attribute of the "User" class. Therefore, if the consumer wants only the name of a certain "User", the backend will not perform a "Movie" JOIN when searching for the "User" information.
Example of entity configuration using Spring Data (example working, based on data from this application):

```java
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", nullable = false, updatable = false)
    private Movie movie;
```
This way "User" will instantiate a "Movie" object and only fill the "ID" attribute of the movie since the "ID" is already present in the "User" table at the time of the search.
But when the consumer wants "Movie" data, like the name of the movie or the director? At this point the Resolvers classes are called, to "solve" the gaps of the objects, which in theory (if you have configured the "lazy load" properly) there will be.