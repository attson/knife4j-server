package com.attson.knife4jserver.service;

import com.alibaba.fastjson.JSONObject;
import com.attson.knife4jserver.config.ServerConfig;
import com.attson.knife4jserver.entity.User;
import okhttp3.*;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FeishuService {

    @Autowired(required = false)
    ServerConfig serverConfig;

    public User getUserInfoByCode(String code) throws IOException {
        if (serverConfig.getLogin() == null || serverConfig.getLogin().getFeishu() == null) {
            throw new RuntimeException("miss feishu config");
        }

        String userAccessToken = getUserAccessToken(code);

        return getUserInfo(userAccessToken);
    }

    public User getUserInfo(String userAccessToken) throws IOException {
        if (serverConfig.getLogin() == null || serverConfig.getLogin().getFeishu() == null) {
            throw new RuntimeException("miss feishu config");
        }

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url("https://passport.feishu.cn/suite/passport/oauth/userinfo")
                .method("GET", null)
                .addHeader("Authorization", "Bearer " + userAccessToken)
                .build();
        Response response = client.newCall(request).execute();

        assert response.body() != null;

        JSONObject res = (JSONObject) JSONObject.parse(response.body().string());
        if (!Strings.isBlank(res.getString("error_description"))) {
            throw new RuntimeException(res.getString("error_description"));
        }

        User user = new User();
        user.id = res.getString("open_id");
        user.username = res.getString("name");

        return user;
    }

    public String getUserAccessToken(String code) throws IOException {

        String format = String.format("grant_type=authorization_code&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s",
                serverConfig.getLogin().getFeishu().getAppId(),
                serverConfig.getLogin().getFeishu().getAppSecret(),
                code,
                serverConfig.getLogin().getFeishu().getRedirectUri()
        );

        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, format);
        Request request = new Request.Builder()
                .url("https://passport.feishu.cn/suite/passport/oauth/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();

        assert response.body() != null;

        JSONObject res = (JSONObject) JSONObject.parse(response.body().string());
        if (!Strings.isBlank(res.getString("error_description"))) {
            throw new RuntimeException(res.getString("error_description"));
        }
        String accessToken = res.getString("access_token");
        if (Strings.isBlank(accessToken)) {
            throw new RuntimeException("accessToken get fail");
        }

        return accessToken;
    }
}
