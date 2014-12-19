package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created by daihui on 2014-12-18.
 */
@Controller
public class MethodTestController {

    @Resource
    private BaseDAO<UserEntity> userEntityDAO;

    //@RequestHeader绑定http request头参数到变量中
    //@RequestHeader(value = "User-Agent",required = false)返回浏览器类型
    @RequestMapping(value = "/reqHed")
    @ResponseBody
    public String testRequestHeader(@RequestHeader(value = "User-Agent", required = false) String userAgent) {
        return userAgent;
    }

    //不是绑定请求参数的方法参数(主要用于给view层传递数据)
    // java.util.Map / org.springframework.ui.Model / org.springframework.ui.ModelMap for enriching the implicit model that is exposed to the web view.
    //前台数据加断电可在request-request-request-attributes看到,也可用request.getAttribute("map").toString();拿
    @RequestMapping(value = "/method1")
    public String test1(Map map, Model model, ModelMap modelMap) {
        map.put("map", "map data...");
        model.addAttribute("model", "model data....");
        modelMap.addAttribute("modelMap", "modelMap data.....");
        return "disp";
    }

    //RedirectAttributes，用于在重定向到目标url时附带一些数据，如提示信息等
    @RequestMapping(value = "/method2")
    public String test2(Model model){
        List<UserEntity> users=userEntityDAO.listAll(UserEntity.class);
        model.addAttribute("users",users);
        model.addAttribute("user",new UserEntity());
        return "input";
    }

    @RequestMapping(value = "/method3")
    public String test3(RedirectAttributes redirectAttributes){
        redirectAttributes.addFlashAttribute("some_msg","由RedirectAttributes带过来的一些信息");
        return "redirect:/method2";
    }
}
