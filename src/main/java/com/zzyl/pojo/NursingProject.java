package com.zzyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
    实体类：NursingProject（护理项目）
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NursingProject {
    private Long id;//主键
    private String name;//名称
    private Integer orderNo;//排序号
    private String unit;//单位
    private BigDecimal price;//价格
    private String image;//图片
    private String nursingRequirement;//护理要求
    private Integer status;//状态（0：禁用，1：启用）
    public LocalDateTime createTime;//创建时间
    public LocalDateTime updateTime;//更新时间
    private Long createBy;//创建人
    private Long updateBy;//更新人
    private String remark;//备注
}
