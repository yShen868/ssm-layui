package com.yShen.study.model;

public class SidebarSub {

    int sub_id;
    String sub_name;
    String uri;
    int pid;


    public int getSub_id() {
        return sub_id;
    }

    public void setSub_id(int sub_id) {
        this.sub_id = sub_id;
    }

    public String getSub_name() {
        return sub_name;
    }

    public void setSub_name(String sub_name) {
        this.sub_name = sub_name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "SidebarSub{" +
                "sub_id=" + sub_id +
                ", sub_name='" + sub_name + '\'' +
                ", uri='" + uri + '\'' +
                ", pid=" + pid +
                '}';
    }
}
