package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Vendedor;
import sistema.modelos.Cliente;
import sistema.modelos.Produto;
import sistema.modelos.Venda;
import sistema.service.VendedorService;
import sistema.service.ClienteService;
import sistema.service.ProdutoService;
import sistema.service.VendaService;

@ManagedBean(name = "vendaManagedBean")
@ViewScoped
public class VendaManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Venda venda = new Venda();
	private Vendedor vendedor;
	private Cliente cliente;
	private Produto produto;
	private ClienteService clienteService = new ClienteService();
	private ProdutoService produtoService = new ProdutoService();
	private VendaService vendaService = new VendaService();
	private VendedorService vendedorService = new VendedorService();
	private List<Venda> vendas;

	public void salvar() {
		vendedor.addVenda(venda);
		venda.setVendedor(vendedor);
		venda.setCliente(cliente);
		venda.setProduto(produto);

		venda = vendaService.salvar(venda);

		if (vendas != null)
			vendas.add(venda);

		venda = new Venda();
		vendedor = null;

	}

	public List<Vendedor> getVendedores() {
		return vendedorService.getVendedores();

	}
	
	public List<Cliente> getClientes() {
		return clienteService.getClientes();

	}
	
	public List<Produto> getProdutos() {
		return produtoService.getProdutos();

	}


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}
	
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public void remove(Venda venda) {
		vendaService.remover(venda);
		vendas.remove(venda);
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

	public List<Venda> getVendas() {
		if (vendas == null)
			vendas = vendaService.getVendas();

		return vendas;
	}

	public void onRowEdit(RowEditEvent event) {

		Venda p = ((Venda) event.getObject());
		vendaService.alterar(p);
	}

}
