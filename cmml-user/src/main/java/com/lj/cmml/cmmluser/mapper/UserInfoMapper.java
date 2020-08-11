package com.lj.cmml.cmmluser.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lj.cmml.cmmluser.entity.UserInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lmx
 * @since 2020-07-04
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    IPage<UserInfo> queryUser(IPage<UserInfo> page,
                              @Param("searchVal") String searchVal);
}
