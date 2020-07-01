package com.tian.project.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class UserReq implements Serializable {

    public static final Long serialVersionUID = 1L;

    // 姓名
    @NotEmpty(message = "{register.name.empty}")
    private String name;

    //    @ApiModelProperty("用户名")
    @NotEmpty(message = "{register.account.empty}")
    private String account;

    //    @ApiModelProperty("密码")
    @NotEmpty(message = "{register.password.empty}")
    private String password;

    // 性别
    private String sex;

    // 等级
    private Long grade;
}
