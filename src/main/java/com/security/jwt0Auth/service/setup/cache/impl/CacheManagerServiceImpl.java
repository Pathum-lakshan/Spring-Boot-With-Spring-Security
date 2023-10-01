package com.security.jwt0Auth.service.setup.cache.impl;

import com.security.jwt0Auth.service.setup.cache.CacheManagerService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-27 8:35 AM
 */

@Service
@RequiredArgsConstructor
public class CacheManagerServiceImpl implements CacheManagerService {
    private final CacheManager cacheManager;

    @Override
    public void clearCache(String name, String key) {
        Cache userCache = cacheManager.getCache(name);
        if (userCache != null) {
            userCache.evict(key);
        }
    }
}
