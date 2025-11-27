package com.zzyl.mapper;

import com.zzyl.pojo.RoomType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomTypeMapper {

    List<RoomType> select(Integer status);
}
