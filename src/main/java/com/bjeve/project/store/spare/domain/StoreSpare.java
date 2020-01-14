package com.bjeve.project.store.spare.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 库存备件对象 store_spare
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
public class StoreSpare extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 备件名称 */
    @Excel(name = "备件名称")
    private String spaceName;

    /** 规格 */
    @Excel(name = "规格")
    private String spec;

    /** 备件来源 */
    @Excel(name = "备件来源")
    private String source;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setSpaceName(String spaceName) 
    {
        this.spaceName = spaceName;
    }

    public String getSpaceName() 
    {
        return spaceName;
    }
    public void setSpec(String spec) 
    {
        this.spec = spec;
    }

    public String getSpec() 
    {
        return spec;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setNumber(Long number) 
    {
        this.number = number;
    }

    public Long getNumber() 
    {
        return number;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("spaceName", getSpaceName())
            .append("spec", getSpec())
            .append("source", getSource())
            .append("number", getNumber())
            .toString();
    }
}
