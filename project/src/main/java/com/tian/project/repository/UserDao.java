package com.tian.project.repository;

import com.tian.project.entity.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CommonDao {

    @Query("select s from UserInfos s where s.userId = ?1")
    UserInfos findByAccount(String account);

    @Query("SELECT telephoneNum FROM UserInfos WHERE name = ?1")
    String findAccountByName(String name);

//    UserBean save(UserBean user);


//    void save(UserInfos userInfos);

//    void save(UserRole userRole);
//
//    void save(UserAddr userAddr);

    void save (Test test);

}
