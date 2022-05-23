package en.upenn.bonz.dubbo.api.controller;

import en.upenn.bonz.dubbo.api.config.MockConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mock")
@CrossOrigin
public class MockController {

    @Autowired
    private MockConfig mockConfig;

    @GetMapping("/indexMenu")
    public String indexMenu() {
        return mockConfig.getIndexMenu();
    }
}
