package com.bjeve.project.base.institutionsInfo.controller;

import java.util.List;
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
import com.bjeve.project.base.institutionsInfo.domain.InstitutionsInfo;
import com.bjeve.project.base.institutionsInfo.service.IInstitutionsInfoService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 机构信息维护Controller
 * 
 * @author chaiyuming
 * @date 2019-12-20
 */
@Controller
@RequestMapping("/base/institutionsInfo")
public class InstitutionsInfoController extends BaseController
{
    private String prefix = "base/institutionsInfo";

    @Autowired
    private IInstitutionsInfoService institutionsInfoService;

    @RequiresPermissions("base:institutionsInfo:view")
    @GetMapping()
    public String institutionsInfo()
    {
        return prefix + "/institutionsInfo";
    }

    /**
     * 查询机构信息维护列表
     */
    @RequiresPermissions("base:institutionsInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(InstitutionsInfo institutionsInfo)
    {
        startPage();
        List<InstitutionsInfo> list = institutionsInfoService.selectInstitutionsInfoList(institutionsInfo);
        return getDataTable(list);
    }

    /**
     * 导出机构信息维护列表
     */
    @RequiresPermissions("base:institutionsInfo:export")
    @Log(title = "机构信息维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(InstitutionsInfo institutionsInfo)
    {
        List<InstitutionsInfo> list = institutionsInfoService.selectInstitutionsInfoList(institutionsInfo);
        ExcelUtil<InstitutionsInfo> util = new ExcelUtil<InstitutionsInfo>(InstitutionsInfo.class);
        return util.exportExcel(list, "institutionsInfo");
    }

    /**
     * 新增机构信息维护
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存机构信息维护
     */
    @RequiresPermissions("base:institutionsInfo:add")
    @Log(title = "机构信息维护", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(InstitutionsInfo institutionsInfo)
    {
        return toAjax(institutionsInfoService.insertInstitutionsInfo(institutionsInfo));
    }

    /**
     * 修改机构信息维护
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        InstitutionsInfo institutionsInfo = institutionsInfoService.selectInstitutionsInfoById(id);
        mmap.put("institutionsInfo", institutionsInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存机构信息维护
     */
    @RequiresPermissions("base:institutionsInfo:edit")
    @Log(title = "机构信息维护", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(InstitutionsInfo institutionsInfo)
    {
        return toAjax(institutionsInfoService.updateInstitutionsInfo(institutionsInfo));
    }

    /**
     * 删除机构信息维护
     */
    @RequiresPermissions("base:institutionsInfo:remove")
    @Log(title = "机构信息维护", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(institutionsInfoService.deleteInstitutionsInfoByIds(ids));
    }
}
