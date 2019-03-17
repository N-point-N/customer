package controllers;

import dao.MainDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private MainDao mainDao;

    @GetMapping("/servlet")
    public String servletIndex(){
        mainDao.getCheTo();
        return "servlet-index";
    }



}
