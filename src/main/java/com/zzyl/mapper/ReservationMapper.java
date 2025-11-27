package com.zzyl.mapper;

import com.zzyl.pojo.Reservation;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface ReservationMapper {


    List<Reservation> findPage(Integer userId, Integer status);

    void insert(HashMap<String, Object> params);


    void updateStatus(HashMap<String, Object> params);
}
