package com.yShen.study.model;

import java.util.List;

public class SidebarSup {
    int id;
    String name;
    List<SidebarSub> list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SidebarSub> getList() {
        return list;
    }

    public void setList(List<SidebarSub> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "SidebarSup{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                '}';
    }
}
