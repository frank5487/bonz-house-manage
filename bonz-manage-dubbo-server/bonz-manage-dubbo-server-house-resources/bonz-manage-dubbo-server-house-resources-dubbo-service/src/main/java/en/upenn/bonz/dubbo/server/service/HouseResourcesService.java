package en.upenn.bonz.dubbo.server.service;

import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.vo.PageInfo;

public interface HouseResourcesService {

    int saveHouseResources(HouseResources houseResources);

    PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition);
}
