package com.bjeve.project.store.apparatus.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 库存整机对象 store_apparatus
 * 
 * @author chaiyuming
 * @date 2020-01-13
 */
public class StoreApparatus extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 机器型号 */
    @Excel(name = "机器型号")
    private String apparName;

    /** 机器类型（麻醉剂/呼吸机） */
    @Excel(name = "机器类型", readConverterExp = "麻=醉剂/呼吸机")
    private String apparType;

    /** 入库时间 */
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** SN码 */
    @Excel(name = "SN码")
    private String sn;

    /** 是否已出库 */
    @Excel(name = "是否已出库")
    private String isTrans;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setApparName(String apparName) 
    {
        this.apparName = apparName;
    }

    public String getApparName() 
    {
        return apparName;
    }
    public void setApparType(String apparType) 
    {
        this.apparType = apparType;
    }

    public String getApparType() 
    {
        return apparType;
    }
    public void setTransTime(Date transTime) 
    {
        this.transTime = transTime;
    }

    public Date getTransTime() 
    {
        return transTime;
    }
    public void setSn(String sn) 
    {
        this.sn = sn;
    }

    public String getSn() 
    {
        return sn;
    }
    public void setIsTrans(String isTrans) 
    {
        this.isTrans = isTrans;
    }

    public String getIsTrans() 
    {
        return isTrans;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("apparName", getApparName())
            .append("apparType", getApparType())
            .append("transTime", getTransTime())
            .append("sn", getSn())
            .append("isTrans", getIsTrans())
            .toString();
    }
}
