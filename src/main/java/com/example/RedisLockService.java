package com.example;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class RedisLockService {

    @Autowired
    private RedissonClient redissonClient;

    private static final String LOCK_KEY = "distributed-lock";

    public void executeWithLock() {
        RLock lock = redissonClient.getLock(LOCK_KEY);

        try {
            // Try to acquire the lock for 10 seconds
            boolean isLockAcquired = lock.tryLock(0, 10, TimeUnit.SECONDS);

            if (isLockAcquired) {
                try {
                    // Critical section: Process the task
                    System.out.println("Lock acquired, processing task...");
                    Thread.sleep(5000); // Simulate some task
                    System.out.println("Task completed!");
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    // Release the lock
                    lock.unlock();
                }
            } else {
                System.out.println("Could not acquire lock, try again later.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
