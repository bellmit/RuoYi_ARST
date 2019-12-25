package com.bjeve.project.report.maintenance.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 维修报告对象 rep_maintenance
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public class RepMaintenance extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String repId;

    /** 机构ID */
    @Excel(name = "机构ID")
    private String instId;

    /** 设备ID */
    @Excel(name = "设备ID")
    private String deviceId;

    /** 设备序列号 */
    @Excel(name = "设备序列号")
    private String deviceSn;

    /** 故障描述 */
    @Excel(name = "故障描述")
    private String faultDesc;

    /** 维修报告照片 */
    @Excel(name = "维修报告照片")
    private String photoPath;

    public void setRepId(String repId) 
    {
        this.repId = repId;
    }

    public String getRepId() 
    {
        return repId;
    }
    public void setInstId(String instId) 
    {
        this.instId = instId;
    }

    public String getInstId() 
    {
        return instId;
    }
    public void setDeviceId(String deviceId) 
    {
        this.deviceId = deviceId;
    }

    public String getDeviceId() 
    {
        return deviceId;
    }
    public void setDeviceSn(String deviceSn) 
    {
        this.deviceSn = deviceSn;
    }

    public String getDeviceSn() 
    {
        return deviceSn;
    }
    public void setFaultDesc(String faultDesc) 
    {
        this.faultDesc = faultDesc;
    }

    public String getFaultDesc() 
    {
        return faultDesc;
    }
    public void setPhotoPath(String photoPath) 
    {
        this.photoPath = photoPath;
    }

    public String getPhotoPath() 
    {
        return photoPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("repId", getRepId())
            .append("instId", getInstId())
            .append("deviceId", getDeviceId())
            .append("deviceSn", getDeviceSn())
            .append("faultDesc", getFaultDesc())
            .append("photoPath", getPhotoPath())
            .toString();
    }
}
