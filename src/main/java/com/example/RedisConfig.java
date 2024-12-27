package com.example;

import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisConfig {

    @Bean
    public RedissonClient redissonClient() {
        // Create Redisson configuration
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://localhost:6379"); // Change to your Redis server if needed
        return org.redisson.Redisson.create(config);
    }
}
