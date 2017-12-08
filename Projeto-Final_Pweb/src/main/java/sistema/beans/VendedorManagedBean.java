package sistema.beans;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import org.primefaces.event.RowEditEvent;
import sistema.beans.datamodel.VendedorDataModel;
import sistema.modelos.Vendedor;
import sistema.modelos.Venda;
import sistema.service.VendedorService;

@ManagedBean
@ViewScoped
public class VendedorManagedBean {

	private Vendedor vendedor = new Vendedor();
	private Vendedor vendedorSelecionado;
	private VendedorService servico = new VendedorService();
	private List<Vendedor> vendedores;

	public Vendedor getVendedorSelecionado() {
		return vendedorSelecionado;
	}

	public void setVendedorSelecionado(Vendedor vendedorSelecionado) {
		this.vendedorSelecionado = servico.pesquisar(vendedorSelecionado);
	}

	public void salvar() {
		vendedor = servico.salvar(vendedor);

		if (vendedores != null)
			vendedores.add(vendedor);

		vendedor = new Vendedor();

	}

	public DataModel<Vendedor> getVendedores() {
		if (vendedores == null)
			vendedores = servico.getVendedores();

		return new VendedorDataModel(vendedores);
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void remover(Vendedor vendedor) {
		if (servico.pesquisarVendasVendedor(vendedor).size() > 0) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Não é possível remover vendedor",
					"Vendedor possui vendas!"));
		} else {
			servico.remover(vendedor);
			vendedores.remove(vendedor);
		}
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public List<Venda> getVendasVendedor() {
		if (vendedorSelecionado != null) {
			return servico.pesquisarVendasVendedor(vendedorSelecionado);
		} else
			return null;
	}

	public void onRowEdit(RowEditEvent event) {

		Vendedor f = ((Vendedor) event.getObject());
		servico.alterar(f);
	}

}
