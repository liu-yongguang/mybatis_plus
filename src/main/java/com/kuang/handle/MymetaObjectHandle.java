package com.kuang.handle;/**
 * @author:Mr.Liu
 * @Date: 2022/2/28 16:09
 * @version: 1.0
 * @Description:
 */

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/2/28 16:09
 *@version: 1.0
 *
 */
@Slf4j
@Component
public class MymetaObjectHandle implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("insertFill()方法。。。。。。");
    this.setFieldValByName("createTime", new Date(),metaObject);
        this.setFieldValByName("updateTime", new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("updateFill()方法、、、、、");
        this.setFieldValByName("updateTime", new Date(),metaObject);

    }
}
