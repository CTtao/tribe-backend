package com.ct.tribe.domain;

import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName map
 */
@Data
public class Map implements Serializable {
    /**
     * 唯一标识符id
     */
    private Long id;

    /**
     * 地图名称
     */
    private String mapName;

    /**
     * 地图描述
     */
    private String mapDescription;

    private static final long serialVersionUID = 1L;
}