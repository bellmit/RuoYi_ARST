package com.bjeve.project.report.maintenance.controller;

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
import com.bjeve.project.report.maintenance.domain.RepMaintenance;
import com.bjeve.project.report.maintenance.service.IRepMaintenanceService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 维修报告Controller
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/report/maintenance")
public class RepMaintenanceController extends BaseController
{
    private String prefix = "report/maintenance";

    @Autowired
    private IRepMaintenanceService repMaintenanceService;

    @RequiresPermissions("report:maintenance:view")
    @GetMapping()
    public String maintenance()
    {
        return prefix + "/maintenance";
    }

    /**
     * 查询维修报告列表
     */
    @RequiresPermissions("report:maintenance:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RepMaintenance repMaintenance)
    {
        startPage();
        List<RepMaintenance> list = repMaintenanceService.selectRepMaintenanceList(repMaintenance);
        return getDataTable(list);
    }

    /**
     * 导出维修报告列表
     */
    @RequiresPermissions("report:maintenance:export")
    @Log(title = "维修报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RepMaintenance repMaintenance)
    {
        List<RepMaintenance> list = repMaintenanceService.selectRepMaintenanceList(repMaintenance);
        ExcelUtil<RepMaintenance> util = new ExcelUtil<RepMaintenance>(RepMaintenance.class);
        return util.exportExcel(list, "maintenance");
    }

    /**
     * 新增维修报告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存维修报告
     */
    @RequiresPermissions("report:maintenance:add")
    @Log(title = "维修报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RepMaintenance repMaintenance)
    {
        return toAjax(repMaintenanceService.insertRepMaintenance(repMaintenance));
    }

    /**
     * 修改维修报告
     */
    @GetMapping("/edit/{repId}")
    public String edit(@PathVariable("repId") String repId, ModelMap mmap)
    {
        RepMaintenance repMaintenance = repMaintenanceService.selectRepMaintenanceById(repId);
        mmap.put("repMaintenance", repMaintenance);
        return prefix + "/edit";
    }

    /**
     * 修改保存维修报告
     */
    @RequiresPermissions("report:maintenance:edit")
    @Log(title = "维修报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RepMaintenance repMaintenance)
    {
        return toAjax(repMaintenanceService.updateRepMaintenance(repMaintenance));
    }

    /**
     * 删除维修报告
     */
    @RequiresPermissions("report:maintenance:remove")
    @Log(title = "维修报告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(repMaintenanceService.deleteRepMaintenanceByIds(ids));
    }
}
