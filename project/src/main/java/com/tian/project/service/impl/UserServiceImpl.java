package com.tian.project.service.impl;

import com.tian.project.entity.*;
import com.tian.project.repository.UserDao;
import com.tian.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void save(Test test) {
        userDao.save(test);
    }

//    @Override
//    public void save(UserInfos userInfos) {
//        userDao.save(userInfos);
//    }

//    @Override
//    public UserBean save(UserBean user) {
//        System.out.println(user.getAccount());
//        System.out.println(user.getPassword());
//        UserBean bean = userDao.save(user);
//        return bean;
//    }

//    @Override
//    public void save(UserAddr userAddr) {
//        userDao.save(userAddr);
//    }
//
//    @Override
//    public void save(UserRole userRole) {
//        userDao.save(userRole);
//    }

}
