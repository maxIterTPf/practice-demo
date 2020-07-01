package com.tian.project.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class Test {
    @Id
    private String name;
    private String age;
    private String sex;
    private String account;
    private String password;
}
