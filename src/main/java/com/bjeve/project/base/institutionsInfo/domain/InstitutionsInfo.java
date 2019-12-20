package com.bjeve.project.base.institutionsInfo.domain;

import com.bjeve.framework.aspectj.lang.annotation.Excel;
import com.bjeve.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 机构信息维护对象 base_institutions_info
 * 
 * @author chaiyuming
 * @date 2019-12-20
 */
public class InstitutionsInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private String id;

    /** 机构名称 */
    @Excel(name = "机构名称")
    private String instName;

    /** 机构类型 */
    @Excel(name = "机构类型")
    private String instType;

    /** 机构地区编码 */
    @Excel(name = "机构地区编码")
    private String areaCode;

    /** 详细地址 */
    @Excel(name = "详细地址")
    private String address;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contant;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String tel;

    /** 邮箱地址 */
    @Excel(name = "邮箱地址")
    private String email;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setInstName(String instName) 
    {
        this.instName = instName;
    }

    public String getInstName() 
    {
        return instName;
    }
    public void setInstType(String instType) 
    {
        this.instType = instType;
    }

    public String getInstType() 
    {
        return instType;
    }
    public void setAreaCode(String areaCode) 
    {
        this.areaCode = areaCode;
    }

    public String getAreaCode() 
    {
        return areaCode;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setContant(String contant) 
    {
        this.contant = contant;
    }

    public String getContant() 
    {
        return contant;
    }
    public void setTel(String tel) 
    {
        this.tel = tel;
    }

    public String getTel() 
    {
        return tel;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("instName", getInstName())
            .append("instType", getInstType())
            .append("areaCode", getAreaCode())
            .append("address", getAddress())
            .append("contant", getContant())
            .append("tel", getTel())
            .append("email", getEmail())
            .toString();
    }
}
