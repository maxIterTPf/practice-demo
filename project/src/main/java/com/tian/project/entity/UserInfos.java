package com.tian.project.entity;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "user_infos")
// 在Hibernate中就有明确的要求：每一个持久化类都必须带一个不带参数的构造方法。
public class UserInfos {
    @Id
    @NotNull
    private String userId;
    private String name;
    private int telephoneNum;
    private String sex;
    private Long grade;
    private Date birthday;
    private Date registerTime;
}
