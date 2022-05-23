package en.upenn.bonz.dubbo.api.graphql;

import en.upenn.bonz.dubbo.api.service.AdService;
import en.upenn.bonz.dubbo.api.vo.ad.index.IndexAdResult;
import en.upenn.bonz.dubbo.api.vo.ad.index.IndexAdResultData;
import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AdDataFetcher implements MyDataFetcher{

    @Autowired
    private AdService adService;

    @Override
    public String fieldName() {
        return "IndexAdList";
    }

    @Override
    public Object dataFetcher(DataFetchingEnvironment environment) {
        PageInfo<Ad> adPageInfo = adService.queryAdList(1, 1, 3);
        List<Ad> ads = adPageInfo.getRecords();

        List<IndexAdResultData> list = new ArrayList<>();
        for (Ad ad : ads) {
            list.add(new IndexAdResultData(ad.getUrl()));
        }

        return new IndexAdResult(list);
    }
}
