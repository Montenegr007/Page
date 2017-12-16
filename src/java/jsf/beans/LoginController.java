package jsf.beans;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.inject.Named;
import jsf.entities.Users;
import jsf.sessions.UsersFacade;

@ManagedBean
public class LoginController implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
   @EJB
   private UsersFacade usersFacade;
     
    
   private String email;
   private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
      this.email = email;
    }

    public String getPassword() {
       return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

       public String buttonAction(){ 
        
          
              Users user = usersFacade.find(getEmail());
                 if (user.getPassword().equals(getPassword())){
                    return "admin?faces-redirect=true";
                 }else {
                    return "passrecovery?faces-redirect=true";   
                 }
          
    }
}