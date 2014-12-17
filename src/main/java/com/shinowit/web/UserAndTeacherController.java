package com.shinowit.web;

import com.shinowit.entity.UserEntity;
import com.shinowit.framework.dao.BaseDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/userinfo")
public class UserAndTeacherController {

    @Resource
    private BaseDAO<UserEntity> stu_dao;

    @RequestMapping("/test4")
    public ModelAndView displayAll() {
        List<UserEntity> userList = stu_dao.listAll(UserEntity.class);
        ModelAndView result = new ModelAndView("/userinfo/test4");//view，对应userinfo/test.jsp
        result.addObject("user_data_list", userList);//Model
        return result;
    }


}

