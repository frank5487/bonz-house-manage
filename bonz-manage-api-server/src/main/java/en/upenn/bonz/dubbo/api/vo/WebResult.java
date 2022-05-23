package en.upenn.bonz.dubbo.api.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebResult {

    @JsonIgnore
    private Integer status;
    @JsonIgnore
    private String msg;
    @JsonIgnore
    private List<?> list;

    @JsonIgnore
    public static WebResult ok(List<?> list) {
        return new WebResult(200, "success!", list);
    }

    @JsonIgnore
    public static WebResult ok(List<?> list, String msg) {
        return new WebResult(200, msg, list);
    }

    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("list", list);
        return map;
    }

    public Map<String, Object> getMeta() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("msg", msg);
        return map;
    }
}
