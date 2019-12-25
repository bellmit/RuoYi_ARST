package com.bjeve.project.report.ventilator.controller;

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
import com.bjeve.project.report.ventilator.domain.RepVentilator;
import com.bjeve.project.report.ventilator.service.IRepVentilatorService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 呼吸机安装报告Controller
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/report/ventilator")
public class RepVentilatorController extends BaseController
{
    private String prefix = "report/ventilator";

    @Autowired
    private IRepVentilatorService repVentilatorService;

    @RequiresPermissions("report:ventilator:view")
    @GetMapping()
    public String ventilator()
    {
        return prefix + "/ventilator";
    }

    /**
     * 查询呼吸机安装报告列表
     */
    @RequiresPermissions("report:ventilator:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RepVentilator repVentilator)
    {
        startPage();
        List<RepVentilator> list = repVentilatorService.selectRepVentilatorList(repVentilator);
        return getDataTable(list);
    }

    /**
     * 导出呼吸机安装报告列表
     */
    @RequiresPermissions("report:ventilator:export")
    @Log(title = "呼吸机安装报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RepVentilator repVentilator)
    {
        List<RepVentilator> list = repVentilatorService.selectRepVentilatorList(repVentilator);
        ExcelUtil<RepVentilator> util = new ExcelUtil<RepVentilator>(RepVentilator.class);
        return util.exportExcel(list, "ventilator");
    }

    /**
     * 新增呼吸机安装报告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存呼吸机安装报告
     */
    @RequiresPermissions("report:ventilator:add")
    @Log(title = "呼吸机安装报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RepVentilator repVentilator)
    {
        return toAjax(repVentilatorService.insertRepVentilator(repVentilator));
    }

    /**
     * 修改呼吸机安装报告
     */
    @GetMapping("/edit/{repId}")
    public String edit(@PathVariable("repId") String repId, ModelMap mmap)
    {
        RepVentilator repVentilator = repVentilatorService.selectRepVentilatorById(repId);
        mmap.put("repVentilator", repVentilator);
        return prefix + "/edit";
    }

    /**
     * 修改保存呼吸机安装报告
     */
    @RequiresPermissions("report:ventilator:edit")
    @Log(title = "呼吸机安装报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RepVentilator repVentilator)
    {
        return toAjax(repVentilatorService.updateRepVentilator(repVentilator));
    }

    /**
     * 删除呼吸机安装报告
     */
    @RequiresPermissions("report:ventilator:remove")
    @Log(title = "呼吸机安装报告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(repVentilatorService.deleteRepVentilatorByIds(ids));
    }
}
