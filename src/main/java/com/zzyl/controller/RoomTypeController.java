package com.zzyl.controller;

import com.zzyl.mapper.RoomTypeMapper;
import com.zzyl.pojo.Result;
import com.zzyl.pojo.RoomType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomTypeController {
    @Autowired
    private RoomTypeMapper roomTypeMapper;
    //获取房间类型 请求路径：/customer/roomTypes
    //请求方式：GET
    @GetMapping("/customer/roomTypes")
    public Result<List<RoomType>> findAll(Integer status){
        List<RoomType> rts = roomTypeMapper.select(status);
        return Result.success(rts);
    }


}

