package com.bjeve.project.report.AnesMachine.controller;

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
import com.bjeve.project.report.AnesMachine.domain.RepAnesMachine;
import com.bjeve.project.report.AnesMachine.service.IRepAnesMachineService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 麻醉机安装报告Controller
 * 
 * @author chaiyuming
 * @date 2019-12-25
 */
@Controller
@RequestMapping("/report/AnesMachine")
public class RepAnesMachineController extends BaseController
{
    private String prefix = "report/AnesMachine";

    @Autowired
    private IRepAnesMachineService repAnesMachineService;

    @RequiresPermissions("report:AnesMachine:view")
    @GetMapping()
    public String AnesMachine()
    {
        return prefix + "/AnesMachine";
    }

    /**
     * 查询麻醉机安装报告列表
     */
    @RequiresPermissions("report:AnesMachine:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(RepAnesMachine repAnesMachine)
    {
        startPage();
        List<RepAnesMachine> list = repAnesMachineService.selectRepAnesMachineList(repAnesMachine);
        return getDataTable(list);
    }

    /**
     * 导出麻醉机安装报告列表
     */
    @RequiresPermissions("report:AnesMachine:export")
    @Log(title = "麻醉机安装报告", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(RepAnesMachine repAnesMachine)
    {
        List<RepAnesMachine> list = repAnesMachineService.selectRepAnesMachineList(repAnesMachine);
        ExcelUtil<RepAnesMachine> util = new ExcelUtil<RepAnesMachine>(RepAnesMachine.class);
        return util.exportExcel(list, "AnesMachine");
    }

    /**
     * 新增麻醉机安装报告
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存麻醉机安装报告
     */
    @RequiresPermissions("report:AnesMachine:add")
    @Log(title = "麻醉机安装报告", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(RepAnesMachine repAnesMachine)
    {
        return toAjax(repAnesMachineService.insertRepAnesMachine(repAnesMachine));
    }

    /**
     * 修改麻醉机安装报告
     */
    @GetMapping("/edit/{repId}")
    public String edit(@PathVariable("repId") String repId, ModelMap mmap)
    {
        RepAnesMachine repAnesMachine = repAnesMachineService.selectRepAnesMachineById(repId);
        mmap.put("repAnesMachine", repAnesMachine);
        return prefix + "/edit";
    }

    /**
     * 修改保存麻醉机安装报告
     */
    @RequiresPermissions("report:AnesMachine:edit")
    @Log(title = "麻醉机安装报告", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(RepAnesMachine repAnesMachine)
    {
        return toAjax(repAnesMachineService.updateRepAnesMachine(repAnesMachine));
    }

    /**
     * 删除麻醉机安装报告
     */
    @RequiresPermissions("report:AnesMachine:remove")
    @Log(title = "麻醉机安装报告", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(repAnesMachineService.deleteRepAnesMachineByIds(ids));
    }
}
