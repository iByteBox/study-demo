package com.lxf.study.mybatis;

import com.lxf.study.mybatis.entity.MybatisUser;
import com.lxf.study.mybatis.mapper.MybatisUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

@Slf4j
public class ClientApp {

    public static void main(String[] args) throws IOException {

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = builder.build(is);
        /*try (SqlSession session = factory.openSession(true)) {
            MybatisUserMapper userMapper = session.getMapper(MybatisUserMapper.class);
            MybatisUser user = new MybatisUser();
            user.setUserName("张三");
            user.setPassword("123456");
            user.setEmail("134@qq.com");
            user.setAge(23);
            user.setGender(1);
            user.setCreateTime(LocalDateTime.now());
            int result = userMapper.insertOne(user);
            log.info("插入结果:{}", result);
        }*/

        long startTime = System.currentTimeMillis();

        try (SqlSession session = factory.openSession(ExecutorType.BATCH, true)) {
            MybatisUserMapper userMapper = session.getMapper(MybatisUserMapper.class);
            for (int i = 0; i < 100000; i++) {
                MybatisUser user = new MybatisUser();
                user.setUserName("张三");
                user.setPassword("123456");
                user.setEmail("134@qq.com");
                user.setAge(23);
                user.setGender(1);
                user.setCreateTime(LocalDateTime.now());
                userMapper.insertOne(user);
                session.commit();
            }
        }

        long endTime = System.currentTimeMillis();
        log.info("共耗时：{}ms", endTime - startTime);

    }

}
