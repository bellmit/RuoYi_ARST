package com.bjeve.project.base.deviceInfo.controller;

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
import com.bjeve.project.base.deviceInfo.domain.DeviceInfo;
import com.bjeve.project.base.deviceInfo.service.IDeviceInfoService;
import com.bjeve.framework.web.controller.BaseController;
import com.bjeve.framework.web.domain.AjaxResult;
import com.bjeve.common.utils.poi.ExcelUtil;
import com.bjeve.framework.web.page.TableDataInfo;

/**
 * 设备信息Controller
 * 
 * @author chaiyuming
 * @date 2019-12-23
 */
@Controller
@RequestMapping("/base/deviceInfo")
public class DeviceInfoController extends BaseController
{
    private String prefix = "base/deviceInfo";

    @Autowired
    private IDeviceInfoService deviceInfoService;

    @RequiresPermissions("base:deviceInfo:view")
    @GetMapping()
    public String deviceInfo()
    {
        return prefix + "/deviceInfo";
    }

    /**
     * 查询设备信息列表
     */
    @RequiresPermissions("base:deviceInfo:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(DeviceInfo deviceInfo)
    {
        startPage();
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        return getDataTable(list);
    }

    /**
     * 导出设备信息列表
     */
    @RequiresPermissions("base:deviceInfo:export")
    @Log(title = "设备信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(DeviceInfo deviceInfo)
    {
        List<DeviceInfo> list = deviceInfoService.selectDeviceInfoList(deviceInfo);
        ExcelUtil<DeviceInfo> util = new ExcelUtil<DeviceInfo>(DeviceInfo.class);
        return util.exportExcel(list, "deviceInfo");
    }

    /**
     * 新增设备信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存设备信息
     */
    @RequiresPermissions("base:deviceInfo:add")
    @Log(title = "设备信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.insertDeviceInfo(deviceInfo));
    }

    /**
     * 修改设备信息
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        DeviceInfo deviceInfo = deviceInfoService.selectDeviceInfoById(id);
        mmap.put("deviceInfo", deviceInfo);
        return prefix + "/edit";
    }

    /**
     * 修改保存设备信息
     */
    @RequiresPermissions("base:deviceInfo:edit")
    @Log(title = "设备信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(DeviceInfo deviceInfo)
    {
        return toAjax(deviceInfoService.updateDeviceInfo(deviceInfo));
    }

    /**
     * 删除设备信息
     */
    @RequiresPermissions("base:deviceInfo:remove")
    @Log(title = "设备信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(deviceInfoService.deleteDeviceInfoByIds(ids));
    }
}
