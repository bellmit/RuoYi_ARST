package com.bjeve.project.store.spareTrans.controller;

import java.util.List;

import com.bjeve.project.store.spare.domain.StoreSpare;
import com.bjeve.project.store.spare.service.IStoreSpareService;
import com.bjeve.project.system.dict.domain.DictData;
import com.bjeve.project.system.dict.domain.DictType;
import com.bjeve.project.system.dict.service.IDictDataService;
import com.bjeve.project.system.dict.service.IDictTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bjeve.framework.aspectj.lang.annotation.Log;
import com.bjeve.framework.aspectj.lang.enums.BusinessType;
import com.bjeve.project.store.spareTrans.domain.StoreSpareTrans;
import com.bjeve.project.store.spareTrans.service.IStoreSpareTransService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 库存备件出入库Controller
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/store/spareTrans")
public class StoreSpareTransController extends BaseController
{
    private String prefix = "store/spareTrans";

    @Autowired
    private IStoreSpareService storeSpareService;

    @Autowired
    private IStoreSpareTransService storeSpareTransService;

    @Autowired
    private IDictDataService dictDataService;

    @RequiresPermissions("store:spareTrans:view")
    @GetMapping("/view/{id}")
    public String spareTrans(@PathVariable("id") String id, ModelMap mmap)
    {
        mmap.put("spareId", id);
        return prefix + "/spareTrans";
    }

    /**
     * 查询库存备件出入库列表
     */
    @RequiresPermissions("store:spareTrans:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StoreSpareTrans storeSpareTrans)
    {
        startPage();
        List<StoreSpareTrans> list = storeSpareTransService.selectStoreSpareTransList(storeSpareTrans);
        list = getResInfo(list,storeSpareTrans.getSpareId());
        return getDataTable(list);
    }

    /**
     * 组织页面返回结果
     * @param list
     * @param spareId
     * @return
     */
    private List<StoreSpareTrans> getResInfo(List<StoreSpareTrans> list,String spareId){
        DictData dictData = new DictData();
        dictData.setDictType("transFlag");
        List<DictData> dictDataList = dictDataService.selectDictDataList(dictData);
        for(StoreSpareTrans spareTrans: list){
            for(DictData data: dictDataList){
                if(spareTrans.getTransFlag().equals(data.getDictValue())){
                    spareTrans.setTransFlag(data.getDictLabel());
                }
            }
        }
        return list;
    }

    /**
     * 导出库存备件出入库列表
     */
    @RequiresPermissions("store:spareTrans:export")
    @Log(title = "库存备件出入库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StoreSpareTrans storeSpareTrans)
    {
        List<StoreSpareTrans> list = storeSpareTransService.selectStoreSpareTransList(storeSpareTrans);
        ExcelUtil<StoreSpareTrans> util = new ExcelUtil<StoreSpareTrans>(StoreSpareTrans.class);
        return util.exportExcel(list, "spareTrans");
    }

    /**
     * 新增库存备件出入库
     */
    @GetMapping("/add/{id}/{number}")
    public String add(@PathVariable("id") String id, @PathVariable("number") String number, ModelMap mmap)
    {
        mmap.put("spareId", id);
        mmap.put("totalNumber", number);
        return prefix + "/add";
    }

    /**
     * 新增保存库存备件出入库
     */
    @RequiresPermissions("store:spareTrans:add")
    @Log(title = "库存备件出入库", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StoreSpareTrans storeSpareTrans)
    {
        StoreSpare storeSpare = storeSpareService.selectStoreSpareById(storeSpareTrans.getSpareId());
        if("1".equals(storeSpareTrans.getTransFlag())){
            //入库增加总库存数量
            storeSpare.setNumber(storeSpare.getNumber() + storeSpareTrans.getNumber());
        }else if("2".equals(storeSpareTrans.getTransFlag())){
            //出库减少总库存数量
            storeSpare.setNumber(storeSpare.getNumber() - storeSpareTrans.getNumber());
        }
        if(0 != storeSpareService.updateStoreSpare(storeSpare)){
            return toAjax(storeSpareTransService.insertStoreSpareTrans(storeSpareTrans));
        }else {
            return toAjax(0);
        }

    }

    /**
     * 修改库存备件出入库
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        StoreSpareTrans storeSpareTrans = storeSpareTransService.selectStoreSpareTransById(id);
        mmap.put("storeSpareTrans", storeSpareTrans);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存备件出入库
     */
    @RequiresPermissions("store:spareTrans:edit")
    @Log(title = "库存备件出入库", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StoreSpareTrans storeSpareTrans)
    {
        return toAjax(storeSpareTransService.updateStoreSpareTrans(storeSpareTrans));
    }

    /**
     * 删除库存备件出入库
     */
    @RequiresPermissions("store:spareTrans:remove")
    @Log(title = "库存备件出入库", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(storeSpareTransService.deleteStoreSpareTransByIds(ids));
    }
}
