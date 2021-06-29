package com.lagou.mapper;

import com.lagou.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

@CacheNamespace // 配置了二级缓存
public interface UserMapper {

    /*
        查询用户
     */
    @Select("select * from user")
    public List<User> findAll();


    /*
        添加用户
     */
    @Insert("insert into user(username,birthday,sex,address) values(#{username},#{birthday},#{sex},#{address})")
    public void save(User user);


    /*
        更新用户
     */
    @Update("update user set username = #{username},birthday=#{birthday} where id = #{id}")
    public void update(User user);


    /*
        删除用户
     */
    @Delete("delete from user where id = #{id}")
    public void delete(Integer id);



    /*
        根据id查询用户
     */
    @Select("select * from user where id = #{uid}")
    public User findById(Integer uid);

    /*
    * 查询所有用户以及对应的订单信息
    * */
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "ordersList", javaType = List.class, column = "id", many=@Many(select = "com.lagou.mapper.OrderMapper.findOrdersByUid"))
    })
    public List<User> findAllWithOrders();


    /*
    * 查询所有用户，以及关联的角色信息
    * */
    @Select("select * from user")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "username", column = "username"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "address", column = "address"),
            @Result(property = "birthday", column = "birthday"),
            @Result(property = "roleList", javaType = List.class, column = "id", many=@Many(select = "com.lagou.mapper.RoleMapper.findByUid"))
    })
    public List<User> findAllWithRoles();
}
