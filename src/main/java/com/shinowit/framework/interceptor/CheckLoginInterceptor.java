package com.shinowit.framework.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by daihui on 2014-12-22.
 */
public class CheckLoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //取session对象
        HttpSession session= request.getSession();
        if(null!=session&&session.getAttribute("login_status")!=null){
                return true;
        }

        //获取请求的uri来判断哪些请求可以放行
        String uri=request.getRequestURI();
        if(uri.endsWith("/login.jsp")||(uri.endsWith("/userinfo/test3"))){
            return true;
        }
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        return  false;
    }
}
