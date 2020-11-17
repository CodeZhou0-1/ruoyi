package com.ruoyi.web.controller.archives.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.web.controller.archives.mapper.User3Mapper;
import com.ruoyi.web.controller.archives.domain.User3;
import com.ruoyi.web.controller.archives.service.IUser3Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 申请审批表管理Service业务层处理
 * 
 * @author zhoubiao
 * @date 2020-11-17
 */
@Service
public class User3ServiceImpl implements IUser3Service 
{
    @Autowired
    private User3Mapper user3Mapper;

    /**
     * 查询申请审批表管理
     * 
     * @param id 申请审批表管理ID
     * @return 申请审批表管理
     */
    @Override
    public User3 selectUser3ById(String id)
    {
        return user3Mapper.selectUser3ById(id);
    }

    /**
     * 查询申请审批表管理列表
     * 
     * @param user3 申请审批表管理
     * @return 申请审批表管理
     */
    @Override
    public List<User3> selectUser3List(User3 user3)
    {
        return user3Mapper.selectUser3List(user3);
    }

    /**
     * 新增申请审批表管理
     * 
     * @param user3 申请审批表管理
     * @return 结果
     */
    @Override
    public int insertUser3(User3 user3)
    {
        return user3Mapper.insertUser3(user3);
    }

    /**
     * 修改申请审批表管理
     * 
     * @param user3 申请审批表管理
     * @return 结果
     */
    @Override
    public int updateUser3(User3 user3)
    {
        return user3Mapper.updateUser3(user3);
    }

    /**
     * 删除申请审批表管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUser3ByIds(String ids)
    {
        return user3Mapper.deleteUser3ByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除申请审批表管理信息
     * 
     * @param id 申请审批表管理ID
     * @return 结果
     */
    @Override
    public int deleteUser3ById(String id)
    {
        return user3Mapper.deleteUser3ById(id);
    }
}
