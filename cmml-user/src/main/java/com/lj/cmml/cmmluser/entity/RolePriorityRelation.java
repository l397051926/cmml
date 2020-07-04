package com.lj.cmml.cmmluser.entity;

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
public class RolePriorityRelation implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * key
     */
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
