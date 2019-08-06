package com.itheima.Dao;

import com.itheima.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDao {
    //增加
    void save(User user);
    //修改
    void update(User user);
    //删除
    void delete(User user);
    //查询
    List<User> findAll();
    //AS查询
    List<User> findAllMap();
    //多条件查询 或者 用对象方式
    List<User> findAllTiaoJian(@Param("name1") String name,@Param("email") String email);
    //多条件查询 对象方式
    List<User> findAllTiaoJianDui(User user);
    //模糊查询 传参数时加%
    List<User> findAllLikeCan(User user);
    //模糊查询 在语句中加% 或在传参数时加%
    List<User> findAllLike(User user);
}
