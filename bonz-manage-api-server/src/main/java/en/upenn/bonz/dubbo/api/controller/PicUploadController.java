package en.upenn.bonz.dubbo.api.controller;

import en.upenn.bonz.dubbo.api.service.PicUploadS3Service;
import en.upenn.bonz.dubbo.api.vo.PicUploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/pic/upload")
public class PicUploadController {

    @Autowired
    private PicUploadS3Service picUploadS3Service;

    @PostMapping
    @ResponseBody
    public PicUploadResult upload(@RequestParam("file")MultipartFile multipartFile) {
        return picUploadS3Service.upload(multipartFile);
    }
}
