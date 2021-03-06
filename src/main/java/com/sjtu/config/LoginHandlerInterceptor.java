package com.sjtu.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //登陆成功后，应有用户的session
        Object loginUser = request.getSession().getAttribute("loginMember");
        if (loginUser == null) {
            request.setAttribute("loginMsg", "没有权限，请先登录");
            request.getRequestDispatcher("/index").forward(request, response);
            return false;
        }
        return true;
    }
}
