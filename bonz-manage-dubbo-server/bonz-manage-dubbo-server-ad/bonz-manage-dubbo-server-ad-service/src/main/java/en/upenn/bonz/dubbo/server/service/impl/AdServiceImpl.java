package en.upenn.bonz.dubbo.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.service.AdService;
import en.upenn.bonz.dubbo.server.service.BaseServiceImpl;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends BaseServiceImpl<Ad> implements AdService {

    @Override
    public PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize) {
        QueryWrapper<Ad> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("updated");
        queryWrapper.eq("type", ad.getType());

        IPage<Ad> adIPage = super.queryPageList(queryWrapper, page, pageSize);

        return new PageInfo<>(Long.valueOf(adIPage.getTotal()).intValue(), page, pageSize, adIPage.getRecords());
    }
}
