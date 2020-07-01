package com.tian.project.controller;

import com.tian.project.bean.LoginInfo;
import com.tian.project.bean.LoginReq;
import com.tian.project.bean.UserReq;
import com.tian.project.entity.*;
import com.tian.project.service.LoginService;
import com.tian.project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/option")
public class UserController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody @Valid LoginReq param) {
        System.out.println("接收到请求");

        String result = "";
        LoginInfo loginUser = new LoginInfo(param.getAccount(), param.getPassword());
        UserInfos user = loginService.login(loginUser);

        System.out.println(user.getRegisterTime());

        // 判断是否存在
        if (null == user) {
            result = "登陆失败,没有该用户!";
        } else
            // 密码判断
            if (!(param.getPassword().equals(user.getSex()))) {
                result = "密码不正确!";
            } else {
                result = "登录成功";
            }

        return result;
    }

    @RequestMapping("/register")
    public String register(@RequestBody @Valid UserReq req) {
        String result = "";
        System.out.println(req);

        Test test = new Test();
        test.setName(req.getName());
        test.setAge(req.getSex());
        test.setSex(req.getSex());
        test.setAccount(req.getAccount());
        test.setPassword(req.getPassword());
        userService.save(test);


//        UserBean userBean = new UserBean();
//        userBean.setAccount(req.getAccount());
//        userBean.setPassword(req.getPassword());
//        UserBean bean = userService.save(userBean);
//        System.out.println("保存成功" + bean);

//        UserInfos userInfos = new UserInfos();
//        userInfos.setUserId(req.getAccount());
//        userInfos.setName(req.getName());
//        userInfos.setSex(req.getSex());
//        userInfos.setGrade(req.getGrade());
//
//        userInfos.setTelephoneNum(1234);
//        userInfos.setBirthday(null);
//        userInfos.setRegisterTime(null);
//        userService.save(userInfos);

//        UserAddr userAddr = new UserAddr();
//        userAddr.setAddrId(req.getAccount());
//        userService.save(userAddr);

//        UserRole userRole = new UserRole();
//        userRole.setRole(req.getAccount());
//        userService.save(userRole);

//        if (null != registerRes) {
        result = "注册成功!";
//        } else {
//            result = "注册失败";
//        }

        return result;
    }


}
