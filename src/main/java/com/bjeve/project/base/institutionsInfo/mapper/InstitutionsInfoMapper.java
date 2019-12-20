package com.bjeve.project.base.institutionsInfo.mapper;

import com.bjeve.project.base.institutionsInfo.domain.InstitutionsInfo;
import java.util.List;

/**
 * 机构信息维护Mapper接口
 * 
 * @author chaiyuming
 * @date 2019-12-20
 */
public interface InstitutionsInfoMapper 
{
    /**
     * 查询机构信息维护
     * 
     * @param id 机构信息维护ID
     * @return 机构信息维护
     */
    public InstitutionsInfo selectInstitutionsInfoById(String id);

    /**
     * 查询机构信息维护列表
     * 
     * @param institutionsInfo 机构信息维护
     * @return 机构信息维护集合
     */
    public List<InstitutionsInfo> selectInstitutionsInfoList(InstitutionsInfo institutionsInfo);

    /**
     * 新增机构信息维护
     * 
     * @param institutionsInfo 机构信息维护
     * @return 结果
     */
    public int insertInstitutionsInfo(InstitutionsInfo institutionsInfo);

    /**
     * 修改机构信息维护
     * 
     * @param institutionsInfo 机构信息维护
     * @return 结果
     */
    public int updateInstitutionsInfo(InstitutionsInfo institutionsInfo);

    /**
     * 删除机构信息维护
     * 
     * @param id 机构信息维护ID
     * @return 结果
     */
    public int deleteInstitutionsInfoById(String id);

    /**
     * 批量删除机构信息维护
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInstitutionsInfoByIds(String[] ids);
}
