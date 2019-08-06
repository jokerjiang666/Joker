package com.itheima.Dao;

import com.itheima.Utils.BaseTest;
import com.itheima.Utils.MybatisUtils;
import com.itheima.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestUserDao extends BaseTest{
    //SqlSession sqlSession = MybatisUtils.openSqlSession();
    //添加
    @Test
    public void testInsert(){
        User user = new User();
        user.setUid(2);
        user.setName("杜甫");
        user.setPassword("456");
        user.setEmail("789@qq.com");
        user.setBirthday(new Date());

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.save(user);
    }
    //修改
    @Test
    public void Testupdate() {
        User user = new User();
        user.setUid(1);
        user.setName("杜甫");

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.update(user);

    }
    //删除
    @Test
    public void Testdelete() {
        User user = new User();
        user.setUid(3);

        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.delete(user);

    }
    //查询
    @Test
    public void Testselect() {
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> list = mapper.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //AS查询
    @Test
    public void Testselectmap(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> list = mapper.findAllMap();
        for (User user : list) {
            System.out.println(user);
        }
    }
    //多条件查询
    @Test
    public void TestselectTiao(){
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> tiaoJian = mapper.findAllTiaoJian("杜甫", "456@qq.com");
        for (User user : tiaoJian) {
            System.out.println(user);
        }
    }
    //多条件查询 对象方式
    @Test
    public void TestselectTiaoDui(){
        User user1 = new User();
        user1.setName("杜甫");
        user1.setEmail("456@qq.com");
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> tiaoJian = mapper.findAllTiaoJianDui(user1);
        for (User user : tiaoJian) {
            System.out.println(user);
        }
    }
    //模糊查询
    @Test
    public void TestselectLike(){
        User user = new User();
        user.setName("杜");
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> tiaoJian = mapper.findAllLike(user);
        for (User user1 : tiaoJian) {
            System.out.println(user1);
        }
    }
    //模糊查询 参数方式
    @Test
    public void TestselectLikeCan(){
        User user = new User();
        user.setName("%杜%");
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        List<User> tiaoJian = mapper.findAllLikeCan(user);
        for (User user1 : tiaoJian) {
            System.out.println(user1);
        }
    }
}
