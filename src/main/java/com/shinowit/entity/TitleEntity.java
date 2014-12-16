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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TitleEntity that = (TitleEntity) o;

        if (titleId != that.titleId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = titleId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
