package com.ct.tribe.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

/**
 * 
 * @TableName hero
 */
@Data
@TableName(value = "hero")
public class Hero implements Serializable {
    /**
     * 唯一标识符id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 英雄名称
     */
    private String heroName;

    /**
     * 战斗力
     */
    private Integer score;

    /**
     * 所属部落id
     */
    private Long tribeId;

    /**
     * 状态id
     */
    private Integer statusId;

    /**
     * 行为
     */
    private Integer actionId;

    /**
     * 默认
     */
    private Double appetite;

    /**
     * 优点id
     */
    private Integer advantageId;

    /**
     * 缺点id
     */
    private Integer disadvantageId;

    /**
     * 0为正常，1为已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 存数字，由前端确定具体图片
     */
    private Integer avatar;

    /**
     * 0为男，1为女，2为异族
     */
    private Integer gender;

    /**
     * 属性-力量
     */
    private Integer propPower;

    /**
     * 属性-智力
     */
    private Integer propIntelligence;

    /**
     * 属性-体质
     */
    private Integer propPhysique;

    /**
     * 属性-魅力
     */
    private Integer propGlamour;

    /**
     * 属性-运气
     */
    private Integer propFortune;

    /**
     * 属性-专注
     */
    private Integer propFocus;

    /**
     * 技能-采集-等级
     */
    private Integer skillCollectLevel;

    /**
     * 技能-采集-当前经验值
     */
    private Integer skillCollectExp;

    /**
     * 技能-砍伐-等级
     */
    private Integer skillFellLevel;

    /**
     * 技能-砍伐-当前经验值
     */
    private Integer skillFellExp;

    /**
     * 技能-挖掘-等级
     */
    private Integer skillDigLevel;

    /**
     * 技能-挖掘-当前经验值
     */
    private Integer skillDigExp;

    /**
     * 技能-狩猎-等级
     */
    private Integer skillHuntLevel;

    /**
     * 技能-狩猎-当前经验值
     */
    private Integer skillHuntExp;

    private static final long serialVersionUID = 1L;
}