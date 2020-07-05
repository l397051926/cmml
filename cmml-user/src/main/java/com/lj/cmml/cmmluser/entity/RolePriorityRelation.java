package com.lj.cmml.cmmluser.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

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
public class RolePriorityRelation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * key
     */
    @TableId(value = "id", type = IdType.AUTO)
      private Long id;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 权限id
     */
    private Long priorityId;


}
