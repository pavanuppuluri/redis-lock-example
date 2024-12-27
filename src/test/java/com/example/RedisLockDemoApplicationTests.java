package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RedisLockDemoApplicationTests {

    @Autowired
    private RedisLockService redisLockService;

    @Test
    public void testExecuteWithLock() {
        redisLockService.executeWithLock();
    }
}
