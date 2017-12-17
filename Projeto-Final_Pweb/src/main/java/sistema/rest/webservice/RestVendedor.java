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

import sistema.modelos.Vendedor;
import sistema.service.VendedorService;

public class RestVendedor {

	   @GET
	   @Path("/pesquisar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Vendedor pesquisar(@QueryParam("vendedor") Vendedor vendedor){
		   	  VendedorService service = new VendedorService();
	          return service.pesquisar(vendedor);
	    }
	   

	   @POST
	   @Path("/salvar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Vendedor save(Vendedor vendedor){
		      VendedorService service = new VendedorService();
	          return service.salvar(vendedor);
	    }
	   
	   
	   @DELETE
	   @Path("/remover")
	   @Produces(MediaType.APPLICATION_JSON)
	    public void remover(@QueryParam("vendedor") Vendedor vendedor){
		      VendedorService service = new VendedorService();
	          service.remover(vendedor);
	    }
	   
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Vendedor> getAllVendedores(){
		   List<Vendedor> vendedores;
		   VendedorService service = new VendedorService();
		   vendedores = service.getVendedores();
	       return vendedores;
	   }
	   

	   @PUT
	   @Path("/alterar")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Vendedor alterar(Vendedor vendedor){
		   VendedorService service = new VendedorService();
		   // vendedor = service.alterar(vendedor);  TÁ COM ERRO NÃO SEI PORQUE =(
	       return vendedor;
	   }
	
	
}
