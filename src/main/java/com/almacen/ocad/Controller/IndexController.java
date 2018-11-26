package com.almacen.ocad.Controller;

import com.almacen.ocad.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(){
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute("currentPage","Login");
        return "loginForm";
    }
}
