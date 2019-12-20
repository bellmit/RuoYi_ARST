package com.bjeve.project.base.institutionsInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.base.institutionsInfo.mapper.InstitutionsInfoMapper;
import com.bjeve.project.base.institutionsInfo.domain.InstitutionsInfo;
import com.bjeve.project.base.institutionsInfo.service.IInstitutionsInfoService;
import com.bjeve.common.utils.text.Convert;

/**
 * 机构信息维护Service业务层处理
 * 
 * @author chaiyuming
 * @date 2019-12-20
 */
@Service
public class InstitutionsInfoServiceImpl implements IInstitutionsInfoService 
{
    @Autowired
    private InstitutionsInfoMapper institutionsInfoMapper;

    /**
     * 查询机构信息维护
     * 
     * @param id 机构信息维护ID
     * @return 机构信息维护
     */
    @Override
    public InstitutionsInfo selectInstitutionsInfoById(String id)
    {
        return institutionsInfoMapper.selectInstitutionsInfoById(id);
    }

    /**
     * 查询机构信息维护列表
     * 
     * @param institutionsInfo 机构信息维护
     * @return 机构信息维护
     */
    @Override
    public List<InstitutionsInfo> selectInstitutionsInfoList(InstitutionsInfo institutionsInfo)
    {
        return institutionsInfoMapper.selectInstitutionsInfoList(institutionsInfo);
    }

    /**
     * 新增机构信息维护
     * 
     * @param institutionsInfo 机构信息维护
     * @return 结果
     */
    @Override
    public int insertInstitutionsInfo(InstitutionsInfo institutionsInfo)
    {
        return institutionsInfoMapper.insertInstitutionsInfo(institutionsInfo);
    }

    /**
     * 修改机构信息维护
     * 
     * @param institutionsInfo 机构信息维护
     * @return 结果
     */
    @Override
    public int updateInstitutionsInfo(InstitutionsInfo institutionsInfo)
    {
        return institutionsInfoMapper.updateInstitutionsInfo(institutionsInfo);
    }

    /**
     * 删除机构信息维护对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteInstitutionsInfoByIds(String ids)
    {
        return institutionsInfoMapper.deleteInstitutionsInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除机构信息维护信息
     * 
     * @param id 机构信息维护ID
     * @return 结果
     */
    @Override
    public int deleteInstitutionsInfoById(String id)
    {
        return institutionsInfoMapper.deleteInstitutionsInfoById(id);
    }
}
