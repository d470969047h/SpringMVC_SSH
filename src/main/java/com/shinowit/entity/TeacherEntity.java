package com.shinowit.entity;

import javax.persistence.*;

/**
 * Created by daihui on 2014-12-17.
 */
@Entity
@Table(name = "teacher")
public class TeacherEntity {
    private int id;
    private String teaName;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "teaName")
    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }
}
