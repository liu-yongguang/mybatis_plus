package com.kuang.mapper;/**
 * @author:Mr.Liu
 * @Date: 2022/2/28 14:29
 * @version: 1.0
 * @Description:
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kuang.pojo.User;
import org.springframework.stereotype.Repository;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/2/28 14:29
 *@version: 1.0
 *
 */
//在对应的mapper上面继承基本的类BaseMapper
@Repository//代表持久层
public interface UserMapper extends BaseMapper<User> {
//所有的CRUD操作都已经编写完成了
    //不用像以前mybatis配置一大堆文件了；
}
