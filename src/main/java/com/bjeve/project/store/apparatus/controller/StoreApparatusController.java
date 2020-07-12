package com.bjeve.project.store.apparatus.controller;

import java.util.List;

import com.bjeve.project.monitor.server.domain.Sys;
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
import com.bjeve.project.store.apparatus.domain.StoreApparatus;
import com.bjeve.project.store.apparatus.service.IStoreApparatusService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 库存整机Controller
 * 
 * @author chaiyuming
 * @date 2020-01-13
 */
@Controller
@RequestMapping("/store/apparatus")
public class StoreApparatusController extends BaseController
{
    private String prefix = "store/apparatus";

    @Autowired
    private IStoreApparatusService storeApparatusService;

    @RequiresPermissions("store:apparatus:view")
    @GetMapping()
    public String apparatus(ModelMap mmap,String type)
    {
        mmap.put("apparType", type);
        return prefix + "/apparatus";
    }

    /**
     * 查询库存整机列表
     */
    @RequiresPermissions("store:apparatus:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(StoreApparatus storeApparatus)
    {
        startPage();
        List<StoreApparatus> list = storeApparatusService.selectStoreApparatusList(storeApparatus);
        return getDataTable(list);
    }

    /**
     * 导出库存整机列表
     */
    @RequiresPermissions("store:apparatus:export")
    @Log(title = "库存整机", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(StoreApparatus storeApparatus)
    {
        List<StoreApparatus> list = storeApparatusService.selectStoreApparatusList(storeApparatus);
        ExcelUtil<StoreApparatus> util = new ExcelUtil<StoreApparatus>(StoreApparatus.class);
        return util.exportExcel(list, "apparatus");
    }

    /**
     * 新增库存整机
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存库存整机
     */
    @RequiresPermissions("store:apparatus:add")
    @Log(title = "库存整机", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(StoreApparatus storeApparatus)
    {
        return toAjax(storeApparatusService.insertStoreApparatus(storeApparatus));
    }

    /**
     * 修改库存整机
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        StoreApparatus storeApparatus = storeApparatusService.selectStoreApparatusById(id);
        mmap.put("storeApparatus", storeApparatus);
        return prefix + "/edit";
    }

    /**
     * 修改保存库存整机
     */
    @RequiresPermissions("store:apparatus:edit")
    @Log(title = "库存整机", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(StoreApparatus storeApparatus)
    {
        return toAjax(storeApparatusService.updateStoreApparatus(storeApparatus));
    }

    /**
     * 删除库存整机
     */
    @RequiresPermissions("store:apparatus:remove")
    @Log(title = "库存整机", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(storeApparatusService.deleteStoreApparatusByIds(ids));
    }
}
