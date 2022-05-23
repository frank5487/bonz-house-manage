package en.upenn.bonz.dubbo.server.api;

import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.vo.PageInfo;

public interface ApiAdService {


    /**
     * query Ad pagination
     * @param type
     * @param page
     * @param pageSize
     * @return
     */
    PageInfo<Ad> queryAdList(Integer type, Integer page, Integer pageSize);
}
