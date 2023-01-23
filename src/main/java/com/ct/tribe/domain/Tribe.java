package com.ct.tribe.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tribe
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tribe implements Serializable {
    /**
     * 唯一标识符id
     */
    private Long id;

    /**
     * 对应的用户id
     */
    private Long userId;

    /**
     * 部落昵称
     */
    private String tribeName;

    /**
     * 部落头像地址
     */
    private String avatar;

    /**
     * 部落所在的地图id
     */
    private Long mapId;

    /**
     * 加入该地图的时间
     */
    private Date enterMapTime;

    /**
     * 部落创建时间
     */
    private Date createTime;

    /**
     * 0为存在，1为已删除
     */
    private Integer isDelete;

    /**
     * 结算时间，为下次登录做计算的锚点
     */
    private Date settleTime;

    /**
     * 战斗力
     */
    private Integer score;

    /**
     * 资源-食物
     */
    private Integer resourceFood;

    /**
     * 资源-石材
     */
    private Integer resourceStone;

    /**
     * 资源-木材
     */
    private Integer resourceWood;

    /**
     * 资源-金币
     */
    private Integer resourceGold;

    private static final long serialVersionUID = 1L;
}