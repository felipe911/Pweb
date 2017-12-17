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

import sistema.modelos.Produto;
import sistema.service.ProdutoService;

public class RestProduto {

	   @GET
	   @Path("/pesquisar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Produto pesquisar(@QueryParam("produto") Produto produto){
	          ProdutoService service = new ProdutoService();
	          return service.pesquisar(produto);
	    }
	   

	   @POST
	   @Path("/salvar")
	   @Produces(MediaType.APPLICATION_JSON)
	    public Produto save(Produto produto){
	          ProdutoService service = new ProdutoService();
	          return service.salvar(produto);
	    }
	   
	   
	   @DELETE
	   @Path("/remover")
	   @Produces(MediaType.APPLICATION_JSON)
	    public void remover(@QueryParam("produto") Produto produto){
	          ProdutoService service = new ProdutoService();
	          service.remover(produto);
	    }
	   
	   @GET
	   @Path("/all")
	   @Produces(MediaType.APPLICATION_JSON)
	   public List<Produto> getAllProdutos(){
		   List<Produto> produtos;
		   ProdutoService service = new ProdutoService();
		   produtos = service.getProdutos();
	       return produtos;
	   }
	   

	   @PUT
	   @Path("/alterar")
	   @Produces(MediaType.APPLICATION_JSON)
	   public Produto alterar(Produto produto){
		   ProdutoService service = new ProdutoService();
		   // produto = service.alterar(produto);  TÁ COM ERRO NÃO SEI PORQUE =(
	       return produto;
	   }
	
	
}
