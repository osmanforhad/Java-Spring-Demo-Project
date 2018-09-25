/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.ezeon.capp.exception;

/**
 *
 * @author osmanForhad
 */
public class UserBlockedException extends Exception{
    /**
     * Creates User object without error description
     */
    public UserBlockedException(){
        
    }
     /**
     * Creates User object with error description
     */
    public UserBlockedException(String errDesc){
        super(errDesc);
    }
    
}
