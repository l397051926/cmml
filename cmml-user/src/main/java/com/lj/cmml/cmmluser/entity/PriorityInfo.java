package com.lj.cmml.cmmluser.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author lmx
 * @since 2020-07-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PriorityInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * key
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 权限名字
     */
    private String priorityName;

    /**
     * 描述
     */
    private String description;

    /**
     * 父节点id
     */
    private Long parentId;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 创建人id
     */
    private Long createId;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    /**
     * 修改人id
     */
    private Long updateId;

    /**
     * 删除标识符 0未删除 1删除
     */
    private Integer delFlag;


}
