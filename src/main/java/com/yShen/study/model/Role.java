package com.yShen.study.model;

public class Role {
    private Integer r_id;
    private String r_name;
    private String desc;

    public Integer getR_id() {
        return r_id;
    }

    public void setR_id(Integer r_id) {
        this.r_id = r_id;
    }

    public String getR_name() {
        return r_name;
    }

    public void setR_name(String r_name) {
        this.r_name = r_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Role{" +
                "r_id=" + r_id +
                ", r_name='" + r_name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Role(String r_name, String desc) {
        this.r_name = r_name;
        this.desc = desc;
    }

    public Role() {
    }

    public Role(Integer r_id, String r_name, String desc) {
        this.r_id = r_id;
        this.r_name = r_name;
        this.desc = desc;
    }
}
