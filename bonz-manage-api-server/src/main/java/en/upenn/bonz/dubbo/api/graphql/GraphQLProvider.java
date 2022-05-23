package en.upenn.bonz.dubbo.api.graphql;

import en.upenn.bonz.dubbo.api.service.HouseResourcesService;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * load GraphQL object into Spring container
 * init GraphQL object
 */
@Component
public class GraphQLProvider {

    private GraphQL graphQL;

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * init graphQL instance
     */
    @PostConstruct
    public void init() throws FileNotFoundException {
        File file = ResourceUtils.getFile("classpath:bonz.graphql");
        graphQL = GraphQL.newGraphQL(buildGraphQLSchema(file)).build();

    }

    private GraphQLSchema buildGraphQLSchema(File file) {
        TypeDefinitionRegistry typeDefinitionRegistry = buildTypeRegistry(file);
        RuntimeWiring runtimeWiring = buildWiring();
        return new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }

    private TypeDefinitionRegistry buildTypeRegistry(File file) {
        return new SchemaParser().parse(file);
    }

    private RuntimeWiring buildWiring() {
        return RuntimeWiring.newRuntimeWiring()
                .type("BonzQuery", builder ->
                    builder.dataFetcher("HouseResources", environment ->{
                        Long id = environment.getArgument("id");
                        return houseResourcesService.queryHouseResourcesById(id);
                    })
                )
                .build();
    }

    /**
     * load graphQL instance into Spring container
     * @return
     */
    @Bean
    public GraphQL graphQL() {
        return graphQL;
    }
}
