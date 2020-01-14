package com.bjeve.project.store.spareTrans.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 库存备件出入库对象 store_spare_trans
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
public class StoreSpareTrans extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 备件ID */
    @Excel(name = "备件ID")
    private String spareId;

    /** 出入库时间 */
    @Excel(name = "出入库时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date transTime;

    /** 出库/入库 */
    @Excel(name = "出库/入库")
    private String transFlag;

    /** 数量 */
    @Excel(name = "数量")
    private Long number;

    /** 使用地点/备件来源 */
    @Excel(name = "使用地点/备件来源")
    private String useSource;

    //仅用于传参使用
    private String spareName;

    public void setId(String id)
    {
        this.id = id;
    }

    public String getId()
    {
        return id;
    }
    public void setSpareId(String spareId)
    {
        this.spareId = spareId;
    }

    public String getSpareId()
    {
        return spareId;
    }
    public void setTransTime(Date transTime)
    {
        this.transTime = transTime;
    }

    public Date getTransTime()
    {
        return transTime;
    }
    public void setTransFlag(String transFlag)
    {
        this.transFlag = transFlag;
    }

    public String getTransFlag()
    {
        return transFlag;
    }
    public void setNumber(Long number)
    {
        this.number = number;
    }

    public Long getNumber()
    {
        return number;
    }
    public void setUseSource(String useSource)
    {
        this.useSource = useSource;
    }

    public String getUseSource()
    {
        return useSource;
    }

    public String getSpareName() {
        return spareName;
    }

    public void setSpareName(String spareName) {
        this.spareName = spareName;
    }

    @Override
    public String toString() {
        return "StoreSpareTrans{" +
                "id='" + id + '\'' +
                ", spareId='" + spareId + '\'' +
                ", transTime=" + transTime +
                ", transFlag='" + transFlag + '\'' +
                ", number=" + number +
                ", useSource='" + useSource + '\'' +
                ", spareName='" + spareName + '\'' +
                '}';
    }
}
