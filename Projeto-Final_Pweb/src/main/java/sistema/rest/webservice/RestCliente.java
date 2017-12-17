package sistema.rest.webservice;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import sistema.modelos.Cliente;
import sistema.service.ClienteService;

public class RestCliente {

	   @GET
	   @Path("/pesquisar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Cliente pesquisar(@QueryParam("cliente") Cliente cliente){
	          ClienteService service = new ClienteService();
	          return service.pesquisar(cliente);
	    }
	   

	   @POST
	   @Path("/salvar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Cliente save(Cliente cliente){
	          ClienteService service = new ClienteService();
	          return service.salvar(cliente);
	    }
	   
	   
	   @DELETE
	   @Path("/remover")
	   @Produces(MediaType.APPLICATION_JSON)
	    public void remover(@QueryParam("cliente") Cliente cliente){
	          ClienteService service = new ClienteService();
	          service.remover(cliente);
	    }
	   
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Cliente> getAllClientes(){
		   List<Cliente> clientes;
		   ClienteService service = new ClienteService();
		   clientes = service.getClientes();
	       return clientes;
	   }
	   

	   @PUT
	   @Path("/alterar")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Cliente alterar(Cliente cliente){
		   ClienteService service = new ClienteService();
		   // cliente = service.alterar(cliente);  TÁ COM ERRO NÃO SEI PORQUE =(
	       return cliente;
	   }
	
	
}


