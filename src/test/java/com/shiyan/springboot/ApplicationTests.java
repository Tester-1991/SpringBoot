package com.shiyan.springboot;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.shiyan.springboot.bean.User;
import com.shiyan.springboot.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

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

    @Test
    void testPage() {
        IPage<User> userPage = new Page<>(2, 3);
        userPage = userMapper.selectPage(userPage, null);
        List<User> records = userPage.getRecords();
        for (User user : records) {
            log.info("用户信息{}", user);
        }
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setName("Jame");
        user.setAge(30);
        user.setEmail("1002450926@qq.com");
        userMapper.insert(user);
    }

    @Test
    void testDeleteUser() {
        int result = userMapper.deleteById(1397106226088763393l);
        log.info("结果:{}", result);
    }
}
