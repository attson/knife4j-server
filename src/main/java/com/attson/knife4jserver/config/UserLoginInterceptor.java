package com.attson.knife4jserver.config;

import com.attson.knife4jserver.entity.User;
import com.attson.knife4jserver.exception.ServiceException;
import com.attson.knife4jserver.service.LoginUserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

public class UserLoginInterceptor implements HandlerInterceptor {
    private final LoginUserService loginUserService;

    public UserLoginInterceptor(LoginUserService loginUserService) {
        this.loginUserService = loginUserService;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (handler instanceof HandlerMethod methodHandler) {
            if (!methodHandler.getMethod().getDeclaringClass().getSimpleName().equals("LoginController")) {
                User user = loginUserService.getUser(request);
                if (user == null) {
                    throw new ServiceException("401", "user login status is expired");
                }
            }
        }

        return true;
    }
}
