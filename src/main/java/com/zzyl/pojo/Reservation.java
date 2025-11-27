package com.zzyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/*
    实体类: 预约
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    private Long id;//主键ID
    private String name;//预约人
    private String mobile;//预约人手机号
    private LocalDateTime time;//时间
    private String visitor;//探访人
    private Integer type;//预约类型，0：参观预约，1：探访预约
    private Integer status;//预约状态，0：待报道，1：已完成，2：取消，3：过期
    public LocalDateTime createTime;//创建时间
    public LocalDateTime updateTime;//更新时间
    private Long createBy;//创建人
    private Long updateBy;//更新人
    private String remark;//备注
 }

