package com.yShen.study.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping("/")
    public String login(){
        return "login";
    }


    @RequestMapping("/login")
    public String loginlogin(){
        return "index";
    }



}
