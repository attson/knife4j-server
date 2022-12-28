package com.attson.knife4jserver.service;

import com.attson.knife4jserver.entity.User;
import com.attson.knife4jserver.exception.ServiceException;
import com.attson.knife4jserver.service.cache.ConcurrentCacheManager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.util.Strings;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class LoginUserService {

    public static String AUTH_ID_HEADER = "X-Auth-Id";

    Cache cache = (new ConcurrentCacheManager()).getCache("user");

    public void login(User user, HttpServletResponse response) {
        user.setExpirationTime(new Date(System.currentTimeMillis() + 12 * 3600 * 1000));

        UUID uuid = UUID.randomUUID();

        String uuidAsString = uuid.toString();

        cache.put(uuidAsString, user);

        response.addHeader(LoginUserService.AUTH_ID_HEADER, uuidAsString);
    }

    public User getUser(HttpServletRequest request) {
        String authId = request.getHeader(LoginUserService.AUTH_ID_HEADER);
        if (Strings.isBlank(authId)) {
            throw new ServiceException("401", "miss login token");
        }

        Cache.ValueWrapper valueWrapper = cache.get(authId);
        if (valueWrapper == null) {
            return null;
        }

        return (User) valueWrapper.get();
    }
}
