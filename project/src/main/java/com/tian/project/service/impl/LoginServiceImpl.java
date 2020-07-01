package com.tian.project.service.impl;

import com.tian.project.bean.LoginInfo;
import com.tian.project.entity.UserInfos;
import com.tian.project.repository.UserDao;
import com.tian.project.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserInfos login(LoginInfo param) {
        UserInfos byAccount = userDao.findByAccount(param.getAccount());
        UserInfos infos = byAccount == null ? null : byAccount;
        System.out.println(infos);
        return infos;
    }
}
