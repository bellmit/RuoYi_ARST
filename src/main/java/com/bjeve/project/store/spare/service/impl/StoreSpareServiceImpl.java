package com.bjeve.project.store.spare.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.store.spare.mapper.StoreSpareMapper;
import com.bjeve.project.store.spare.domain.StoreSpare;
import com.bjeve.project.store.spare.service.IStoreSpareService;
import com.bjeve.common.utils.text.Convert;

/**
 * 库存备件Service业务层处理
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
@Service
public class StoreSpareServiceImpl implements IStoreSpareService 
{
    @Autowired
    private StoreSpareMapper storeSpareMapper;

    /**
     * 查询库存备件
     * 
     * @param id 库存备件ID
     * @return 库存备件
     */
    @Override
    public StoreSpare selectStoreSpareById(String id)
    {
        return storeSpareMapper.selectStoreSpareById(id);
    }

    /**
     * 查询库存备件列表
     * 
     * @param storeSpare 库存备件
     * @return 库存备件
     */
    @Override
    public List<StoreSpare> selectStoreSpareList(StoreSpare storeSpare)
    {
        return storeSpareMapper.selectStoreSpareList(storeSpare);
    }

    /**
     * 新增库存备件
     * 
     * @param storeSpare 库存备件
     * @return 结果
     */
    @Override
    public int insertStoreSpare(StoreSpare storeSpare)
    {
        return storeSpareMapper.insertStoreSpare(storeSpare);
    }

    /**
     * 修改库存备件
     * 
     * @param storeSpare 库存备件
     * @return 结果
     */
    @Override
    public int updateStoreSpare(StoreSpare storeSpare)
    {
        return storeSpareMapper.updateStoreSpare(storeSpare);
    }

    /**
     * 删除库存备件对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoreSpareByIds(String ids)
    {
        return storeSpareMapper.deleteStoreSpareByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存备件信息
     * 
     * @param id 库存备件ID
     * @return 结果
     */
    @Override
    public int deleteStoreSpareById(String id)
    {
        return storeSpareMapper.deleteStoreSpareById(id);
    }
}
