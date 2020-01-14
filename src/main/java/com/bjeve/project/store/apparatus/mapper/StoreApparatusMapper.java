package com.bjeve.project.store.apparatus.mapper;

import com.bjeve.project.store.apparatus.domain.StoreApparatus;
import java.util.List;

/**
 * 库存整机Mapper接口
 * 
 * @author chaiyuming
 * @date 2020-01-13
 */
public interface StoreApparatusMapper 
{
    /**
     * 查询库存整机
     * 
     * @param id 库存整机ID
     * @return 库存整机
     */
    public StoreApparatus selectStoreApparatusById(String id);

    /**
     * 查询库存整机列表
     * 
     * @param storeApparatus 库存整机
     * @return 库存整机集合
     */
    public List<StoreApparatus> selectStoreApparatusList(StoreApparatus storeApparatus);

    /**
     * 新增库存整机
     * 
     * @param storeApparatus 库存整机
     * @return 结果
     */
    public int insertStoreApparatus(StoreApparatus storeApparatus);

    /**
     * 修改库存整机
     * 
     * @param storeApparatus 库存整机
     * @return 结果
     */
    public int updateStoreApparatus(StoreApparatus storeApparatus);

    /**
     * 删除库存整机
     * 
     * @param id 库存整机ID
     * @return 结果
     */
    public int deleteStoreApparatusById(String id);

    /**
     * 批量删除库存整机
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreApparatusByIds(String[] ids);
}
