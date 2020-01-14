package com.bjeve.project.store.spare.controller;

import java.util.List;

import com.bjeve.project.store.spareTrans.domain.StoreSpareTrans;
import com.bjeve.project.store.spareTrans.service.IStoreSpareTransService;
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
import com.bjeve.project.store.spare.domain.StoreSpare;
import com.bjeve.project.store.spare.service.IStoreSpareService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 库存备件Controller
 * 
 * @author chaiyuming
 * @date 2020-01-02
 */
@Controller
@RequestMapping("/store/spare")
public class StoreSpareController extends BaseController
{
    private String prefix = "store/spare";

    @Autowired
    private IStoreSpareService storeSpareService;

    @Autowired
    private IStoreSpareTransService storeSpareTransService;

    @RequiresPermissions("store:spare:view")
    @GetMapping()
    public String spare()
    {
        return prefix + "/spare";
    }

    /**
     * 查询库存备件列表
     */
    @RequiresPermissions("store:spare:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StoreSpare storeSpare)
    {
        startPage();
        List<StoreSpare> list = storeSpareService.selectStoreSpareList(storeSpare);
        List<StoreSpareTrans> storeSpareTrans = storeSpareTransService.selectStoreSpareTransList(new StoreSpareTrans());
        //对storeSpareTrans分组

        //顺序插入list

        return getDataTable(list);
    }

    /**
     * 导出库存备件列表
     */
    @RequiresPermissions("store:spare:export")
    @Log(title = "库存备件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StoreSpare storeSpare)
    {
        List<StoreSpare> list = storeSpareService.selectStoreSpareList(storeSpare);
        ExcelUtil<StoreSpare> util = new ExcelUtil<StoreSpare>(StoreSpare.class);
        return util.exportExcel(list, "spare");
    }

    /**
     * 新增库存备件
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存备件
     */
    @RequiresPermissions("store:spare:add")
    @Log(title = "库存备件", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StoreSpare storeSpare)
    {
        return toAjax(storeSpareService.insertStoreSpare(storeSpare));
    }

    /**
     * 修改库存备件
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        StoreSpare storeSpare = storeSpareService.selectStoreSpareById(id);
        mmap.put("storeSpare", storeSpare);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存备件
     */
    @RequiresPermissions("store:spare:edit")
    @Log(title = "库存备件", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StoreSpare storeSpare)
    {
        return toAjax(storeSpareService.updateStoreSpare(storeSpare));
    }

    /**
     * 删除库存备件
     */
    @RequiresPermissions("store:spare:remove")
    @Log(title = "库存备件", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(storeSpareService.deleteStoreSpareByIds(ids));
    }
}
