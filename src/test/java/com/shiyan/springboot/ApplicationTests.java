package com.shiyan.springboot;

import com.shiyan.springboot.bean.User;
import com.shiyan.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Slf4j
@SpringBootTest
class ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {

        long count = jdbcTemplate.queryForObject("select count(*) from user", Long.class);

        log.info("记录总数:{}", count);

        log.info(dataSource.getClass().getName());
    }

    @Test
    void testUserMapper() {
        User user = userMapper.selectById(1l);
        log.info("用户信息:{}", user);
    }

}
