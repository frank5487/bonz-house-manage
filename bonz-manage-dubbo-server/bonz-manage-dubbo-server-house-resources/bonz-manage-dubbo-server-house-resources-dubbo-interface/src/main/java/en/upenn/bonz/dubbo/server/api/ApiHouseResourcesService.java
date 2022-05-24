package en.upenn.bonz.dubbo.server.api;

import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.vo.PageInfo;

public interface ApiHouseResourcesService {

    /**
     *
     * @param houseResources
     * @return -1: invalid input, 0: fail to insert data, 1: success
     */
    int saveHouseResources(HouseResources houseResources);

    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);

    HouseResources queryHouseResourcesById(Long id);

    boolean updateHouseResources(HouseResources houseResources);
}
