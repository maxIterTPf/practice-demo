package com.tian.project.bean;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class LoginReq implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("用户名")
    @NotEmpty(message = "{login.account.empty}")
    private String account;

//    @ApiModelProperty("密码")
    @NotEmpty(message = "{login.password.empty}")
    private String password;
}
