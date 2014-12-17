package com.shinowit.entity;

/**
 * Created by daihui on 2014-12-17.
 */
public class UserAndTeacherEntity {
    private UserEntity userInfo;

    private TeacherEntity teacher;

    public UserEntity getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserEntity userInfo) {
        this.userInfo = userInfo;
    }

    public TeacherEntity getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherEntity teacher) {
        this.teacher = teacher;
    }
}
