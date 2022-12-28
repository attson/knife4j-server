package com.attson.knife4jserver.controller;

import com.attson.knife4jserver.entity.User;
import com.attson.knife4jserver.response.Response;
import com.attson.knife4jserver.response.UserResponse;
import com.attson.knife4jserver.service.FeishuService;
import com.attson.knife4jserver.service.LoginUserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    FeishuService feishuService;

    @Autowired
    LoginUserService loginUserService;

    @GetMapping("/feishu")
    public Response<UserResponse> FeiShuLogin(@RequestParam("code") String code, HttpServletResponse response) throws Exception {
        User user = feishuService.getUserInfoByCode(code);

        loginUserService.login(user, response);

        return Response.ok(UserResponse.of(user));
    }
}
