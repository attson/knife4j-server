package com.attson.knife4jserver.service.cache;

import jakarta.annotation.PostConstruct;
import org.jetbrains.annotations.NotNull;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.core.serializer.support.SerializationDelegate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

@Component
@EnableCaching
public class ConcurrentCacheManager extends ConcurrentMapCacheManager {
    @Nullable
    private SerializationDelegate serialization;

    @PostConstruct
    public void initSerialization() {
        Field serialization = ReflectionUtils.findField(ConcurrentMapCacheManager.class, "serialization");
        ReflectionUtils.makeAccessible(serialization);
        this.serialization = (SerializationDelegate) ReflectionUtils.getField(serialization, this);
    }

    @NotNull
    @Override
    protected Cache createConcurrentMapCache(@NotNull String name) {
        SerializationDelegate actualSerialization = this.isStoreByValue() ? this.serialization : null;
        return new UserConcurrentCache(name, new ConcurrentHashMap<>(256), this.isAllowNullValues(), actualSerialization);
    }
}
