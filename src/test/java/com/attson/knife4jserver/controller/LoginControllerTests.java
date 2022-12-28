package com.attson.knife4jserver.controller;


import com.attson.knife4jserver.config.ServerConfig;
import okhttp3.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class LoginControllerTests {

    @Autowired(required = false)
    ServerConfig serverConfig;

    @Test
    public void testFeishu() throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=authorization_code&client_id=cli_a31590761d38d00b&client_secret=3YeiA64i8w09pgw34NR6kbmiIyWhrKKG&code=04bta1eb3b434e0ca10d84815218c905&redirect_uri=http://127.0.0.1:5173/doc.html#/login");
        Request request = new Request.Builder()
                .url("https://passport.feishu.cn/suite/passport/oauth/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = client.newCall(request).execute();

        assert response.body() != null;

        System.out.println(response.body().string());
    }
}
