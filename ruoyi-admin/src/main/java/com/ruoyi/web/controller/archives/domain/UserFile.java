package com.ruoyi.web.controller.archives.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片上传管理对象 user_file
 * 
 * @author zhoubiao
 * @date 2020-11-18
 */
public class UserFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 户主身份证号码 */
    private String id;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String filePath;

    public void setId(String id) 
    {
        this.id = id;
    }

    public String getId() 
    {
        return id;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .toString();
    }
}
