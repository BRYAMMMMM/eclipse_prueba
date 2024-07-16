package ec.edu.ups.ppw.demojakarata.views;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.Gestionclientes;
import ec.edu.ups.ppw.demojakarta.model1.Cliente;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named("clientes")
@RequestScoped
public class VistaClientes {
	
	@Inject
	private Gestionclientes gClientes;
	
	private Cliente persona = new Cliente();
	
	private List<Cliente> listado;
	
	
	@PostConstruct
	public void init() {
		listado = gClientes.getClientes();
	}


	public List<Cliente> getListado() {
		return listado;
	}
	public void setListado(List<Cliente> listado) {
		this.listado = listado;
	}
	@Override
	public String toString() {
		return "VistaClientes [gClientes=" + gClientes + ", persona=" + persona + "]";
	}
	public Cliente getPersona() {
		return persona;
	}
	public void setPersona(Cliente persona) {
		this.persona = persona;
	}


	public String guardar() {
		
		System.out.println(this.persona);
		
		try {
			gClientes.createCliente(persona);
			
			return "listadoclientes?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
				
	}
	

}
