package com.lagou.test;

import com.lagou.domain.Orders;
import com.lagou.domain.User;
import com.lagou.mapper.OrderMapper;
import com.lagou.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatisTest {


    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;


    // 在 @Test方法标注的方法执行之前来执行
    @Before
    public void before() throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("sqlMapConfig.xml");

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);

        sqlSession = sqlSessionFactory.openSession();
    }


    @After
    public void after() {

        sqlSession.commit();
        sqlSession.close();

    }


    /*
        测试查询方法
     */
    @Test
    public void testSelect() throws IOException {

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> all = mapper.findAll();

        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void testUpDate(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.delete(5);
    }

    @Test
    public void testOneToOne(){
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> ordersList = orderMapper.findAllWithUser();
        for (Orders orders : ordersList) {
            System.out.println(orders);
            //System.out.println(orders.getUser());
        }
    }

    @Test
    public void testOneToMany(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllWithOrders();
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user.getOrdersList());
        }
    }

    @Test
    public void testManyToMany(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.findAllWithRoles();
        for (User user : userList) {
            System.out.println(user);
            System.out.println(user.getRoleList());
        }
    }
}
