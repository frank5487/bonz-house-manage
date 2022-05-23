package en.upenn.bonz.dubbo.api.vo;

import lombok.Data;

/**
 * data format was defined by Ant-Design Pro
 */
@Data
public class PicUploadResult {

    // file unique id
    private String uid;
    // file name
    private String name;
    // including 4 status: uploading done error removed
    private String status;
    // response content: '{"status": "success"}'
    private String response;
}
