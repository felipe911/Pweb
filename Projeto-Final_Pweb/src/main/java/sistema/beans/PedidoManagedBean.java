package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Vendedor;
import sistema.modelos.Cliente;
import sistema.modelos.Produto;
import sistema.modelos.Pedido;
import sistema.service.VendedorService;
import sistema.service.ClienteService;
import sistema.service.ProdutoService;
import sistema.service.PedidoService;

@ManagedBean(name = "pedidoManagedBean")
@ViewScoped
public class PedidoManagedBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Pedido pedido = new Pedido();
	private Vendedor vendedor;
	private Cliente cliente;
	private Produto produto;
	private ClienteService clienteService = new ClienteService();
	private ProdutoService produtoService = new ProdutoService();
	private PedidoService pedidoService = new PedidoService();
	private VendedorService vendedorService = new VendedorService();
	private List<Pedido> pedidos;

	public void salvar() {
		vendedor.addPedido(pedido);
		pedido.setVendedor(vendedor);
		pedido.setCliente(cliente);
		pedido.setProduto(produto);

		pedido = pedidoService.salvar(pedido);

		if (pedidos != null)
			pedidos.add(pedido);

		pedido = new Pedido();
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

	public void remove(Pedido pedido) {
		pedidoService.remover(pedido);
		pedidos.remove(pedido);
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		if (pedidos == null)
			pedidos = pedidoService.getPedidos();

		return pedidos;
	}

	public void onRowEdit(RowEditEvent event) {

		Pedido p = ((Pedido) event.getObject());
		pedidoService.alterar(p);
	}

}
