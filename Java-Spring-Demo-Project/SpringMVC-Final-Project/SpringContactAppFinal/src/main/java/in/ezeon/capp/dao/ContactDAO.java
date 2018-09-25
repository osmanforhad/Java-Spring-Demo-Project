/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.dao;

import in.ezeon.capp.domain.Contact;
import java.util.List;

/**
 *
 * @author osmanForhad
 */
public interface ContactDAO {
    
    public void save(Contact c);
    
    public void update(Contact c);
    
    public void delete(Contact c);
    
    public void delete(Integer contactId);
    
    public Contact findById(Integer contactId);
    
    public List<Contact> findall();
    
    public List<Contact> findByProperty(String propName, Object propValue);
}
