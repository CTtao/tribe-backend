package com.ct.tribe.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tribe_building
 */
@Data
public class TribeBuilding implements Serializable {
    /**
     * 建筑唯一标识符id
     */
    private Long id;

    /**
     * 建筑名称
     */
    private String buildingName;

    /**
     * 建筑描述
     */
    private String buildingDescription;

    /**
     * 是否已删除
     */
    private Integer isDelete;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 科技因子
     */
    private Integer buildingScore;

    private static final long serialVersionUID = 1L;
}