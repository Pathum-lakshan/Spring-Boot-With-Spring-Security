package com.security.jwt0Auth.config.cache;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.security.jwt0Auth.util.contant.Constant;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-27 8:40 AM
 */

@Configuration
public class CachingConfiguration {
    @Bean
    public CacheManager cacheManager() {
        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        // Configure the cache names and their respective properties
        cacheManager.setCacheNames(List.of(Constant.CacheName.CACHE_FIND_USER_DATA, Constant.CacheName.CACHE_NAME_2));

        // Configure cache properties for CACHE_NAME_1
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(10, TimeUnit.MINUTES)  // Cache entries expire after 10 minutes
                .maximumSize(100)  // Maximum of 100 entries in the cache
                .recordStats());  // Enable cache statistics

        // Configure cache properties for CACHE_NAME_2
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .expireAfterWrite(5, TimeUnit.MINUTES)  // Cache entries expire after 5 minutes
                .maximumSize(50)  // Maximum of 50 entries in the cache
                .recordStats());  // Enable cache statistics

        return cacheManager;
    }
}
