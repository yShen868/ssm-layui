package com.yShen.study.model;

public class User {
    private Integer u_id;
    private String u_name;
    private String password;
    private Integer sex;
    private Integer status;
    private Integer dept_id;
    private Integer role_id;

    public Integer getU_id() {
        return u_id;
    }

    public void setU_id(Integer u_id) {
        this.u_id = u_id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDept_id() {
        return dept_id;
    }

    public void setDept_id(Integer dept_id) {
        this.dept_id = dept_id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }


    public User(Integer u_id, String u_name, String password, Integer sex, Integer status, Integer dept_id, Integer role_id) {
        this.u_id = u_id;
        this.u_name = u_name;
        this.password = password;
        this.sex = sex;
        this.status = status;
        this.dept_id = dept_id;
        this.role_id = role_id;
    }


    public User() {
    }

    public User(String u_name, String password, Integer sex, Integer status, Integer dept_id, Integer role_id) {
        this.u_name = u_name;
        this.password = password;
        this.sex = sex;
        this.status = status;
        this.dept_id = dept_id;
        this.role_id = role_id;
    }

    public User(String u_name, String password) {
        this.u_name = u_name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", status=" + status +
                ", dept_id=" + dept_id +
                ", role_id=" + role_id +
                '}';
    }
}
