package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by daihui on 2014-12-18.
 * *@ModelAttribute作用于一个方法前面时 ，这个方法会被同类内的其他@RequestMapping注解的方法调用时预先调用，
 * 适合用于处理@RequestMapping没办法直接处理请求参数的情况，或者预先做数据的初始化。
 */
@Controller
@RequestMapping(value = "/modelattr")
public class ModelAttributeController {

    //下面这个方法会在所有同类内的其他RequestMapping调用前触发执行。
    @ModelAttribute
    public UserEntity testUser() {
        UserEntity result = new UserEntity();
        result.setUserId(123110);
        result.setUserName("掌声呢?");
        result.setUserPass("在这呢!");
        return result;
    }

    //上面的方法调用后向Model中增加了一个叫做userInfo的属性，规则是首字母转小写作为key名称。
    @RequestMapping("/testattr1")
    @ResponseBody
    public void testModelAttribute(@ModelAttribute("userEntity") UserEntity user,HttpServletResponse response) {
         PrintWriter out;
        try {
            out=response.getWriter();
            out.println("执行了 @RequestMapping(\"/testattr1\")的方法，出发了@ModelAttribute的方法。输出：");
            out.println(String.valueOf(user.getUserName()));
            out.println(String.valueOf(user.getUserPass()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
