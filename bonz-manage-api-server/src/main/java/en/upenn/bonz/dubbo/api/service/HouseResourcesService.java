package en.upenn.bonz.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import en.upenn.bonz.dubbo.api.vo.Pagination;
import en.upenn.bonz.dubbo.api.vo.TableResult;
import en.upenn.bonz.dubbo.server.api.ApiHouseResourcesService;
import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class HouseResourcesService {

    @Reference(version = "1.0.0")
    private ApiHouseResourcesService apiHouseResourcesService;

    public boolean save(HouseResources houseResources) {
        int result = apiHouseResourcesService.saveHouseResources(houseResources);

        return result == 1;
    }

    public TableResult<HouseResources> queryList(HouseResources houseResources, int currentPage, int pageSize) {
        PageInfo<HouseResources> pageInfo = apiHouseResourcesService.queryHouseResourcesList(currentPage, pageSize, houseResources);

        return new TableResult<>(pageInfo.getRecords(), new Pagination(currentPage, pageSize, pageInfo.getTotal()));
    }

    public HouseResources queryHouseResourcesById(Long id) {
        return apiHouseResourcesService.queryHouseResourcesById(id);
    }

    public boolean update(HouseResources houseResources) {
        return apiHouseResourcesService.updateHouseResources(houseResources);
    }
}
