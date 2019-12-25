package com.bjeve.project.report.ventilator.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 呼吸机安装报告对象 rep_ventilator
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public class RepVentilator extends BaseEntity
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

    /** 主机系统/SN */
    @Excel(name = "主机系统/SN")
    private String computerSystemSn;

    /** 空压机品牌 */
    @Excel(name = "空压机品牌")
    private String airCompressorBrand;

    /** 空压机SN码 */
    @Excel(name = "空压机SN码")
    private String acbSn;

    /** 安装报告照片 */
    @Excel(name = "安装报告照片")
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
    public void setComputerSystemSn(String computerSystemSn) 
    {
        this.computerSystemSn = computerSystemSn;
    }

    public String getComputerSystemSn() 
    {
        return computerSystemSn;
    }
    public void setAirCompressorBrand(String airCompressorBrand) 
    {
        this.airCompressorBrand = airCompressorBrand;
    }

    public String getAirCompressorBrand() 
    {
        return airCompressorBrand;
    }
    public void setAcbSn(String acbSn) 
    {
        this.acbSn = acbSn;
    }

    public String getAcbSn() 
    {
        return acbSn;
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
            .append("computerSystemSn", getComputerSystemSn())
            .append("airCompressorBrand", getAirCompressorBrand())
            .append("acbSn", getAcbSn())
            .append("photoPath", getPhotoPath())
            .toString();
    }
}
