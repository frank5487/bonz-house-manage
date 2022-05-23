package en.upenn.bonz.dubbo.api.service;

import com.alibaba.dubbo.config.annotation.Reference;
import en.upenn.bonz.dubbo.server.api.ApiAdService;
import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class AdService {

    @Reference(version = "1.0.0")
    private ApiAdService apiAdService;

    public PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize) {
        return apiAdService.queryAdList(type, page, pageSize);
    }
}
