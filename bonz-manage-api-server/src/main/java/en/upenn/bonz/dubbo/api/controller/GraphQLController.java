package en.upenn.bonz.dubbo.api.controller;

import graphql.GraphQL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/graphql")
public class GraphQLController {

    @Autowired
    private GraphQL graphQL;

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
}
