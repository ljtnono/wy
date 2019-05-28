package cn.ljtnono.wyapp.pojo;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *  封装的分页查询的条件
 *  @author ljt
 *  @date 2019/3/20
 *  @version 1.0
*/
public class PageParam implements Serializable {


    private static final long serialVersionUID = 6823433291117800742L;
    /**
     * 页码
     */
    @NotNull(message = "页码大于1")
    @Range(message = "页码大于1",min = 1)
    private Integer page;
    /**
     * 每页显示的条数
     */
    @NotNull(message = "每页显示条数大于1")
    @Range(message = "每页显示条数大于1",min = 1)
    private Integer limit;

    private PageParam(Builder builder) {
        setPage(builder.page);
        setLimit(builder.limit);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(PageParam copy) {
        Builder builder = new Builder();
        builder.page = copy.getPage();
        builder.limit = copy.getLimit();
        return builder;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public PageParam(Integer page, Integer limit) {
        this.page = page;
        this.limit = limit;
    }

    public PageParam() {
    }
    public static final class Builder {
        private Integer page = 1;
        private Integer limit = 10;

        private Builder() {
        }

        public Builder page(Integer val) {
            if (val != null && val >= 1) {
                page = val;
            }
            return this;
        }

        public Builder limit(Integer val) {
            if (val != null && val >= 1) {
                limit = val;
            }
            return this;
        }

        public PageParam build() {
            return new PageParam(this);
        }
    }
}
