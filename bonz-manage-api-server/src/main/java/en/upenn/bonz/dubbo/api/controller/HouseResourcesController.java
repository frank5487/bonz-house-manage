package en.upenn.bonz.dubbo.api.controller;

import en.upenn.bonz.dubbo.api.service.HouseResourcesService;
import en.upenn.bonz.dubbo.api.vo.TableResult;
import en.upenn.bonz.dubbo.server.pojo.HouseResources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/house/resources")
public class HouseResourcesController {

    @Autowired
    private HouseResourcesService houseResourcesService;

    /**
     * add a house resource
     * @param houseResources
     * @return
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<Void> save(@RequestBody HouseResources houseResources) {
        try {
            boolean flag = houseResourcesService.save(houseResources);
            if (flag) {
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * pagination for house resources
     * @param houseResources
     * @param currentPage
     * @param pageSize
     * @return
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<TableResult<HouseResources>> list(HouseResources houseResources,
                                            @RequestParam(name = "currentPage", defaultValue = "1") Integer currentPage,
                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        return ResponseEntity.ok(houseResourcesService.queryList(houseResources, currentPage, pageSize));
    }


    /**
     * test
     * @return
     */
    /*
    @GetMapping
    @ResponseBody
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("ok");
    }
    */

}
