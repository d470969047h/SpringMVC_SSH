package com.shinowit.web;

import com.shinowit.entity.TeacherEntity;
import com.shinowit.entity.UserAndTeacherEntity;
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
    private BaseDAO<UserEntity> userDAO;
    @Resource
    private BaseDAO<TeacherEntity> teacherDAO;

    @RequestMapping("/test4")
    public ModelAndView testPojo(UserAndTeacherEntity userAndTeacherEntity){
        ModelAndView result=new ModelAndView();
        try {
            UserEntity user=userAndTeacherEntity.getUserInfo();
            TeacherEntity tea=userAndTeacherEntity.getTeacher();
            userDAO.insert(user);
            teacherDAO.insert(tea);
            result.setViewName("redirect:/userinfo/disp");
        }catch (Exception e){
            e.printStackTrace();
            result.setViewName("/userinfo/fail");
        }
        return result;
    }

    @RequestMapping("/disp")
    public ModelAndView displayAll(){
        List<UserEntity> utList1=userDAO.listAll(UserEntity.class);
        List<TeacherEntity> utList2=teacherDAO.listAll(TeacherEntity.class);
        ModelAndView result=new ModelAndView("/userinfo/disp");
        result.addObject("uesrTea_data_List1",utList1);
        result.addObject("uesrTea_data_List2",utList2);
        return result;
    }
}

