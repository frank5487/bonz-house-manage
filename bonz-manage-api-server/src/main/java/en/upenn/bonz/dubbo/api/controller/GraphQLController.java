package en.upenn.bonz.dubbo.api.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    @GetMapping
    @ResponseBody
    public Map<String, Object> query(@RequestParam("query") String query) {
        return graphQL.execute(query).toSpecification();
    }

    /**
     * post GrahphQL query
     * @param query
     * @return
     */
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
}
