package en.upenn.bonz.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import en.upenn.bonz.dubbo.server.api.ApiHouseResourcesService;
import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result = apiHouseResourcesService.saveHouseResources(houseResources);

        return result == 1;
    }
}
