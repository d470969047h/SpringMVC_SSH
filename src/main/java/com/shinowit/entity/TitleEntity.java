package com.shinowit.entity;

import javax.persistence.*;

/**
 * Created by daihui on 2014-12-16.
 */
@Entity
@Table(name = "title")
public class TitleEntity {
    private int titleId;
    private String title;

    @Id
    @Column(name = "title_id")
    public int getTitleId() {
        return titleId;
    }

    public void setTitleId(int titleId) {
        this.titleId = titleId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
