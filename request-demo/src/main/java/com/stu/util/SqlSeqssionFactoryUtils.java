package com.stu.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by e1hax on 2022-08-16.
 */
public class SqlSeqssionFactoryUtils {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        //静态代码块随着类的加载而执行，且只执行一次
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

        public static SqlSessionFactory getSqlSessionFactory(){
            return sqlSessionFactory;
        }
}
