package br.com.locadora.cliente;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;



@ManagedBean
@SessionScoped
public class ClienteController {

	private Cliente cliente;
	private ClienteDao clienteDao;
	private List<Cliente> clientes;

	public ClienteController() {
		cliente = new Cliente();
		clienteDao = new ClienteDao();
		clientes = new ArrayList<Cliente>();
	}
	private DataModel<Cliente> clienteDM;

	public String incluir() {
		this.clienteDao.inserir(this.cliente);
		this.cliente = new Cliente();
		return "listar";
	}
	
	public String alterar() {
		this.clienteDao.alterar(this.cliente);
		return "listar";
	}

	public String remover() {
		this.cliente = clienteDM.getRowData();
		
		this.clienteDao.remover(this.cliente);
		return "listar";
	}

	public String exibirFormularioIncluir() {
		this.cliente = new Cliente();
		return "exibirFormularioIncluir";
	}

	public String exibirFormularioEditar() {
		this.cliente = clienteDM.getRowData();
		return "exibirFormularioEditar";
	}
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
		
	}
	
	public DataModel<Cliente> getClienteDM() {
		this.listar();
		clienteDM = new ListDataModel<Cliente>(listar());
		return clienteDM;
	}

	public void setClienteDM(DataModel<Cliente> clienteDM) {
		this.clienteDM = clienteDM;
	}

	public List<Cliente> listar() {
		this.clientes = this.clienteDao.listaTudo();
		return this.clientes;
	}
	
	
}
