package com.bjeve.project.base.deviceInfo.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bjeve.project.base.deviceInfo.mapper.DeviceInfoMapper;
import com.bjeve.project.base.deviceInfo.domain.DeviceInfo;
import com.bjeve.project.base.deviceInfo.service.IDeviceInfoService;
import com.bjeve.common.utils.text.Convert;

/**
 * 设备信息Service业务层处理
 * 
 * @author chaiyuming
 * @date 2019-12-23
 */
@Service
public class DeviceInfoServiceImpl implements IDeviceInfoService 
{
    @Autowired
    private DeviceInfoMapper deviceInfoMapper;

    /**
     * 查询设备信息
     * 
     * @param id 设备信息ID
     * @return 设备信息
     */
    @Override
    public DeviceInfo selectDeviceInfoById(String id)
    {
        return deviceInfoMapper.selectDeviceInfoById(id);
    }

    /**
     * 查询设备信息列表
     * 
     * @param deviceInfo 设备信息
     * @return 设备信息
     */
    @Override
    public List<DeviceInfo> selectDeviceInfoList(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.selectDeviceInfoList(deviceInfo);
    }

    /**
     * 新增设备信息
     * 
     * @param deviceInfo 设备信息
     * @return 结果
     */
    @Override
    public int insertDeviceInfo(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.insertDeviceInfo(deviceInfo);
    }

    /**
     * 修改设备信息
     * 
     * @param deviceInfo 设备信息
     * @return 结果
     */
    @Override
    public int updateDeviceInfo(DeviceInfo deviceInfo)
    {
        return deviceInfoMapper.updateDeviceInfo(deviceInfo);
    }

    /**
     * 删除设备信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteDeviceInfoByIds(String ids)
    {
        return deviceInfoMapper.deleteDeviceInfoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除设备信息信息
     * 
     * @param id 设备信息ID
     * @return 结果
     */
    @Override
    public int deleteDeviceInfoById(String id)
    {
        return deviceInfoMapper.deleteDeviceInfoById(id);
    }
}
