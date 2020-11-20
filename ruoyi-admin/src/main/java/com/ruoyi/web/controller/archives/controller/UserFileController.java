package com.ruoyi.web.controller.archives.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.archives.domain.UserFile;
import com.ruoyi.web.controller.archives.service.IUserFileService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import oshi.util.GlobalConfig;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 图片上传管理Controller
 * 
 * @author zhoubiao
 * @date 2020-11-18
 */
@Controller
@RequestMapping("/system/archivefile")
public class UserFileController extends BaseController
{
    private String prefix = "system/archivefile";

    @Autowired
    private IUserFileService userFileService;
    @Autowired
    private Global global;

    @RequiresPermissions("system:archivefile:view")
    @GetMapping()
    public String archivefile()
    {
        return prefix + "/archivefile";
    }

    /**
     * 查询图片上传管理列表
     */
    @RequiresPermissions("system:archivefile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserFile userFile)
    {
        startPage();
        List<UserFile> list = userFileService.selectUserFileList(userFile);
        return getDataTable(list);
    }

    /**
     * 导出图片上传管理列表
     */
    @RequiresPermissions("system:archivefile:export")
    @Log(title = "图片上传管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(UserFile userFile)
    {
        List<UserFile> list = userFileService.selectUserFileList(userFile);
        ExcelUtil<UserFile> util = new ExcelUtil<UserFile>(UserFile.class);
        return util.exportExcel(list, "archivefile");
    }

     /**
     * 新增图片上传管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增图片上传管理
    */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestParam("file") MultipartFile file, UserFile userFile) throws IOException
    {
        // 上传文件路径
        String filePath = Global.getUploadPath();
        // 上传并返回新文件路径
        String fileName = FileUploadUtils.upload(filePath, file);
        System.out.println(fileName);
        userFile.setFilePath(fileName);
        return toAjax(userFileService.insertUserFile(userFile));
    }
    /**
     * 本地资源通用下载
     */

    @GetMapping(value = "/common/download/resource",produces = "multipart/form-data")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        // 本地资源路径
        String localPath = Global.getProfile();
        // 数据库资源地址
        String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
        // 下载名称
        String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
        // 下载名称改为从数据库中查询到的文件名称

        response.setCharacterEncoding("utf-8");
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + FileUtils.setFileDownloadHeader(request, downloadName));
        FileUtils.writeBytes(downloadPath, response.getOutputStream());
    }

 /*   *//**
     * 新增保存图片上传管理
     *//*
    @RequiresPermissions("system:archivefile:add")
    @Log(title = "图片上传管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(UserFile userFile)
    {
        return toAjax(userFileService.insertUserFile(userFile));
    }*/

    /**
     * 修改图片上传管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        UserFile userFile = userFileService.selectUserFileById(id);
        mmap.put("userFile", userFile);
        return prefix + "/edit";
    }

    /**
     * 修改保存图片上传管理
     */
    @RequiresPermissions("system:archivefile:edit")
    @Log(title = "图片上传管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(UserFile userFile)
    {
        return toAjax(userFileService.updateUserFile(userFile));
    }

    /**
     * 删除图片上传管理
     */
    @RequiresPermissions("system:archivefile:remove")
    @Log(title = "图片上传管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        //拿到数据库的文件路径 然后根据文件路径删除文件
        UserFile userFile = userFileService.selectUserFileById(ids);
        String filepath = userFile.getFilePath();
        String profile = Global.getProfile();
        String newPath = filepath.replace("/profile", profile);
        FileUploadUtils.delAllFile(newPath);
        //删除数据库记录
        return toAjax(userFileService.deleteUserFileByIds(ids));
    }
}




