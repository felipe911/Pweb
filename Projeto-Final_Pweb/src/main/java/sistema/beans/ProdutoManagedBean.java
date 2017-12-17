package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Cliente;
import sistema.modelos.Produto;
import sistema.service.ClienteService;
import sistema.service.ProdutoService;

@ManagedBean(name = "produtoManagedBean")
@ViewScoped
public class ProdutoManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Produto produto = new Produto();
	//private Cliente cliente;
	private ProdutoService prodService = new ProdutoService();
	//private ClienteService clientService = new ClienteService();
	private List<Produto> produtos;

	public void salvar() {
		//cliente.addProduto(produto);
		//produto.setCliente(cliente);

		produto = prodService.salvar(produto);

		if (produtos != null)
			produtos.add(produto);

		produto = new Produto();
		//cliente = null;

	}

	/*public List<Cliente> getClientes() {
		return clientService.getClientes();

	}
	*/
	
	/* public Cliente getCliente() {
		return cliente;
	}
	*/
	
	public void remove(Produto produto) {
		prodService.remover(produto);
		produtos.remove(produto);
	}

	
	/* public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	*/
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public List<Produto> getProdutos() {
		if (produtos == null)
			produtos = prodService.getProdutos();

		return produtos;
	}

	public void onRowEdit(RowEditEvent event) {

		Produto p = ((Produto) event.getObject());
		prodService.alterar(p);
	}

}
