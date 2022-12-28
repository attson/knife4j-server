package com.attson.knife4jserver.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {
    public String id;

    public String username;

    private Date expirationTime;

    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Date getExpirationTime() {
        return expirationTime;
    }

    public boolean isExpiration() {
        if (expirationTime != null) {
            return expirationTime.before(new Date());
        } else {
            return true;
        }
    }
}
