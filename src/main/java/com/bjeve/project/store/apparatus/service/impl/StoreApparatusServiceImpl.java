package com.bjeve.project.store.apparatus.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.store.apparatus.mapper.StoreApparatusMapper;
import com.bjeve.project.store.apparatus.domain.StoreApparatus;
import com.bjeve.project.store.apparatus.service.IStoreApparatusService;
import com.bjeve.common.utils.text.Convert;

/**
 * 库存整机Service业务层处理
 * 
 * @author chaiyuming
 * @date 2020-01-13
 */
@Service
public class StoreApparatusServiceImpl implements IStoreApparatusService 
{
    @Autowired
    private StoreApparatusMapper storeApparatusMapper;

    /**
     * 查询库存整机
     * 
     * @param id 库存整机ID
     * @return 库存整机
     */
    @Override
    public StoreApparatus selectStoreApparatusById(String id)
    {
        return storeApparatusMapper.selectStoreApparatusById(id);
    }

    /**
     * 查询库存整机列表
     * 
     * @param storeApparatus 库存整机
     * @return 库存整机
     */
    @Override
    public List<StoreApparatus> selectStoreApparatusList(StoreApparatus storeApparatus)
    {
        return storeApparatusMapper.selectStoreApparatusList(storeApparatus);
    }

    /**
     * 新增库存整机
     * 
     * @param storeApparatus 库存整机
     * @return 结果
     */
    @Override
    public int insertStoreApparatus(StoreApparatus storeApparatus)
    {
        return storeApparatusMapper.insertStoreApparatus(storeApparatus);
    }

    /**
     * 修改库存整机
     * 
     * @param storeApparatus 库存整机
     * @return 结果
     */
    @Override
    public int updateStoreApparatus(StoreApparatus storeApparatus)
    {
        return storeApparatusMapper.updateStoreApparatus(storeApparatus);
    }

    /**
     * 删除库存整机对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoreApparatusByIds(String ids)
    {
        return storeApparatusMapper.deleteStoreApparatusByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存整机信息
     * 
     * @param id 库存整机ID
     * @return 结果
     */
    @Override
    public int deleteStoreApparatusById(String id)
    {
        return storeApparatusMapper.deleteStoreApparatusById(id);
    }
}
