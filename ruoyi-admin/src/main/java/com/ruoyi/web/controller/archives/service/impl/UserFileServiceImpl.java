package com.ruoyi.web.controller.archives.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.web.controller.archives.domain.UserFile;
import com.ruoyi.web.controller.archives.mapper.UserFileMapper;
import com.ruoyi.web.controller.archives.service.IUserFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 图片上传管理Service业务层处理
 * 
 * @author zhoubiao
 * @date 2020-11-18
 */
@Service
public class UserFileServiceImpl implements IUserFileService 
{
    @Autowired
    private UserFileMapper userFileMapper;

    /**
     * 查询图片上传管理
     * 
     * @param id 图片上传管理ID
     * @return 图片上传管理
     */
    @Override
    public UserFile selectUserFileById(String id)
    {
        return userFileMapper.selectUserFileById(id);
    }

    /**
     * 查询图片上传管理列表
     * 
     * @param userFile 图片上传管理
     * @return 图片上传管理
     */
    @Override
    public List<UserFile> selectUserFileList(UserFile userFile)
    {
        return userFileMapper.selectUserFileList(userFile);
    }

    /**
     * 新增图片上传管理
     * 
     * @param userFile 图片上传管理
     * @return 结果
     */
    @Override
    public int insertUserFile(UserFile userFile)
    {
        return userFileMapper.insertUserFile(userFile);
    }

    /**
     * 修改图片上传管理
     * 
     * @param userFile 图片上传管理
     * @return 结果
     */
    @Override
    public int updateUserFile(UserFile userFile)
    {
        return userFileMapper.updateUserFile(userFile);
    }

    /**
     * 删除图片上传管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteUserFileByIds(String ids)
    {
        return userFileMapper.deleteUserFileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除图片上传管理信息
     * 
     * @param id 图片上传管理ID
     * @return 结果
     */
    @Override
    public int deleteUserFileById(String id)
    {
        return userFileMapper.deleteUserFileById(id);
    }
}
