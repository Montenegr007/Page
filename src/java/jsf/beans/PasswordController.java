package jsf.beans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import jsf.entities.Users;
import jsf.sessions.UsersFacade;
import jsf.utils.MailSender;


@ManagedBean
@SessionScoped
public class PasswordController {
    
    
    @EJB
    private UsersFacade usersFacade;
    
    private String email;
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PasswordController() {
    }
    
    
    public String sendPassword() {
        Users user = usersFacade.find(email);
        if (user.getPassword() != null) {

            MailSender ms = new MailSender();
            ms.sendPassword(user.getPassword(), user.getEmail());

            return "admin?faces-redirect=true";
        } else {
            return "failure?faces-redirect=true";
        }
      
    }
    
       
    
    
}
