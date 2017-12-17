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

import sistema.modelos.Pedido;
import sistema.service.PedidoService;

public class RestPedido {

	   @GET
	   @Path("/pesquisar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Pedido pesquisar(@QueryParam("pedido") Pedido pedido){
	          PedidoService service = new PedidoService();
	          return service.pesquisar(pedido);
	    }
	   

	   @POST
	   @Path("/salvar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Pedido save(Pedido pedido){
	          PedidoService service = new PedidoService();
	          return service.salvar(pedido);
	    }
	   
	   
	   @DELETE
	   @Path("/remover")
	   @Produces(MediaType.APPLICATION_JSON)
	    public void remover(@QueryParam("pedido") Pedido pedido){
	          PedidoService service = new PedidoService();
	          service.remover(pedido);
	    }
	   
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Pedido> getAllPedidos(){
		   List<Pedido> pedidos;
		   PedidoService service = new PedidoService();
		   pedidos = service.getPedidos();
	       return pedidos;
	   }
	   

	   @PUT
	   @Path("/alterar")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Pedido alterar(Pedido pedido){
		   PedidoService service = new PedidoService();
		   // pedido = service.alterar(pedido);  TÁ COM ERRO NÃO SEI PORQUE =(
	       return pedido;
	   }
	
	
}
