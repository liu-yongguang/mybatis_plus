package com.kuang.study.service.impl;

import com.kuang.study.pojo.User;
import com.kuang.study.mapper.UserMapper;
import com.kuang.study.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author w刘永光sk
 * @since 2022-03-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
