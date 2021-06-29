package com.lagou.mapper;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface OrderMapper {

    /*
    * 一对一关联查询
    * */
    @Select("select * from orders")
    @Results({
            @Result(property = "id", column = "id", id = true),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "total", column = "total"),
            @Result(property = "uid", column = "uid"),
            @Result(property = "user", column = "uid", javaType = User.class,
                     one = @One(select = "com.lagou.mapper.UserMapper.findById", fetchType = FetchType.EAGER))
    })
    public List<Orders> findAllWithUser();

    /*
    * 通过uid，查询订单信息
    * */
    @Select("select * from orders where uid = #{uid}")
    public List<Orders> findOrdersByUid(Integer uid);
}
