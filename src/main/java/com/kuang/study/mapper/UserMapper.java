package com.kuang.study.mapper;

import com.kuang.study.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author w刘永光sk
 * @since 2022-03-01
 */
@Repository
public interface UserMapper extends BaseMapper<User> {
    User getUserById(Long id);
}
