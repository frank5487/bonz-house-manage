package en.upenn.bonz.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import en.upenn.bonz.dubbo.server.service.BaseServiceImpl;
import en.upenn.bonz.dubbo.server.service.HouseResourcesService;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
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

    @Override
    public PageInfo<HouseResources> queryHouseResourcesList(int page, int pageSize, HouseResources queryCondition) {
        QueryWrapper<HouseResources> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("updated");
        IPage<HouseResources> iPage = super.queryPageList(queryWrapper, page, pageSize);

        return new PageInfo<HouseResources>(Long.valueOf(iPage.getTotal()).intValue(), page, pageSize, iPage.getRecords());
    }
}
