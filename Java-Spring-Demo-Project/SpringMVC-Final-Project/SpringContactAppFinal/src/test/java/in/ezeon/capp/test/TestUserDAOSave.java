/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.test;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author osmanForhad
 */
public class TestUserDAOSave {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from User-Reg-Form
        User u = new User();
        u.setName("Sanim");
        u.setPhone("01733706918");
        u.setEmail("sanim@gmail.com");
        u.setAddress("Dhaka");
        u.setLoginName("sanim");
        u.setPassword("sanim123");
        u.setRole(1);//Admin Role
        u.setLoginStatus(1);//Active
        userDAO.save(u);
        System.out.println("........Data Saved........");
    }
    
}
