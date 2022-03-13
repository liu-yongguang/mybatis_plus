package com.kuang;/**
 * @author:Mr.Liu
 * @Date: 2022/3/1 12:41
 * @version: 1.0
 * @Description:
 */

import com.kuang.study.mapper.UserMapper;
import com.kuang.study.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/3/1 12:41
 *@version: 1.0
 *
 */
@SpringBootTest
public class Testxml {
    @Autowired
    UserMapper userMapper;
    @Test
    public void getUserById(){

        User user = userMapper.getUserById(2L);
        System.out.println(user);    }
}
