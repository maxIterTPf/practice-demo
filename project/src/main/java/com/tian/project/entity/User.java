package com.tian.project.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 标注为@MappedSuperclass的类将不是一个完整的实体类，
 * 他将不会映射到数据库表，但是他的属性都将映射到其子类的数据库字段中。
 *
 * 标注为@MappedSuperclass的类不能再标注@Entity或@Table注解，
 * 也无需实现序列化接口
 */
@Data
@MappedSuperclass
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class User {
    @Id // 表示account是主键
    @GeneratedValue(strategy = GenerationType.IDENTITY) //验证此句可以在MYSQL中实现自动增涨
    private String account;
}

