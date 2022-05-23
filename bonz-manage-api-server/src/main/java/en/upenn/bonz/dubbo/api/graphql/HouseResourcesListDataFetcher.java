package en.upenn.bonz.dubbo.api.graphql;

import en.upenn.bonz.dubbo.api.service.HouseResourcesService;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HouseResourcesListDataFetcher implements MyDataFetcher{

    @Autowired
    private HouseResourcesService houseResourcesService;


    @Override
    public String fieldName() {
        return "HouseResourcesList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        Integer page = environment.getArgument("page");
        if (null == page) {
            page = 1;
        }
        Integer pageSize = environment.getArgument("pageSize");
        if (null == pageSize) {
            pageSize = 5;
        }

        return houseResourcesService.queryList(null, page, pageSize);
    }
}
