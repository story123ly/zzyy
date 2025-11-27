package com.zzyl.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzyl.mapper.ReservationMapper;
import com.zzyl.pojo.PageResult;
import com.zzyl.pojo.Reservation;
import com.zzyl.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationMapper reservationMapper;
    //1.预约查询
    @GetMapping("/customer/reservation/page")
    public Result<PageResult<Reservation>> findByPage(Integer userId, Integer status, Integer pageNum, Integer pageSize) {

        //1. 设置分页参数
        PageHelper.startPage(pageNum,pageSize);
        //2. 查询数据
        List<Reservation> records = reservationMapper.findPage(userId,status);
        //3. 获取分页数据
        Page<Reservation> p = (Page<Reservation>) records;
        //4. 创建分页结果对象
        PageResult<Reservation> pr = new PageResult<>();
        //5. 设置分页结果对象
        pr.setPage(pageNum);
        pr.setPages(Long.valueOf(p.getPages()));
        pr.setPageSize(pageSize);
        pr.setTotal(p.getTotal());
        pr.setRecords(records);
        //6. 响应结果对象
        return Result.success(pr);
    }
    //1.2新增预约
    @PostMapping("/customer/reservation")
    public Result addReservation(@RequestBody HashMap<String,Object> params){
        //补全数据
        //1.补全状态
        params.put("status",0);
        //2.补全创建时间
        params.put("createTime", LocalDateTime.now());
        //3.补全更新时间
        params.put("updateTime", LocalDateTime.now());

        //调用mapper完成添加
        reservationMapper.insert(params);
        return Result.success();
    }
    //1.3取消预约
    // 请求路径：/customer/reservation/预约Id/cancel
    //请求方式：PUT
    //接口描述：该接口用于取消已有的预约
    //请求数据样例:
    //customer/reservation/300/cancel?userId=1
    @PutMapping ("/customer/reservation/{id}/cancel")
    public Result cancelReservation(@PathVariable Integer id, Integer userId){
       //封装参数
        HashMap<String,Object> params = new HashMap<>();
        params.put("id",id);
        params.put("userId",userId);
        params.put("status",2);
        params.put("updateTime",LocalDateTime.now());
        //更新状态
        reservationMapper.updateStatus(params);
        return Result.success();
    }



}

