package com.zzyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
    实体类: 房型
*/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomType {
    private Long id;//主键
    private String name;//房型名称
    private Integer bedCount;//床位数量
    private BigDecimal price;//床位费用
    private String introduction;//介绍
    private String photo;//照片
    private Integer status;//状态，0：禁用，1：启用
    public LocalDateTime createTime;//创建时间
    public LocalDateTime updateTime;//更新时间
    private Long createBy;//创建人
    private Long updateBy;//更新人
    private String remark;//备注
}
