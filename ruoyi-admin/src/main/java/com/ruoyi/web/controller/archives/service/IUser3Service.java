package com.ruoyi.web.controller.archives.service;

import com.ruoyi.web.controller.archives.domain.User3;

import java.util.List;

/**
 * 申请审批表管理Service接口
 * 
 * @author zhoubiao
 * @date 2020-11-17
 */
public interface IUser3Service 
{
    /**
     * 查询申请审批表管理
     * 
     * @param id 申请审批表管理ID
     * @return 申请审批表管理
     */
    public User3 selectUser3ById(String id);

    /**
     * 查询申请审批表管理列表
     * 
     * @param user3 申请审批表管理
     * @return 申请审批表管理集合
     */
    public List<User3> selectUser3List(User3 user3);

    /**
     * 新增申请审批表管理
     * 
     * @param user3 申请审批表管理
     * @return 结果
     */
    public int insertUser3(User3 user3);

    /**
     * 修改申请审批表管理
     * 
     * @param user3 申请审批表管理
     * @return 结果
     */
    public int updateUser3(User3 user3);

    /**
     * 批量删除申请审批表管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUser3ByIds(String ids);

    /**
     * 删除申请审批表管理信息
     * 
     * @param id 申请审批表管理ID
     * @return 结果
     */
    public int deleteUser3ById(String id);
}
