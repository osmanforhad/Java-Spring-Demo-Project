/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.controller;

import in.ezeon.capp.command.UserCommand;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author osmanForhad
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/admin/users")
    public String getUserList(Model m){
        m.addAttribute("userList", userService.getUserList());
        return "users"; //JSP
    }
    
    @RequestMapping(value = "/reg_form")
    public String registrationForm(Model m){
        UserCommand cmd = new UserCommand();
        m.addAttribute("command", cmd);
        return "reg_form"; //JSP
    }
    
    @RequestMapping(value = "/register")
    public String registerUser(@ModelAttribute("command") UserCommand cmd, Model m){
        try {
            User user = cmd.getUser();
            user.setRole(UserService.ROLE_USER);
            user.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
            userService.register(user);
            return "redirect:index?act=reg"; //Login Page
        } catch (DuplicateKeyException e) {
            e.printStackTrace();
            m.addAttribute("err", "USer name is already registered. Please select another username.");
            return "reg_form"; //JSP
        }
    }
    
    @RequestMapping(value = "/admin/change_status")
    @ResponseBody
    public String changeLoginStatus(@RequestParam Integer userId, @RequestParam Integer loginStatus){
        try {
            userService.changeLoginStatus(userId, loginStatus);
            return "SUCCESS: Status Changed";
        } catch (Exception e) {
            e.printStackTrace();
            return "ERROR: Unable to Change Status";
        }
    }
    
    @RequestMapping(value = "/check_avail")
    @ResponseBody
    public String checkAvailability(@RequestParam String username){
        if (userService.isUsernameExist(username)) {
            return "This username is alreday taken. Choose another name";
        } else{
            return "Yes! You can take this";
        }
    }
    
}
