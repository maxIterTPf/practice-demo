package com.tian.project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class UserBean extends User {

    private String password;

}