package en.upenn.bonz.dubbo.server.service;

import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.vo.PageInfo;

public interface AdService {


    PageInfo<Ad> queryAdList(Ad ad, Integer page, Integer pageSize);
}
