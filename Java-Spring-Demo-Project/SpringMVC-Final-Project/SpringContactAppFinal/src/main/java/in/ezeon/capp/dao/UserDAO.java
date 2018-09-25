/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.dao;

import in.ezeon.capp.domain.User;
import java.util.List;

/**
 *
 * @author osmanForhad
 */
public interface UserDAO {
    
    public void save(User u);
    
    public void update(User u);
    
    public void delete(User u);
    
    public void delete(Integer userId);
    
    public User findById(Integer userId);
    
    public List<User> findall();
    
    public List<User> findByProperty(String propName, Object propValue);
}
