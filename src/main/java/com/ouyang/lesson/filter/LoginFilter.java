package com.ouyang.lesson.filter;

import com.ouyang.lesson.utils.AESUtils;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator
 */
@WebFilter(filterName = "login", urlPatterns = "/login/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {

        System.out.println("----------------------->过滤器被创建");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Cookie[] cookies = req.getCookies();
        String account = null;
        String password = null;
        //判断有没有cookie
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("account".equals(cookie.getName())) {
                    account = cookie.getValue();
                }
                if ("password".equals(cookie.getName())) {
                    password = cookie.getValue();

                }
            }
        }
        //如果账号密码不为空，验证密码
        if (account != null && password != null && password.equals(AESUtils.encrypt("password"))) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            throw new RuntimeException("密码错误");
        }

    }

    @Override
    public void destroy() {
    }
}