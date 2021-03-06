/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.test;

import in.ezeon.capp.config.SpringRootConfig;
import in.ezeon.capp.dao.UserDAO;
import in.ezeon.capp.domain.User;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author osmanForhad
 */
public class TestUserDAOFindByProp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRootConfig.class);
        UserDAO userDAO = ctx.getBean(UserDAO.class);
        
        //List<User> users = userDAO.findByProperty("userId", 1);
        //List<User> users = userDAO.findByProperty("name", "osman");
        List<User> users = userDAO.findByProperty("role", 2);
        for (User u : users) {
            System.out.println(u.getUserId()+" "+u.getName()+" "+u.getRole());
            //TODO: access others columns
        }
     
    }
    
}
