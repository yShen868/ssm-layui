package com.yShen.study.controller;


import com.yShen.study.model.Role;
import com.yShen.study.service.IRoleService;
import com.yShen.study.service.IUserService;
import com.yShen.study.util.Datajson;
import com.yShen.study.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/role")
public class RoleController {
    private IRoleService roleService;

    public IRoleService getRoleService() {
        return roleService;
    }

    @Autowired
    public void setRoleService(IRoleService roleService) {
        this.roleService = roleService;
    }

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public Datajson selectAll(Page page) {
        Map<String, Object> map = new HashMap<>();
        map.put("limit", page.getLimit());
        map.put("page", (page.getPage() - 1) * page.getLimit());

        List<Role> roles = roleService.selectAll(map);
        int count = roleService.count(map);
        Datajson datajson = new Datajson();
        datajson.setCode(0);
        datajson.setMsg("不存在的");
        datajson.setCount((long) count);
        datajson.setData(roles);
        return datajson;
    }

    @RequestMapping(value = "/find", method = RequestMethod.POST)
    @ResponseBody
    public List<Integer> find(Role role) {
//        System.out.println(role);
        List<Integer> list = roleService.find(role.getR_id());
        System.out.println(list);
        return list;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Datajson update(Role role, @RequestParam("ids[]") int[] ids) {
        System.out.println(role);
        System.out.println(Arrays.toString(ids));
        //更新
        roleService.update(role);
        //删除
        roleService.deleterolesup(role.getR_id());
        //插入
        for (int id : ids) {
            roleService.insertrolesup(role.getR_id(), id);
            System.out.println("正在遍历");
        }
        System.out.println("完成");
        return new Datajson("更新完成");
    }



    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Datajson delete(int r_id) {
        System.out.println(r_id);
        //删除
        int count = userService.selectbyuid(r_id);
        if (count == 0) {
            System.out.println("可以删");
            roleService.delete(r_id);
            roleService.deleterolesup(r_id);
            return new Datajson(0,"已经删除");
        }else {
            return new Datajson(1,"不能删除");

        }
    }


        @RequestMapping(value = "insert", method = RequestMethod.POST)
        @ResponseBody
        public Datajson insert (Role role,@RequestParam("ids[]") int[] ids){


            Integer idss = roleService.selectId(role);
            System.out.println(idss);
            if (idss == null) {
                System.out.println("不存在");
                if (ids[0] == 0) {
                    System.out.println("插进来一个没有任何权限的人");
                    roleService.insert(role);
                } else {
                    roleService.insert(role);
                    Integer integer = roleService.selectId(role);
                    System.out.println(integer);
                    for (int id : ids) {
                        roleService.insertrolesup(integer, id);
                        System.out.println("正在遍历");
                    }
                    System.out.println("完成");
                }
                return new Datajson();
            } else {
                System.out.println("存在");
                return new Datajson("已经存在不能重复添加");
            }


        }


    }
