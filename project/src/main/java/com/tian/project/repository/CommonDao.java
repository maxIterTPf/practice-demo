package com.tian.project.repository;

import com.tian.project.entity.UserBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 继承 JpaRepository 类会自动实现很多内置的方法，包括增删改查。
 * 也可以根据方法名来自动生成相关 Sql
 * @param <T>
 */
@Repository
public interface CommonDao<T extends UserBean> extends JpaRepository<T, Long> {

}
