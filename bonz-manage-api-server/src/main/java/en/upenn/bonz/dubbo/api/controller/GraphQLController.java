package en.upenn.bonz.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import graphql.ExecutionInput;
import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/graphql")
@CrossOrigin
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * implement GraphQL query
     * @param query
     * @return
     */
    /*
    @GetMapping
    @ResponseBody
    public Map<String, Object> query(@RequestParam("query") String query) {
        return graphQL.execute(query).toSpecification();
    }
     */

    /**
     * add variables while querying
     * @param query
     * @param variablesJson
     * @param operationName
     * @return
     */
    @GetMapping
    @ResponseBody
    public Map<String, Object> query(@RequestParam("query") String query,
                                     @RequestParam(value = "variables", required = false) String variablesJson,
                                     @RequestParam(value = "operationName", required = false) String operationName) {
        try {
            Map<String, Object> variables = MAPPER.readValue(variablesJson, MAPPER.getTypeFactory()
                    .constructMapType(HashMap.class, String.class, Object.class));

            return executeQuery(query, operationName, variables);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("msg", "fail...");
        return error;
    }


    /**
     * post GrahphQL query
     * @return
     */
    /*
    @PostMapping("/ad")
    @ResponseBody
    public Map<String, Object> postQuery(@RequestBody String json) {
        try {
            JsonNode jsonNode = MAPPER.readTree(json);
            if (jsonNode.has("query")) {
                String query = jsonNode.get("query").textValue();
                return graphQL.execute(query).toSpecification();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("msg", "fail...");

        return error;
    }
     */

    @PostMapping("/ad")
    @ResponseBody
    public Map<String, Object> postAdQuery(@RequestBody Map<String, Object> param) {
        return postQuery(param);
    }

    @PostMapping("/map")
    @ResponseBody
    public Map<String, Object> postMapQuery(@RequestBody Map<String, Object> param) {
        return postQuery(param);
    }

    private Map<String, Object> postQuery(Map<String, Object> param) {
        try {
            String query = (String) param.get("query");
            Map variables = (Map) param.get("variables");
            String operationName = (String) param.get("operationName");

            return executeQuery(query, operationName, variables);

        } catch (Exception e) {
            e.printStackTrace();
        }

        Map<String, Object> error = new HashMap<>();
        error.put("status", 500);
        error.put("msg", "fail...");
        return error;
    }

    private Map<String, Object> executeQuery(String query, String operationName, Map<String, Object> variables){
        ExecutionInput executionInput = ExecutionInput.newExecutionInput()
                .query(query)
                .operationName(operationName)
                .variables(variables)
                .build();
        return graphQL.execute(executionInput).toSpecification();
    }
}
