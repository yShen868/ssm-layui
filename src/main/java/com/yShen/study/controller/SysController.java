package com.yShen.study.controller;



import com.yShen.study.model.SidebarSup;
import com.yShen.study.model.User;
import com.yShen.study.service.ISidebarSupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/list")
public class SysController {

    private ISidebarSupService sidebarSupService;

    public ISidebarSupService getSidebarSupService() {
        return sidebarSupService;
    }
    @Autowired
    public void setSidebarSupService(ISidebarSupService sidebarSupService) {
        this.sidebarSupService = sidebarSupService;
    }

    @RequestMapping("/list")
    public String lists(Model model, HttpSession session){

        User user = (User) session.getAttribute("user");
        List<SidebarSup> list = sidebarSupService.listAllbyid(user);
        model.addAttribute("list",list);
        return "index";
    }


    @RequestMapping("/select")
    @ResponseBody
    public List<SidebarSup> select(){
        List<SidebarSup> select = sidebarSupService.select();
        return select;
    }



    @RequestMapping("/kao")
    public String kao(HttpSession session){
        return "qiandao";
    }
    @RequestMapping("/kaoqin")
    public String kkaoqinao(HttpSession session){
        return "qiandaolist";
    }


    @RequestMapping("/role")
    public String role(HttpSession session){
        return "role";
    }



}
