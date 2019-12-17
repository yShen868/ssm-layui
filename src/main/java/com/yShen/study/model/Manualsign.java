package com.yShen.study.model;

import java.util.Date;

public class Manualsign {
    private Integer m_id;
    private Date come_time;
    private Integer user_id;
    private String m_desc;

    public Integer getM_id() {
        return m_id;
    }

    public void setM_id(Integer m_id) {
        this.m_id = m_id;
    }

    public Date getCome_time() {
        return come_time;
    }

    public void setCome_time(Date come_time) {
        this.come_time = come_time;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getM_desc() {
        return m_desc;
    }

    public void setM_desc(String m_desc) {
        this.m_desc = m_desc;
    }

    @Override
    public String toString() {
        return "Manualsign{" +
                "m_id=" + m_id +
                ", come_time=" + come_time +
                ", user_id=" + user_id +
                ", m_desc='" + m_desc + '\'' +
                '}';
    }

    public Manualsign(Date come_time, Integer user_id, String m_desc) {
        this.come_time = come_time;
        this.user_id = user_id;
        this.m_desc = m_desc;
    }

    public Manualsign() {
    }
}
