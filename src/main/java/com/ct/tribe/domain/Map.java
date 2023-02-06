package com.ct.tribe.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName map
 */
@TableName(value ="map")
@Data
public class Map implements Serializable {
    /**
     * 唯一标识符id
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 地图名称
     */
    private String mapName;

    /**
     * 地图描述
     */
    private String mapDescription;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Map other = (Map) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getMapName() == null ? other.getMapName() == null : this.getMapName().equals(other.getMapName()))
            && (this.getMapDescription() == null ? other.getMapDescription() == null : this.getMapDescription().equals(other.getMapDescription()))
            && (this.getResourceFood() == null ? other.getResourceFood() == null : this.getResourceFood().equals(other.getResourceFood()))
            && (this.getResourceStone() == null ? other.getResourceStone() == null : this.getResourceStone().equals(other.getResourceStone()))
            && (this.getResourceWood() == null ? other.getResourceWood() == null : this.getResourceWood().equals(other.getResourceWood()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getMapName() == null) ? 0 : getMapName().hashCode());
        result = prime * result + ((getMapDescription() == null) ? 0 : getMapDescription().hashCode());
        result = prime * result + ((getResourceFood() == null) ? 0 : getResourceFood().hashCode());
        result = prime * result + ((getResourceStone() == null) ? 0 : getResourceStone().hashCode());
        result = prime * result + ((getResourceWood() == null) ? 0 : getResourceWood().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mapName=").append(mapName);
        sb.append(", mapDescription=").append(mapDescription);
        sb.append(", resourceFood=").append(resourceFood);
        sb.append(", resourceStone=").append(resourceStone);
        sb.append(", resourceWood=").append(resourceWood);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}