package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping("/userinfo")
public class UserInfoController {

    @Resource
    private BaseDAO<UserEntity> stu_dao;

    @RequestMapping("/test")
    public ModelAndView displayAll() {
        List<UserEntity> userList = stu_dao.listAll(UserEntity.class);
        ModelAndView result = new ModelAndView("/userinfo/test");//view，对应userinfo/test.jsp
        result.addObject("user_data_list", userList);//Model
        return result;
    }

    /**
     * ***************************原生servlet访问示例一***********************************
     */
    @Resource
    private ServletContext application;//application特殊，必须注入

    @RequestMapping("/test1")
    public ModelAndView testNativeObject(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView result = new ModelAndView("/userinfo/test1");
        result.addObject("req_uri", request.getRequestURI());
        result.addObject("resp", response.getCharacterEncoding());
        result.addObject("sid", session.getId());
        result.addObject("app_path", application.getRealPath("/"));
        return result;
    }

    /**
     * ******************GET/POST请求方式参数自动绑定到单个变量:GET方式***************************
     * *@RequestParam("loginName")在用get请求时可以改变参数名，哈哈
     * *@RequestParam("loginName")请求的是实体类对象的话必须和对象的属性一样，不能变！
     */
    @RequestMapping("/test2")
    public ModelAndView testParams(@RequestParam("loginName") String username, @RequestParam("loginPass") String userpass) {
        ModelAndView result = new ModelAndView("/userinfo/test2");
        try {
            result.addObject("username", new String(username.getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            result.addObject("userpass", new String(userpass.getBytes("ISO-8859-1"), "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * ******************GET/POST请求方式参数自动绑定到单个变量:POST方式(模拟登陆)***************************
     * *@RequestParam("loginName")在用get请求时可以改变参数名，哈哈
     * *@RequestParam("loginName")请求的是实体类对象的话必须和对象的属性一样，不能变！
     * *@RequestParam注解的参数缺省下http request中必须要提供，否则会出错，可以增加required=false来解决这个问题，例如:
     * *  @RequestParam(value = "name",required = false)
     * *
     */
    @RequestMapping("/test3")
    public String testParams2(@RequestParam("loginName") String userName, @RequestParam("loginPass") String userPass, HttpServletRequest request) {
        ModelAndView result = new ModelAndView("/userinfo/test3");
        result.addObject("userName", userName);
        result.addObject("userPass", userPass);
        List<UserEntity> userList = stu_dao.myFindByHql("from UserEntity where userName=?", userName);
        if (userList.size() > 0) {
            for (UserEntity userinfo : userList) {
                if (userinfo.getUserName().equals(userName) && userinfo.getUserPass().equals(userPass)) {
                    //向session中存入一个状态
                    request.getSession(true).setAttribute("login_status", true);
                    request.setAttribute("err_msg",userinfo.getUserName());
                    return "/userinfo/test3";
                } else {
                    return "/userinfo/fail";
                }
            }
        }
        return "/userinfo/fail";
    }
}
