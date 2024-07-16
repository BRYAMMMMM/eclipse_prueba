package ec.edu.ups.ppw.demojakarata.services;

import java.util.List;

import ec.edu.ups.ppw.demojakarta.model.Gestionclientes;
import ec.edu.ups.ppw.demojakarta.model1.Cliente;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
public class ClientesService {
	
	/** solicitudes ejemplo
	 *  
	 *POST demojakarta/rs/clientes/
	*PUT demojakarta/rs/clientes/
	*DELETE demojakarta/rs/clientes/?02120
	*GET demojakarta/rs/clientes/
	*	*GET demojakarta/rs/clientes/0103870

	 */
	
	@Inject
	private Gestionclientes gClientes;
	
	
	
	@POST
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(Cliente cliente) {
		
		try {
			gClientes.createCliente(cliente);
			Response.ok(cliente).build();
		} catch (Exception e) {
			
			e.printStackTrace();
			Response.status(503).entity(new Respuesta(Respuesta.error, "Error eb BD")).build();
		}
		return null;
		
		
		

	}
	
	@PUT
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces("application/json")

	public void update(Cliente cliente) {
		
		try {
			gClientes.updateCliente(cliente);
			Response.ok(cliente).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Response.status(503).entity(new Respuesta(Respuesta.error, "Error eb BD")).build();

		}
		
		
		
	}
	
	@DELETE
	@Produces("application/json")
	public Response delete(@QueryParam("id") String cedula) {
		try {
			gClientes.deleteCliente(cedula);
			return Response.ok(cedula).build();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return Response.status(503).entity(new Respuesta(Respuesta.error, "Error en BD")).build();
		}
		
	}

	
	@GET
	@Path("/{cedula}")
	@Produces("application/json")
	public Cliente get(String cedula) {
		Cliente cliente;
		try {
			cliente = gClientes.getCliente(cedula);
			return cliente;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
	 @GET
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response list() {
	        List<Cliente> clientes = gClientes.getClientes(); // Suponiendo que gClientes es tu servicio para obtener clientes

	        // Configuración de las cabeceras CORS
	        return Response.status(200)
	                .header("Access-Control-Allow-Origin", "*")
	                .header("Access-Control-Allow-Credentials", "true")
	                .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	                .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	                .entity(clientes)
	                .build();
	    }

	



}
