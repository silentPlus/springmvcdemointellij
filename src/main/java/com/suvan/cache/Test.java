package com.suvan.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

/**
 * Created by suvan on 2017/5/16.
 */
public class Test {

    @Cacheable(value="sum", key="#a", condition = "#b > 0")
    public int getSum1(int a, int b) {
        return a + b;
    }

    @CachePut(value="sum", key="#a", condition = "#b < 5")
    public int getSum2(int a, int b) {
        return a + b;
    }

    @CacheEvict(value = "sum", condition = "#flag")
    public void clearCache(boolean flag){

    }
}
