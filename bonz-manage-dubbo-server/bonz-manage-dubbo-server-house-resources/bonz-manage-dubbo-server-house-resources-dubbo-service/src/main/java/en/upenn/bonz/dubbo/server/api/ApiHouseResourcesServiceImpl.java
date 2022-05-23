package en.upenn.bonz.dubbo.server.api;

import com.alibaba.dubbo.config.annotation.Service;
import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.service.HouseResourcesService;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class ApiHouseResourcesServiceImpl implements ApiHouseResourcesService{

    @Autowired
    private HouseResourcesService houseResourcesService;

    @Override
    public int saveHouseResources(HouseResources houseResources) {
        return houseResourcesService.saveHouseResources(houseResources);
    }

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        return houseResourcesService.queryHouseResourcesList(page, pageSize, queryCondition);
    }

    @Override
    public HouseResources queryHouseResourcesById(Long id) {
        return houseResourcesService.queryHouseResourcesById(id);
    }
}
