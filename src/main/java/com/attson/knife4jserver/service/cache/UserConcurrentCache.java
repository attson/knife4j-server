package com.attson.knife4jserver.service.cache;

import com.attson.knife4jserver.entity.User;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.core.serializer.support.SerializationDelegate;

import java.util.concurrent.ConcurrentMap;

public class UserConcurrentCache extends ConcurrentMapCache {
    public UserConcurrentCache(String name, ConcurrentMap<Object, Object> store, boolean allowNullValues, SerializationDelegate serialization) {
        super(name, store, allowNullValues, serialization);
    }

    @Override
    protected Object lookup(Object key) {
        Object lookup = super.lookup(key);
        if (lookup instanceof User && ((User) lookup).isExpiration()) {
            super.evict(key);
            return null;
        }
        return lookup;
    }
}
