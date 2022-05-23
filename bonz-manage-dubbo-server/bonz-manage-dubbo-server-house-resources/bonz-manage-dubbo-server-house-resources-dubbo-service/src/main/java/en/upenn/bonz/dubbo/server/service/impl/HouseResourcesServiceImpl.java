package en.upenn.bonz.dubbo.server.service.impl;

import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.service.BaseServiceImpl;
import en.upenn.bonz.dubbo.server.service.HouseResourcesService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class HouseResourcesServiceImpl extends BaseServiceImpl<HouseResources> implements HouseResourcesService {

    /**
     *
     * @param houseResources
     * @return -1: invalid input, 0: fail, 1: success
     */
    @Override
    public int saveHouseResources(HouseResources houseResources) {

        if (StringUtils.isBlank(houseResources.getTitle())) {
            return -1;
        }

        return super.save(houseResources);
    }
}
