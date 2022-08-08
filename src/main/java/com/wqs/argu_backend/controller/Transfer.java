package com.wqs.argu_backend.controller;

import com.wqs.argu_backend.bean.Schema;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Transfer {
   @RequestMapping( "/")
   public String home(){
       return "home";
   }
   @RequestMapping( "/home")
    public String Home(){
       return "home";
    }
    @RequestMapping( "/view")
    public String View(){
        return "view";
    }
    @RequestMapping( "/find")
    public String Find(){
        return "search";
    }

    @RequestMapping( "/createNewFrame")
    public String challengeArgument(String type){
        System.out.println(type);
        return "createFrame";
    }

}


