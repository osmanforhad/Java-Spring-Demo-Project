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
public class TestUserDAOUpdate {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        //TODO: the user details will be taken from Update User Profile Page
        User u = new User();
        u.setUserId(2);
        u.setName("osman gani");
        u.setPhone("01733706918");
        u.setEmail("osmanforhad93@gmail.com");
        u.setAddress("Feni");
        u.setRole(1);//Admin Role
        u.setLoginStatus(1);//Active
        userDAO.update(u);
        System.out.println("........Data Updated........");
    }
    
}
