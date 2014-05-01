package br.com.locadora.genero;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@SessionScoped
@ManagedBean
public class GeneroBean {
	
	private Integer generoCodigo;
	private String generoDescricao;
	
	
	public void cadastrar(ActionEvent actionEvent){
		FacesContext context = FacesContext.getCurrentInstance();
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cadastro efetuado com sucesso.", "Olá"));
		
	}
	
	public Integer getGeneroCodigo() {
		return generoCodigo;
	}
	public void setGeneroCodigo(Integer generoCodigo) {
		this.generoCodigo = generoCodigo;
	}
	public String getGeneroDescricao() {
		return generoDescricao;
	}
	public void setGeneroDescricao(String generoDescricao) {
		this.generoDescricao = generoDescricao;
	}
	
}
