package com.security.jwt0Auth.service.setup.cache;

/**
 * @Author : Pathum Lakshan
 * @Project : Spring-Boot-With-Spring-Security
 * @Date : 2023-09-27 8:34 AM
 */

public interface CacheManagerService {
    void clearCache(String name, String key);
}
