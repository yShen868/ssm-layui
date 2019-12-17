package com.yShen.study.controller;


import com.yShen.study.model.Manualsign;
import com.yShen.study.model.User;
import com.yShen.study.service.IManualsignService;
import com.yShen.study.util.Datajson;
import com.yShen.study.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manualsign")
public class ManualsignController {

    IManualsignService manualsignService;

    public IManualsignService getManualsignService() {
        return manualsignService;
    }

    @Autowired
    public void setManualsignService(IManualsignService manualsignService) {
        this.manualsignService = manualsignService;
    }

    @RequestMapping(value = "insert",method = RequestMethod.POST)
    @ResponseBody
    public Datajson insert(String m_desc, HttpSession session) throws ParseException {
        System.out.println(999);
        System.out.println(m_desc);
        User user = (User) session.getAttribute("user");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        //要比较的时间
        Date endTime = df.parse("8:00");
        //当前时间只取小时和分钟
        Date nowTime = df.parse(df.format(new Date()));
        //判断当前时间是否大于 endTime
        boolean after = nowTime.after(endTime);

//这里改过来
        if (after){

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            System.out.println(format);

            Map<String,Object> map = new HashMap<>();
            Integer integer = user.getU_id();
            System.out.println(integer);
            map.put("come",format);
            map.put("u_id",integer);
            int selecttoday = manualsignService.selecttoday(map);
            if (selecttoday>0) {
                return new Datajson(2,"超时，但已经签到了");
            }else {
                if (m_desc != null && !"".equals(m_desc)) {
                    Manualsign manualsign = new Manualsign(new Date(), user.getU_id(), m_desc);
                    manualsignService.insert(manualsign);
                    return new Datajson(1,"有备注那就给你添加一次");
                }else {
                    return new Datajson(1,"超时签到 失败");
                }
            }

        }else {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = simpleDateFormat.format(new Date());
            System.out.println(format);

            Map<String,Object> map = new HashMap<>();
            Integer integer = user.getU_id();
            System.out.println(integer);
            map.put("come",format);
            map.put("u_id",integer);
//            int selecttoday =0;
            int selecttoday = manualsignService.selecttoday(map);
            System.out.println(selecttoday+"iiiiiiiiiiiiiiiiiiiiiiiiiii");

            if (selecttoday>0) {
                return new Datajson(2,"今天已经签到，请勿重复签到");
            }else {
                Manualsign manualsign = new Manualsign(new Date(), user.getU_id(), m_desc);
                manualsignService.insert(manualsign);
                return new Datajson(0,"签到成功");
            }

        }

    }


    @RequestMapping(value = "select")
    @ResponseBody
    public Datajson select(Page page,  String start,  String end,String name){
        Map<String,Object> map = new HashMap<>();
        map.put("page",(page.getPage()-1)*page.getLimit());
        map.put("limit",page.getLimit());
        if (start!=null&&!"".equals(start)) {
            System.out.println("----------------");
            map.put("start",start);
        }
        if (end!=null&&!"".equals(end)) {
            System.out.println("----------------");
            map.put("end",end);
        }
        if (name!=null&&!"".equals(name)) {
            System.out.println("----------------");
            map.put("name",name);
        }

        List<Manualsign> manualsigns = manualsignService.selectAllpage(map);
        Datajson datajson = new Datajson();
        datajson.setMsg("测试");
        datajson.setCode(0);
        datajson.setCount(manualsignService.count(map));
        datajson.setData(manualsigns);
        return datajson;
    }


    @RequestMapping("/s")
    @ResponseBody
    public String selectAll(){

        return "-------------------------------------";
    }






}
