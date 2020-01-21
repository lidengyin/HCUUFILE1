package cn.hctech2006.hcuufile.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/loginpage")
    public String GetMyLogin(){
        return "index.html";
    }
}
