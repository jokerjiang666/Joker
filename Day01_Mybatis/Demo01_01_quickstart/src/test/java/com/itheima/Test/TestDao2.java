package com.itheima.Test;

import com.itheima.Dao.UserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class TestDao2 {
    @Test
    public void TestDaoimpl() throws IOException {
        User user = new User();
        user.setName("李白");
        user.setPassword("666");
        user.setEmail("456@qq.com");
        user.setBirthday(new Date());

        //读取配置文件
        InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        //获取sqlsession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取映射对象
        UserDao mapper = sqlSession.getMapper(UserDao.class);
        mapper.save(user);
        //提交
        sqlSession.commit();
        //关闭
        sqlSession.close();
    }
}
