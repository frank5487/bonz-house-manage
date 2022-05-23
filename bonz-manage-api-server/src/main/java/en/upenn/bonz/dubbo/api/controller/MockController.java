package en.upenn.bonz.dubbo.api.controller;

import en.upenn.bonz.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mock")
@CrossOrigin
public class MockController {

    @Autowired
    private MockConfig mockConfig;

    /**
     * home menu
     * @return
     */
    @GetMapping("/index/menu")
    public String indexMenu() {
        return mockConfig.getIndexMenu();
    }

    /**
     * home info
     * @return
     */
    @GetMapping("/index/info")
    public String indexInfo() {
        return this.mockConfig.getIndexInfo();
    }
    /**
     * home faq
     * @return
     */
    @GetMapping("/index/faq")
    public String indexFaq() {
        return this.mockConfig.getIndexFaq();
    }
    /**
     * home house info
     * @return
     */
    @GetMapping("/index/house")
    public String indexHouse() {
        return this.mockConfig.getIndexHouse();
    }

    /**
     * search info
     *
     * @param type
     * @return
     */
    @GetMapping("/infos/list")
    public String infosList(@RequestParam("type")Integer type) {
        switch (type){
            case 1:
                return this.mockConfig.getInfosList1();
            case 2:
                return this.mockConfig.getInfosList2();
            case 3:
                return this.mockConfig.getInfosList3();
        }
        return this.mockConfig.getInfosList1();
    }
    /**
     * my info
     * @return
     */
    @GetMapping("/my/info")
    public String myInfo() {
        return this.mockConfig.getMy();
    }
}
