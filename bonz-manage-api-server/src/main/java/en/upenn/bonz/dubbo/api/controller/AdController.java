package en.upenn.bonz.dubbo.api.controller;

import en.upenn.bonz.dubbo.api.service.AdService;
import en.upenn.bonz.dubbo.api.vo.WebResult;
import en.upenn.bonz.dubbo.server.pojo.Ad;
import en.upenn.bonz.dubbo.server.vo.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/ad")
@CrossOrigin
public class AdController {

    @Autowired
    private AdService adService;

    @GetMapping
    public WebResult queryIndexAd() {
        PageInfo<Ad> adPageInfo = adService.queryAdList(1, 1, 3);
        List<Ad> records = adPageInfo.getRecords();

        List<Object> result = new ArrayList<>();
        for (Ad record : records) {
            Map<String, Object> map = new HashMap<>();
            map.put("original", record.getUrl());
            result.add(map);
        }

        return WebResult.ok(result);
    }
}
