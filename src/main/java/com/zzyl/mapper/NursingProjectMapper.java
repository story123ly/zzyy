package com.zzyl.mapper;

import com.zzyl.pojo.NursingProject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NursingProjectMapper {

    List<NursingProject> findPage(Integer userId);

    NursingProject nusingProjectById(Integer id);
}
