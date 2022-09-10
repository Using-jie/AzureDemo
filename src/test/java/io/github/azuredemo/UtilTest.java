package io.github.azuredemo;

import io.github.azuredemo.util.RedisCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Luke
 * @Description
 * @Date 2022/9/6 22:56
 */
@SpringBootTest
public class UtilTest {
    @Autowired
    private RedisCache redisCache;

    @Test
    public void getValue() {
        Map<String, Object> code = redisCache.getCacheMap("code");
        System.out.println(code.get("code"));
        System.out.println(code.get("state"));
    }
}