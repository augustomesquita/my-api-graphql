/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.augustomesquita.myapigraphql.controller;

import com.augustomesquita.myapigraphql.service.JGraphqlService;
import graphql.ExecutionResult;
import graphql.GraphQL;
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
public class JMainController {

    private final Logger LOGGER = LoggerFactory.getLogger(JMainController.class);

    @Autowired
    JGraphqlService graphQL;

    @RequestMapping("/query")
    public ResponseEntity query(@RequestBody String query) {
        ExecutionResult result = graphQL.getGraphQL().execute(query);
        if (!result.getErrors().isEmpty()) {
            LOGGER.info("Erro na Query: " + String.valueOf(result.getErrors()));
        }
        return ResponseEntity.ok(result.getData());
    }

    @RequestMapping("/mutation")
    public ResponseEntity mutation(@RequestBody String mutation) {
        ExecutionResult result = graphQL.getGraphQL().execute(mutation);
        if (!result.getErrors().isEmpty()) {
            LOGGER.info("Erro na Mutation: " + String.valueOf(result.getErrors()));
        }
        return ResponseEntity.ok(this);
    }

}
