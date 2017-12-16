/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsf.beans;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import jsf.entities.Users;
import jsf.sessions.UsersFacade;

@ManagedBean
@SessionScoped
public class RegistrationController {
    
    @EJB
    UsersFacade usersFacade;
    
    private String email;
    private String password;
       
    
    public String userRegistration(){
        Users user = new Users(email, password);
        usersFacade.create(user);
        //return "index?faces-redirect=true";
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful!"));
        Flash flash = context.getExternalContext().getFlash();
        flash.setKeepMessages(true);
        flash.setRedirect(true);
        return "index?faces-redirect=true";
    }

    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

        
}
