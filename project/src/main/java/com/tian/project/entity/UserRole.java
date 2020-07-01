package com.tian.project.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_role")
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class UserRole {

    @Id
    @NotNull
    private String roleId;
    private String role;
}
