package com.kuang.pojo;/**
 * @author:Mr.Liu
 * @Date: 2022/2/28 14:21
 * @version: 1.0
 * @Description:
 */

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 *@program: mybatis_plus
 *@description:
 *@author:Mr.Liu
 *@CreateDate: 2022/2/28 14:21
 *@version: 1.0
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
   @TableId(type = IdType.AUTO)
   private Long id;
   private  String name;
   private Integer age;
   private String email;
   //逻辑删除注解，
   @TableLogic
   private Integer deleted;
   @TableField(fill = FieldFill.INSERT)//字段插入式时自动填充
   private Date createTime;
   @TableField(fill = FieldFill.INSERT_UPDATE)
   private Date updateTime;
   @Version//乐观锁version注解
   private Integer version;
}
