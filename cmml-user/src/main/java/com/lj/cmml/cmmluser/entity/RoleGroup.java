package com.lj.cmml.cmmluser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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
public class RoleGroup implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * key
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 角色组名字
     */
    private String groupName;

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
     * 删除标识符 0 未删除 1 已删除
     */
    private Integer delFlag;


}
