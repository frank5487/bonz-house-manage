package en.upenn.bonz.dubbo.api.graphql;

import graphql.schema.DataFetchingEnvironment;

public interface MyDataFetcher {

    /**
     * the field of GraphQL
     * @return
     */
    String fieldName();


    /**
     * data we need to query
     * @param environment
     * @return
     */
    Object dataFetcher(DataFetchingEnvironment environment);
}
