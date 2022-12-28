package com.attson.knife4jserver.response;

import com.attson.knife4jserver.entity.User;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class UserResponse {

    public String id;

    public String username;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    public Date expirationTime;

    public static UserResponse of(User user) {
        var res = new UserResponse();

        res.id = user.id;
        res.username = user.username;
        res.expirationTime = user.getExpirationTime();

        return res;
    }
}
