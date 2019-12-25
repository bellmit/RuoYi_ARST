package com.bjeve.project.base.deviceInfo.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 设备信息对象 base_device_info
 * 
 * @author chaiyuming
 * @date 2019-12-23
 */
public class DeviceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 设备中文名称 */
    @Excel(name = "设备中文名称")
    private String deviceCname;

    /** 设备英文名称（型号） */
    @Excel(name = "设备英文名称", readConverterExp = "型=号")
    private String deviceEname;

    /** 生产厂家 */
    @Excel(name = "生产厂家")
    private String manufacturer;

    /** 备注 */
    @Excel(name = "备注")
    private String deviceRemark;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setDeviceCname(String deviceCname) 
    {
        this.deviceCname = deviceCname;
    }

    public String getDeviceCname() 
    {
        return deviceCname;
    }
    public void setDeviceEname(String deviceEname) 
    {
        this.deviceEname = deviceEname;
    }

    public String getDeviceEname() 
    {
        return deviceEname;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setDeviceRemark(String deviceRemark) 
    {
        this.deviceRemark = deviceRemark;
    }

    public String getDeviceRemark() 
    {
        return deviceRemark;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceCname", getDeviceCname())
            .append("deviceEname", getDeviceEname())
            .append("manufacturer", getManufacturer())
            .append("deviceRemark", getDeviceRemark())
            .toString();
    }
}
