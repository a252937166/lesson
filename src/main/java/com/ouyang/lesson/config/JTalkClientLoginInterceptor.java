package com.ouyang.lesson.config;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JTalkClientLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        try {
            response.sendRedirect("/log/hindex.htm?id=1");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}