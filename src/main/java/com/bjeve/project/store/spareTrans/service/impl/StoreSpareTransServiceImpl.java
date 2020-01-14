package com.bjeve.project.store.spareTrans.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.store.spareTrans.mapper.StoreSpareTransMapper;
import com.bjeve.project.store.spareTrans.domain.StoreSpareTrans;
import com.bjeve.project.store.spareTrans.service.IStoreSpareTransService;
import com.bjeve.common.utils.text.Convert;

/**
 * 库存备件出入库Service业务层处理
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
@Service
public class StoreSpareTransServiceImpl implements IStoreSpareTransService 
{
    @Autowired
    private StoreSpareTransMapper storeSpareTransMapper;

    /**
     * 查询库存备件出入库
     * 
     * @param id 库存备件出入库ID
     * @return 库存备件出入库
     */
    @Override
    public StoreSpareTrans selectStoreSpareTransById(String id)
    {
        return storeSpareTransMapper.selectStoreSpareTransById(id);
    }

    /**
     * 查询库存备件出入库列表
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 库存备件出入库
     */
    @Override
    public List<StoreSpareTrans> selectStoreSpareTransList(StoreSpareTrans storeSpareTrans)
    {
        return storeSpareTransMapper.selectStoreSpareTransList(storeSpareTrans);
    }

    /**
     * 新增库存备件出入库
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 结果
     */
    @Override
    public int insertStoreSpareTrans(StoreSpareTrans storeSpareTrans)
    {
        return storeSpareTransMapper.insertStoreSpareTrans(storeSpareTrans);
    }

    /**
     * 修改库存备件出入库
     * 
     * @param storeSpareTrans 库存备件出入库
     * @return 结果
     */
    @Override
    public int updateStoreSpareTrans(StoreSpareTrans storeSpareTrans)
    {
        return storeSpareTransMapper.updateStoreSpareTrans(storeSpareTrans);
    }

    /**
     * 删除库存备件出入库对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteStoreSpareTransByIds(String ids)
    {
        return storeSpareTransMapper.deleteStoreSpareTransByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除库存备件出入库信息
     * 
     * @param id 库存备件出入库ID
     * @return 结果
     */
    @Override
    public int deleteStoreSpareTransById(String id)
    {
        return storeSpareTransMapper.deleteStoreSpareTransById(id);
    }
}
