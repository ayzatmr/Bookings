package com.example.cotroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by Ayzat on 26.01.2017.
 */
@Controller
public class ViewController {

//    @Value("${appMode}")
    private String appMode;

    @Autowired
    public ViewController(Environment environment){
        appMode = environment.getProperty("appMode");
    }



    @RequestMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("username", "Ayzat");
        model.addAttribute("mode", appMode);
        return "index";
    }
}
