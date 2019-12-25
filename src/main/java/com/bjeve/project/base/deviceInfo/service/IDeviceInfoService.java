package com.bjeve.project.base.deviceInfo.service;

import com.bjeve.project.base.deviceInfo.domain.DeviceInfo;
import java.util.List;

/**
 * 设备信息Service接口
 * 
 * @author chaiyuming
 * @date 2019-12-23
 */
public interface IDeviceInfoService 
{
    /**
     * 查询设备信息
     * 
     * @param id 设备信息ID
     * @return 设备信息
     */
    public DeviceInfo selectDeviceInfoById(String id);

    /**
     * 查询设备信息列表
     * 
     * @param deviceInfo 设备信息
     * @return 设备信息集合
     */
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo);

    /**
     * 新增设备信息
     * 
     * @param deviceInfo 设备信息
     * @return 结果
     */
    public int insertDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 修改设备信息
     * 
     * @param deviceInfo 设备信息
     * @return 结果
     */
    public int updateDeviceInfo(DeviceInfo deviceInfo);

    /**
     * 批量删除设备信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteDeviceInfoByIds(String ids);

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息ID
     * @return 结果
     */
    public int deleteDeviceInfoById(String id);
}
