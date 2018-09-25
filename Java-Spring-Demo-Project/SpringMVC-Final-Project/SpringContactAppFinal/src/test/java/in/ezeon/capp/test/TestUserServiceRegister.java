/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.test;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.domain.User;
import in.ezeon.capp.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author osmanForhad
 */
public class TestUserServiceRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u = new User();
        u.setName("Zubayer");
        u.setPhone("016655222");
        u.setEmail("zubayer@gmail.com");
        u.setAddress("Dhaka");
        u.setLoginName("zubayer");
        u.setPassword("zubayer123");
        u.setRole(UserService.ROLE_ADMIN);
        u.setLoginStatus(UserService.LOGIN_STATUS_ACTIVE);
        userService.register(u);
        System.out.println("........User Registered Successfully........");
    }
    
}
