package com.shinowit.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by daihui on 2014-12-18.
 */
@Controller
public class MethodTestController {

    //@RequestHeader绑定http request头参数到变量中
    //@RequestHeader(value = "User-Agent",required = false)返回浏览器类型
    @RequestMapping(value = "/reqHed")
    @ResponseBody
    public String testRequestHeader(@RequestHeader(value = "User-Agent",required = false) String userAgent){
        return userAgent;
    }

}
