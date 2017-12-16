/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class AdminController {

    public void view(){
        System.out.println("Blablabla");
    }
    
    public String login(){
        return "loginsuccess?faces-redirect=true";
    }
    
    
    public AdminController() {
    }
    
}
