package com.itheima.Utils;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected SqlSession sqlSession = null;

    @Before
    public void before(){
         sqlSession = MybatisUtils.openSqlSession();
    }

    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }
}
