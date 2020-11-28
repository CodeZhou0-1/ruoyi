package com.ruoyi.web.controller.archives.service;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ruoyi.web.controller.archives.domain.User3;
import io.swagger.annotations.ApiOperation;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@Service
public class TotalExportService {
    @Autowired
    private IUser3Service user3Service;

    public void ExportExcel(String id, HttpServletResponse response) {

        ExcelWriter writer = cn.hutool.poi.excel.ExcelUtil.getWriter(true);

        // 问题： 关于判断是否为null对象的判空条件--- 在Congtroller中判空
        // 问题2：注入每个表的service对象


        //1.根据id通过service对象查询到对象
        User3 user3 = user3Service.selectUser3ById(id);
        User3 user31 = user3Service.selectUser3ById("123");
        //2.然后将查询到的内容封装通过Collutils工具类到一个list中
        ArrayList<User3> rows = CollUtil.newArrayList(user3,user31);
        //3.设置每个字段对应的中文名称
        writer.addHeaderAlias("uName", "姓名");
        writer.addHeaderAlias("id", "身份证");
        writer.addHeaderAlias("village", "村委会");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("number", "家庭人口");
        writer.addHeaderAlias("uGroup", "某组居民");
        writer.addHeaderAlias("area0", "住房面积");
        writer.addHeaderAlias("area1", "承包责任田");
        writer.addHeaderAlias("area2", "责任山");
        //4.写入到excel中并命名表
        writer.write(rows, true);
        writer.renameSheet("申请审批表");





        writer.setSheet("信息采集入户调查表");
        ArrayList<User3> rows1 = CollUtil.newArrayList(user31);
        writer.write(rows1, true);


        writer.setSheet("贫困户家庭成员增加表");
        ArrayList<User3> rows2 = CollUtil.newArrayList(user31);
        writer.write(rows2, true);


        writer.setSheet("贫困户家庭成员减少表");
        ArrayList<User3> rows3 = CollUtil.newArrayList(user31);
        writer.write(rows3, true);



        //response为HttpServletResponse对象
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        //test.xls是弹出下载对话框的文件名，不能为中文，中文请自行编码
        response.setHeader("Content-Disposition","attachment;filename="+id+".xlsx");
        ServletOutputStream out= null;
        try {
            out = response.getOutputStream();
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            // 关闭writer，释放内存
            writer.close();
            //此处记得关闭输出Servlet流
            IoUtil.close(out);

        }
    }

}
