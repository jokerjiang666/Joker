package com.itheima.Utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    protected static SqlSessionFactory sqlSessionFactory = null;
    static{
        try {
            InputStream input = Resources.getResourceAsStream("SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSession openSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
