package com.ct.tribe.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tribe_building_merge
 */
@Data
public class TribeBuildingMerge implements Serializable {
    /**
     * 唯一标识符id
     */
    private Long id;

    /**
     * 部落id
     */
    private Long tribeId;

    /**
     * 建筑id
     */
    private Long buildingId;

    /**
     * 部落同种建筑的数量
     */
    private Integer buildingCount;

    private static final long serialVersionUID = 1L;
}