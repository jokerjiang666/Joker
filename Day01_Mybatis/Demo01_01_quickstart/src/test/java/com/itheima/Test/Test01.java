package com.itheima.Test;

import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class Test01 {

    @Test
    public void save() throws IOException {
        User user = new User();
        user.setName("李白");
        user.setPassword("666");
        user.setEmail("456@qq.com");
        user.setBirthday(new Date());

        //使用Mybatis保存数据
        //1 读取配置文件,将文件读成流的形式
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2 创建一个工厂sqlSessionFactory()
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //3 获取sqlSession(这是重要的API  基于这个API做CRUD)
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //4 操作
       sqlSession.insert("UserMapper.save",user);

        //5 提交事务(Mybatis默认是不自动提交事务的)
       sqlSession.commit();

        //6 关闭资源
       sqlSession.close();
    }
}
