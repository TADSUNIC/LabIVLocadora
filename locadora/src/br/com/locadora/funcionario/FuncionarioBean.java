package br.com.locadora.funcionario;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

@SessionScoped
@ManagedBean
public class FuncionarioBean {
	private String usuario;  
    
    private String senha;  
      
    public String getUsuario() {  
        return usuario;  
    }  
  
    public void setUsuario(String usuario) {  
        this.usuario = usuario;  
    }  
  
    public String getSenha() {  
        return senha;  
    }  
  
    public void setSenha(String senha) {  
        this.senha = senha;  
    }  
  
    public void login(ActionEvent actionEvent) {  
        RequestContext context = RequestContext.getCurrentInstance();  
        FacesMessage msg = null;  
        boolean loggedIn = false;
          
        if(usuario != null  && usuario.equals("admin") && senha != null  && senha.equals("admin")) {  
            loggedIn = true;  
            msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo", usuario);
            try {
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Acesso permitido"," Bem vindo ao sistema"));
            	
				FacesContext.getCurrentInstance().getExternalContext().redirect("painel/");
			} catch (IOException e) {
				e.printStackTrace();
			}
        } else {  
            loggedIn = false;  
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no login", "Usuário e senha não correspondem");
        }  
          
        FacesContext.getCurrentInstance().addMessage(null, msg);  
        context.addCallbackParam("loggedIn", loggedIn);  
    }  
    
    

	  
	  
    
  
}
