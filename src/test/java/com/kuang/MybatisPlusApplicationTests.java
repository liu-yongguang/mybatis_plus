package com.kuang;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kuang.mapper.UserMapper;
import com.kuang.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {
    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {


        //参数是一个wrapper，条件构造器，这里我们先不用
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println );
    }

    @Test
    public void testInsert(){
         User user1=new User( );
    user1.setAge(919);
    user1.setEmail("1123@qq.com");
    user1.setName("张胜男");
        int result = userMapper.insert(user1);
        System.out.println(result);
    }
    @Test
    public void testUpdate(){
        User user1=new User( );
        user1.setId(11l);
        user1.setAge(19);
        user1.setEmail("1123@qq.com");
        user1.setName("张胜男");
        int result = userMapper.updateById(user1);
        System.out.println(result);
    }
    //测试乐观锁成功
    @Test
    public void testOptimisticLocker(){
        User user = userMapper.selectById(1L);
        user.setName("zhang_san");
        user.setAge(39);
        user.setEmail("112121212133@qq.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }
    //测试乐观锁失败，多线程下
    @Test
    public void testOptimisticLocker1(){
        //线程1,
        User user = userMapper.selectById(1L);
        user.setName("zhang_san1");
        user.setAge(39);
        user.setEmail("11111@qq.com");
        //线程2,模拟另一个线程执行了插队操作
        User user1 = userMapper.selectById(1L);
        user1.setName("zhang_san1111");
        user1.setAge(39);
        user1.setEmail("22222@qq.com");
        int i = userMapper.updateById(user1);
        //可以使用自旋锁提交
        int result = userMapper.updateById(user);//如果没有乐观锁，就会覆盖插队线程的值
        System.out.println(result);
    }

    @Test
    public void testSelectbyId(){

        User result = userMapper.selectById(1L);

        System.out.println(result);
    }
    //测试批量查询
    @Test
    public void testSelectbyIDBeach(){

        List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2,3));

        users.forEach(System.out::println);
    }

    //测试批量查询 map
    @Test
    public void testSelectbyBeachMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "张胜男");
        map.put("age", 919);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }
    //分页测试
    @Test
    public void testPage(){
        Page<User> page = new Page<>(2,5);
        IPage<User> userIPage = userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        userIPage.getRecords().forEach(System.err::println);
    }
    @Test
    public void testDeletebyId(){
        int i = userMapper.deleteById(1L);
    }
    @Test
    public void testDeletebyIdsBatch(){
        int i = userMapper.deleteBatchIds(Arrays.asList(1498199053136068612L,1498199053136068611L));
    }
    @Test
    public void deleteByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("id", 1498199053136068610L);
        map.put("age", 18);
        int i = userMapper.deleteByMap(map);
    }

}
