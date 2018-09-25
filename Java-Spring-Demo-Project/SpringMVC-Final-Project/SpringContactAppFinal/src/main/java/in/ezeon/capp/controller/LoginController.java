/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.controller;

import in.ezeon.capp.command.LoginCommand;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.exception.UserBlockedException;
import in.ezeon.capp.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author User
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLogin(@ModelAttribute("command") LoginCommand cmd, Model m,HttpSession session){
        try {
            User loggedInUser = userService.login(cmd.getLoginName(), cmd.getPassword());
            if (loggedInUser == null) {
                //login Faield
                //Add error message and go back to login-form
            m.addAttribute("err", "Login Failed! Enter valid credentials.");
            return "index";//JSP - Login FORM
            } else{
                //Login Success
                //Checck the role and redirect to a appropriate dashboard
                if (loggedInUser.getRole().equals(UserService.ROLE_ADMIN)) {
                    //add user deatail in session (assain session to loggedin user)
                    addUserInSession(loggedInUser, session);
                    return "redirect:admin/dashboard";
                } else if(loggedInUser.getRole().equals(UserService.ROLE_USER)){
                    //add user deatail in session (assain session to loggedin user)
                    addUserInSession(loggedInUser, session);
                    return "redirect:user/dashboard";
                } else{
                    //Add error message and go back to login-form
            m.addAttribute("err", "Invalid User ROLE");
            return "index";//JSP - Login FORM
                }
            }
        } catch (UserBlockedException ex) {
            //Add error message and go back to login-form
            m.addAttribute("err", ex.getMessage());
            return "index";//JSP - Login FORM
        }
    }
    @RequestMapping(value = "/user/dashboard")
    public String userDashboard(){
        return "dashboard_user"; //JSP
    }
    
    @RequestMapping(value = "/admin/dashboard")
    public String adminDashboard(){
        return "dashboard_admin"; //JSP
    }
        private void addUserInSession(User u, HttpSession session){
        session.setAttribute("user", u);
        session.setAttribute("userId", u.getUserId());
        session.setAttribute("role", u.getRole());
    }
}
