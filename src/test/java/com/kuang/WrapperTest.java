package com.kuang;/**
 * @author:Mr.Liu
 * @Date: 2022/2/28 20:42
 * @version: 1.0
 * @Description:
 */

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/2/28 20:42
 *@version: 1.0
 *
 */
@SpringBootTest
public class WrapperTest {
    @Autowired
    UserMapper userMapper;
    @Test
    void contextLoads() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Sandy").ge("age",20).isNotNull("email");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println );
    }
    @Test
    public  void test2(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("name", "Jack");
        QueryWrapper<User> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("name", "张胜男");
        List<User> users = userMapper.selectList(wrapper1);
        users.forEach(System.out::println);
        User user = userMapper.selectOne(wrapper);//如果多个结果使用selectMap，或者SelectList
        System.out.println(user) ;
    }
    @Test
    public  void testBetween(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age", 20, 30);
        Integer count = userMapper.selectCount(wrapper);//如果多个结果使用selectMap，或者SelectList
        System.out.println(count) ;
         List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public  void testLike(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.notLike("age",3).likeLeft("name", "e");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);//如果多个结果使用selectMap，或者SelectList
        maps.forEach(System.out::println);
    }
    //子查询
    @Test
    public  void testInSql(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.inSql("id", "select Id from user where id<4");
       // List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);//如果多个结果使用selectMap，或者SelectList
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }
    //子查询
    @Test
    public  void testOderBy(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("id");
        // List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);//如果多个结果使用selectMap，或者SelectList
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    //分页测试,or测试
    @Test
    public void testPage(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.le("age", 20).or().ge("age", 29);
        Page<User> page = new Page<>(1,5);
        IPage<User> userIPage = userMapper.selectPage(page, wrapper);
        page.getRecords().forEach(System.out::println);
        userIPage.getRecords().forEach(System.err::println);
    }
}
