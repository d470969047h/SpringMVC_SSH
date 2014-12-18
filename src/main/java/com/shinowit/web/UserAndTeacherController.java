package com.shinowit.web;

import com.shinowit.entity.UserAndTeacherEntity;
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
    private BaseDAO<UserAndTeacherEntity> userAndTeacherDAO;

    @RequestMapping("/test4")
    public ModelAndView testPojo(UserAndTeacherEntity userAndTeacherEntity){
        ModelAndView result=new ModelAndView();
        try {
            userAndTeacherDAO.insert(userAndTeacherEntity);
            result.setViewName("/disp");
        }catch (Exception e){
            e.printStackTrace();
            result.setViewName("redirect:/userinfo/fail");
        }
        return result;
    }

    @RequestMapping("/disp")
    public ModelAndView displayAll(){
        List<UserAndTeacherEntity> utList=userAndTeacherDAO.listAll(UserAndTeacherEntity.class);
        ModelAndView result=new ModelAndView("userinfo/disp");
        result.addObject("uesrTea_data_List",utList);
        return result;
    }
}

