package en.upenn.bonz.dubbo.server.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

@Data
@AllArgsConstructor
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = -2105385689859184204L;

    /**
     * total counts
     */
    private Integer total;

    /**
     * current page
     */
    private Integer pageNum;

    /**
     * pageSize
     */
    private Integer pageSize;

    /**
     * records
     */
    private List<T> records = Collections.emptyList();

}
