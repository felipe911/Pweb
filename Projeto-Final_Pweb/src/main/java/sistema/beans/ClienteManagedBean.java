package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.beans.datamodel.ClienteDataModel;
import sistema.modelos.Cliente;
import sistema.modelos.Produto;
import sistema.service.ClienteService;

@ManagedBean
@ViewScoped
public class ClienteManagedBean {

	private Cliente cliente = new Cliente();
	private Cliente clienteSelecionado;
	private ClienteService clientService = new ClienteService();
	private List<Cliente> clientes;

	public Cliente getClienteSelecionado() {
		return clienteSelecionado;
	}

	public void setClienteSelecionado(Cliente clienteSelecionado) {
		this.clienteSelecionado = clientService.pesquisar(clienteSelecionado);
	}

	public void salvar() {
		cliente = clientService.salvar(cliente);

		if (clientes != null)
			clientes.add(cliente);

		cliente = new Cliente();

	}

	public DataModel<Cliente> getClientes() {
		if (clientes == null)
			clientes = clientService.getClientes();

		return new ClienteDataModel(clientes);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void remove(Cliente cliente) {
		if (clientService.pesquisarProdutosCliente(cliente).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover cliente",
					"Cliente possui produtos!"));
		} else {
			clientService.remover(cliente);
			clientes.remove(cliente);
		}
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Produto> getProdutosCliente() {
		if (clienteSelecionado != null) {
			return clientService.pesquisarProdutosCliente(clienteSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Cliente f = ((Cliente) event.getObject());
		clientService.alterar(f);
	}

}
