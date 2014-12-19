package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by daihui on 2014-12-18.
 * *@RequestBody注解绑定请求参数内容到方法参数中，请求参数内容可以是json数据、字节数组等
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private BaseDAO<UserEntity> userEntityDAO;

    @RequestMapping("/login")
    public  @ResponseBody UserEntity login(@RequestBody UserEntity userEntity) {
       userEntityDAO.insert(userEntity);
            return userEntity;
    }
}
