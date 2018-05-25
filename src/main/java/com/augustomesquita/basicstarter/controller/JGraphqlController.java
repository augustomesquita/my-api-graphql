/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.basicstarter.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import java.io.File;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author augusto
 */
@RestController
public class JGraphqlController {

    private final Logger LOGGER = LoggerFactory.getLogger(JGraphqlController.class);
    private GraphQL graphQL;

    @Autowired
    private AllUserDataFetcher allUserDataFetcher;

    @Autowired
    private UserFetcher userDataFetcher;

    @Autowired
    private MovieDataFetcher movieDataFetcher;

    @Value("classpath:user.graphqls")
    private Resource schemaUserResource;

    @PostConstruct
    public void loadSchema() throws IOException {
        File schemaFile = schemaUserResource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry
                = new SchemaParser().parse(schemaFile);
        RuntimeWiring wiring = buildRuntimeWiring();
        GraphQLSchema schema = new SchemaGenerator()
                .makeExecutableSchema(typeDefinitionRegistry, wiring);
        graphQL = GraphQL.newGraphQL(schema).build();
    }

    @RequestMapping("/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.execute(query);
        LOGGER.info(String.valueOf(result.getErrors()));
        return ResponseEntity.ok(result.getData());
    }

    @RequestMapping("/mutation")
    public ResponseEntity mutation() {
        return ResponseEntity.ok(this);
    }

    private RuntimeWiring buildRuntimeWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                .dataFetcher("allUser", allUserDataFetcher)
                .dataFetcher("user", userDataFetcher))
                .type("User", typeWiring -> typeWiring.dataFetcher("movie", movieDataFetcher))
                .build();
    }

}
