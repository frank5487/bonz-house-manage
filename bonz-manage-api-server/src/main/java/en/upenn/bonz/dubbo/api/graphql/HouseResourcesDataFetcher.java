package en.upenn.bonz.dubbo.api.graphql;

import en.upenn.bonz.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesDataFetcher implements MyDataFetcher{

    @Autowired
    private HouseResourcesService houseResourcesService;


    @Override
    public String fieldName() {
        return "HouseResources";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Long id = environment.getArgument("id");
        return houseResourcesService.queryHouseResourcesById(id);
    }
}
