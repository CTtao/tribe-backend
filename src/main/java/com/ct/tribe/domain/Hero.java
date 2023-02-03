package com.ct.tribe.domain;

import java.io.Serializable;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.annotation.*;
import com.ct.tribe.constants.HeroConstants;
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
    private Integer statusId = 0;

    /**
     * 行为
     */
    private Integer actionId = 4;

    /**
     * 默认
     */
    private Double appetite;

    /**
     * 优点id
     */
    private Integer advantageId = -1;

    /**
     * 缺点id
     */
    private Integer disadvantageId = -1;

    /**
     * 0为正常，1为已删除
     */
    @TableField(fill = FieldFill.INSERT)
    private Integer isDelete = 0;

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
    private Integer propPower = 0;

    /**
     * 属性-智力
     */
    private Integer propIntelligence = 0;

    /**
     * 属性-体质
     */
    private Integer propPhysique = 0;

    /**
     * 属性-魅力
     */
    private Integer propGlamour = 0;

    /**
     * 属性-运气
     */
    private Integer propFortune = 0;

    /**
     * 属性-专注
     */
    private Integer propFocus = 0;

    /**
     * 技能-采集-等级
     */
    private Integer skillCollectLevel = 1;

    /**
     * 技能-采集-当前经验值
     */
    private Integer skillCollectExp = 0;

    /**
     * 技能-砍伐-等级
     */
    private Integer skillFellLevel = 1;

    /**
     * 技能-砍伐-当前经验值
     */
    private Integer skillFellExp = 0;

    /**
     * 技能-挖掘-等级
     */
    private Integer skillDigLevel = 1;

    /**
     * 技能-挖掘-当前经验值
     */
    private Integer skillDigExp = 0;

    /**
     * 技能-狩猎-等级
     */
    private Integer skillHuntLevel = 1;

    /**
     * 技能-狩猎-当前经验值
     */
    private Integer skillHuntExp = 0;

    private static final long serialVersionUID = 1L;

    public Hero(Long tribeId, int gender) {
        this.setTribeId(tribeId);
        this.setGender(gender);
        this.initHeroName();
        this.initAppetite();
        this.initAvatar();
        this.initProps();
        this.initScore();
    }
    /**
     * 初始化胃口量
     * @return
     */
    public void initAppetite(){
        double appetite;
        if(this.getGender()==0) {
            appetite = RandomUtil.randomDouble(0.6, 1.1, 1, RoundingMode.HALF_UP);
        }else {
            appetite = RandomUtil.randomDouble(0.7, 1.2, 1, RoundingMode.HALF_UP);
        }
        // 优点：小鸟胃
        if(this.getAdvantageId() == 0) {
            appetite /= 2;
        }
        // 缺点：大胃王
        if(this.getDisadvantageId() == 0) {
            appetite *= 2;
        }
        this.setAppetite(appetite);
    }
    /**
     * 随机生成头像index
     * @return
     */
    private void initAvatar(){
        int avatar;
        if (this.getGender() == 0){
            avatar = RandomUtil.randomInt(0, HeroConstants.MAX_MALE_AVATAR);
        } else if (this.getGender() == 1){
            avatar = RandomUtil.randomInt(0,HeroConstants.MAX_FEMALE_AVATAR);
        } else  {
            avatar = RandomUtil.randomInt(0,HeroConstants.MAX_OTHER_AVATAR);
        }
        this.setAvatar(avatar);
    }
    /**
     * 随机生成英雄姓名
     * @return
     */
    private void initHeroName(){
        String lastName = RandomUtil.randomEle(HeroConstants.LAST_NAME);
        String firstName;
        if (this.getGender() == 0){
            firstName = RandomUtil.randomEle(HeroConstants.FIRST_NAME_MALE);
        }else if (this.getGender() == 1){
            firstName = RandomUtil.randomEle(HeroConstants.FIRST_NAME_FEMALE);
        }else firstName = "other";
        this.setHeroName(lastName + firstName);
    }
    /**
     * 计算战斗力
     * 战斗力 = 力量 * 2 + （其他属性） * 1
     * @return
     */
    private void initScore(){
        int score = this.getPropPower() * 2 + (this.getPropIntelligence()+this.getPropPhysique()+this.getPropGlamour()+this.getPropFortune()+this.getPropFocus()) * 1;
        this.setScore(score);
    }
    private void initProps() {
        int[] propList = {0,0,0,0,0,0};
        for (int i = 0; i < HeroConstants.DEFAULT_PROPS; i++) {
            propList[RandomUtil.randomInt(0,6)]++;
        }
        this.setPropPower(propList[0]);
        this.setPropIntelligence(propList[1]);
        this.setPropPhysique(propList[2]);
        this.setPropGlamour(propList[3]);
        this.setPropFortune(propList[4]);
        this.setPropFocus(propList[5]);
    }
}