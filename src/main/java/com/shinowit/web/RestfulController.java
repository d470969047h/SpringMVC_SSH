package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by daihui on 2014-12-18.
 * *@PathVariable用于绑定请求参数路径中的值到方法参数中，适合用于restful风格的编程开发
 * *执行此方法只要在路径里写http://localhost:8080/restful/user/del/79就可以删除id为79的用户操作
 */
@Controller
@RequestMapping("/restful")
public class RestfulController {

    @Resource
    private BaseDAO<UserEntity> userEntityDAO;

    @RequestMapping("/user/del/{userId}")
    @ResponseBody   //写了次注解可以直接返字符串/json，不用跳转
    public String deleteUser(@PathVariable("userId") Integer user_Id) {
        UserEntity user = new UserEntity();
        user.setUserId(user_Id);
        try {
//            request.setCharacterEncoding("utf-8");//,HttpServletResponse response,HttpServletRequest request   new String(result.getBytes("ISO-8859-1"), "utf-8");
//            response.setContentType("text/html;chartset=utf-8");//设置浏览器编码字符集
//            response.setCharacterEncoding("utf-8");
            boolean isSuccess = userEntityDAO.delete(user);
            if (true == isSuccess) {
                return "success!";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "fail!";
    }
}
