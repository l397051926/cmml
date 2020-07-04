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
public class UserInfo implements Serializable {

    private static final long serialVersionUID=1L;

    /**
     * key
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名字
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 单位
     */
    private String unit;

    /**
     * 电话
     */
    private String phone;

    /**
     * 是否锁定 1 锁定 0放开
     */
    private Integer isLock;

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
     * 删除标记 1删除 0未删除
     */
    private Integer delFlag;


}
