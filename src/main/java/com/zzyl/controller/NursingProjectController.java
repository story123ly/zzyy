package com.zzyl.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzyl.mapper.NursingProjectMapper;
import com.zzyl.pojo.NursingProject;
import com.zzyl.pojo.PageResult;
import com.zzyl.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NursingProjectController {
    @Autowired
    NursingProjectMapper nursingProjectMapper;
    //分页查询护理服务 请求路径：/customer/orders/project/page
    //请求方式：GET
    // 请求数据样例:
    //customer/orders/project/page?userId=1&pageNum=1&pageSize=10
    @GetMapping("/customer/orders/project/page")
    public Result<PageResult<NursingProject>> findByPage1(Integer userId,Integer pageNum, Integer pageSize) {

        //1. 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //2. 查询数据
        List<NursingProject> records = nursingProjectMapper.findPage(userId);
        //3. 获取分页数据
        Page<NursingProject> p = (Page<NursingProject>) records;
        //4. 创建分页结果对象
        PageResult<NursingProject> pr = new PageResult<>();
        //5. 设置分页结果对象
        pr.setPage(pageNum);
        pr.setPages(Long.valueOf(p.getPages()));
        pr.setPageSize(pageSize);
        pr.setTotal(p.getTotal());
        pr.setRecords(records);
        //6. 响应结果对象
        return Result.success(pr);
    }
    //护理服务详情查询
    @GetMapping("/customer/orders/project/{id}")
    public Result<NursingProject> detail(@PathVariable Integer id) {
        //1. 调用mapper查询
        NursingProject nursingProject = nursingProjectMapper.nusingProjectById(id);
        //2. 响应结果对象
        return Result.success(nursingProject);
    }


}
