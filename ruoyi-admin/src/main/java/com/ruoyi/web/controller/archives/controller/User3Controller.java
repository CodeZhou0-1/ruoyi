package com.ruoyi.web.controller.archives.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.web.controller.archives.domain.User3;
import com.ruoyi.web.controller.archives.service.IUser3Service;
import com.ruoyi.web.controller.archives.service.TotalExportService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 申请审批表管理Controller
 * 
 * @author zhoubiao
 * @date 2020-11-17
 */
@Api("用户管理")
@Controller
@RequestMapping("/system/archives")
public class User3Controller extends BaseController
{
    private String prefix = "system/archives";

    @Autowired
    private IUser3Service user3Service;

    @Autowired
    private TotalExportService totalExportService;

    @ApiOperation("总导出excel")
    @GetMapping("/excel")
    @ResponseBody
    public void totalExport(String id, HttpServletResponse response) throws Exception {

        User3 user3 = user3Service.selectUser3ById(id);
        if (user3 == null) {
            throw new Exception("请确定是否有该身份证号码！");
        }
        totalExportService.ExportExcel(id, response);

    }


    @RequiresPermissions("system:archives:view")
    @GetMapping()
    public String archives() {

        return prefix + "/archives";
    }

    /**
     * 查询申请审批表管理列表
     */
    @RequiresPermissions("system:archives:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(User3 user3)
    {
        startPage();
        List<User3> list = user3Service.selectUser3List(user3);
        return getDataTable(list);
    }

    /**
     * 导出申请审批表管理列表
     */
    @RequiresPermissions("system:archives:export")
    @Log(title = "申请审批表管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(User3 user3)
    {
        List<User3> list = user3Service.selectUser3List(user3);
        ExcelUtil<User3> util = new ExcelUtil<User3>(User3.class);
        return util.exportExcel(list, "archives");
    }

    /**
     * 新增申请审批表管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存申请审批表管理
     */
    @RequiresPermissions("system:archives:add")
    @Log(title = "申请审批表管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@Valid User3 user3)
    {
        return toAjax(user3Service.insertUser3(user3));
    }

    /**
     * 修改申请审批表管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, ModelMap mmap)
    {
        User3 user3 = user3Service.selectUser3ById(id);
        mmap.put("user3", user3);
        return prefix + "/edit";
    }

    /**
     * 修改保存申请审批表管理
     */
    @RequiresPermissions("system:archives:edit")
    @Log(title = "申请审批表管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(User3 user3)
    {
        return toAjax(user3Service.updateUser3(user3));
    }

    /**
     * 删除申请审批表管理
     */
    @RequiresPermissions("system:archives:remove")
    @Log(title = "申请审批表管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(user3Service.deleteUser3ByIds(ids));
    }
}
