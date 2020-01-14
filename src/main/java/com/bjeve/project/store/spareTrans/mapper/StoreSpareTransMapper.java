package com.bjeve.project.store.spareTrans.mapper;

import com.bjeve.project.store.spareTrans.domain.StoreSpareTrans;
import java.util.List;

/**
 * 库存备件出入库Mapper接口
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
public interface StoreSpareTransMapper 
{
    /**
     * 查询库存备件出入库
     * 
     * @param id 库存备件出入库ID
     * @return 库存备件出入库
     */
    public StoreSpareTrans selectStoreSpareTransById(String id);

    /**
     * 查询库存备件出入库列表
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 库存备件出入库集合
     */
    public List<StoreSpareTrans> selectStoreSpareTransList(StoreSpareTrans storeSpareTrans);

    /**
     * 新增库存备件出入库
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 结果
     */
    public int insertStoreSpareTrans(StoreSpareTrans storeSpareTrans);

    /**
     * 修改库存备件出入库
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 结果
     */
    public int updateStoreSpareTrans(StoreSpareTrans storeSpareTrans);

    /**
     * 删除库存备件出入库
     * 
     * @param id 库存备件出入库ID
     * @return 结果
     */
    public int deleteStoreSpareTransById(String id);

    /**
     * 批量删除库存备件出入库
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteStoreSpareTransByIds(String[] ids);
}
