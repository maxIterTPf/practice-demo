package com.tian.project.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_addr")
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class UserAddr {

    @Id
    @NotNull
    private String addrId;
    private String province;
    private String city;
    private String area;
    private String mail;
    private String address;
}
