/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.service;

import com.augustomesquita.myapigraphql.service.user.AllUserDataFetcher;
import com.augustomesquita.myapigraphql.service.user.UserDataFetcher;
import com.augustomesquita.myapigraphql.service.movie.MovieDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

/**
 *
 * @author augusto
 */
@Service
public class JGraphqlService implements CommandLineRunner {

    @Autowired
    private AllUserDataFetcher allUserDataFetcher;

    @Autowired
    private UserDataFetcher userDataFetcher;

    @Autowired
    private MovieDataFetcher movieDataFetcher;

    private GraphQL graphQL;

    @Value("classpath:user.graphqls")
    private Resource schemaUserResource;

    @Override
    public void run(String... args) throws Exception {
        File schemaFile = schemaUserResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry
                = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator()
                .makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                .dataFetcher("allUser", allUserDataFetcher)
                .dataFetcher("user", userDataFetcher))
                .type("User", typeWiring -> typeWiring.dataFetcher("movie", movieDataFetcher))
                .build();
    }

    public GraphQL getGraphQL() {
        return graphQL;
    }

}
