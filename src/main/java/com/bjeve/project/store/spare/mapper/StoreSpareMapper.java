package com.bjeve.project.store.spare.mapper;

import com.bjeve.project.store.spare.domain.StoreSpare;
import java.util.List;

/**
 * 库存备件Mapper接口
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
public interface StoreSpareMapper 
{
    /**
     * 查询库存备件
     * 
     * @param id 库存备件ID
     * @return 库存备件
     */
    public StoreSpare selectStoreSpareById(String id);

    /**
     * 查询库存备件列表
     * 
     * @param storeSpare 库存备件
     * @return 库存备件集合
     */
    public List<StoreSpare> selectStoreSpareList(StoreSpare storeSpare);

    /**
     * 新增库存备件
     * 
     * @param storeSpare 库存备件
     * @return 结果
     */
    public int insertStoreSpare(StoreSpare storeSpare);

    /**
     * 修改库存备件
     * 
     * @param storeSpare 库存备件
     * @return 结果
     */
    public int updateStoreSpare(StoreSpare storeSpare);

    /**
     * 删除库存备件
     * 
     * @param id 库存备件ID
     * @return 结果
     */
    public int deleteStoreSpareById(String id);

    /**
     * 批量删除库存备件
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreSpareByIds(String[] ids);
}
