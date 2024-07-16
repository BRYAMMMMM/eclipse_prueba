package ec.edu.ups.ppw.demojakarta.model;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.dao.ClienteDAO;
import ec.edu.ups.ppw.demojakarta.model1.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class Gestionclientes {
	
    @Inject
    private ClienteDAO daoCliente;
    
	
    public Cliente getCliente(String cedula) throws Exception {
		if(cedula.length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		
		Cliente cliente = daoCliente.read(cedula);
		if(cliente == null)
			throw new Exception("Cliente no existe");
		return cliente;
	}
	
	public List<Cliente> getClientes(){
		return daoCliente.getAll();
	}
	
	public void createCliente(Cliente cliente) throws Exception {
		if(cliente.getCedula().length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		daoCliente.insert(cliente);
	}
	
	public void updateCliente(Cliente cliente) throws Exception{
		
		
		if(cliente.getCedula().length() != 10) {
			throw new Exception("Cedula Incorrecta");
		}
		
		daoCliente.update(cliente);
	}
	
	
	public void deleteCliente(String cedula) throws Exception{
		Cliente cliente = daoCliente.read(cedula);
		if(cliente == null) {				
			throw new Exception("Cliente no existe");
		}
		else {
			daoCliente.delete(cedula);
		}
		
	}


	
}
