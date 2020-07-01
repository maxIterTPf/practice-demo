package com.tian.project.service;

import com.tian.project.bean.LoginInfo;
import com.tian.project.entity.UserInfos;

public interface LoginService {

    public UserInfos login(LoginInfo param);

}
