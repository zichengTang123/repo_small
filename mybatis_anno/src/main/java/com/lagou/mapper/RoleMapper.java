package com.lagou.mapper;

import com.lagou.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    /*
    * 通过uid查询角色
    * */
    @Select("SELECT * FROM sys_role r INNER JOIN sys_user_role ur ON r.`id` = ur.`roleid` WHERE ur.`userid` =#{uid}")
    public List<Role> findByUid(Integer uid);
}
