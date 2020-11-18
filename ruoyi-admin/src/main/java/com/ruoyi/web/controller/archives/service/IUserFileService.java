package com.ruoyi.web.controller.archives.service;

import com.ruoyi.web.controller.archives.domain.UserFile;

import java.util.List;

/**
 * 图片上传管理Service接口
 * 
 * @author zhoubiao
 * @date 2020-11-18
 */
public interface IUserFileService 
{
    /**
     * 查询图片上传管理
     * 
     * @param id 图片上传管理ID
     * @return 图片上传管理
     */
    public UserFile selectUserFileById(String id);

    /**
     * 查询图片上传管理列表
     * 
     * @param userFile 图片上传管理
     * @return 图片上传管理集合
     */
    public List<UserFile> selectUserFileList(UserFile userFile);

    /**
     * 新增图片上传管理
     * 
     * @param userFile 图片上传管理
     * @return 结果
     */
    public int insertUserFile(UserFile userFile);

    /**
     * 修改图片上传管理
     * 
     * @param userFile 图片上传管理
     * @return 结果
     */
    public int updateUserFile(UserFile userFile);

    /**
     * 批量删除图片上传管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteUserFileByIds(String ids);

    /**
     * 删除图片上传管理信息
     * 
     * @param id 图片上传管理ID
     * @return 结果
     */
    public int deleteUserFileById(String id);
}
