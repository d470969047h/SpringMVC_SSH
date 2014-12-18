package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daihui on 2014-12-18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @RequestMapping("/login")
    public  @ResponseBody UserEntity login(@RequestBody UserEntity userEntity) {
        return userEntity;
    }
}
