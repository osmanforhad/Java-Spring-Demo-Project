/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.controller;

import in.ezeon.capp.command.LoginCommand;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author User
 */
@Controller
public class MainController {
   @RequestMapping(value = {"/","/index"})
    public String index(Model m){
        m.addAttribute("command", new LoginCommand());
        return "index"; //JSP - /WEB-INF/view/index.jsp
    }
}
