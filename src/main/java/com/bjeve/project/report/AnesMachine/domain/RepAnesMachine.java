package com.bjeve.project.report.AnesMachine.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 麻醉机安装报告对象 rep_anes_machine
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
public class RepAnesMachine extends BaseEntity
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

    /** O2Sensor类型 */
    @Excel(name = "O2Sensor类型")
    private String o2sensorType;

    /** 安装时间 */
    @Excel(name = "安装时间")
    private String installationTime;

    /** 安装报告照片路径 */
    @Excel(name = "安装报告照片路径")
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
    public void setO2sensorType(String o2sensorType) 
    {
        this.o2sensorType = o2sensorType;
    }

    public String getO2sensorType() 
    {
        return o2sensorType;
    }
    public void setInstallationTime(String installationTime) 
    {
        this.installationTime = installationTime;
    }

    public String getInstallationTime() 
    {
        return installationTime;
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
            .append("o2sensorType", getO2sensorType())
            .append("installationTime", getInstallationTime())
            .append("photoPath", getPhotoPath())
            .toString();
    }
}
