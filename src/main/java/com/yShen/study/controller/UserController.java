package com.yShen.study.controller;

import com.yShen.study.model.User;
import com.yShen.study.service.IUserService;
import com.yShen.study.util.Datajson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    private IUserService userService;

    public IUserService getUserService() {
        return userService;
    }
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/selectAll")
    public List<User> selectAll(){
        return userService.selectAll(new User());
    }

    @ResponseBody
    @RequestMapping("/s")
    public User s(){
        return userService.selectOne(new User("1","1"));
    }


    @ResponseBody
    @RequestMapping(value = "/selectOne",method = RequestMethod.POST)
    public Datajson selectOne(String u_name, String password, HttpSession session){
        User user = new User();
        user.setPassword(password);
        user.setU_name(u_name);
        System.out.println(user.getU_name());
        System.out.println(user.getPassword());
        User selectOne = userService.selectOne(user);
        if (selectOne==null){
            return new Datajson(0);
        }else {
            session.setAttribute("user",selectOne);
            return new Datajson(1);
        }
    }
}
