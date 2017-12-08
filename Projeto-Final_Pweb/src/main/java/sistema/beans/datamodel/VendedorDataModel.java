package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Vendedor;
import sistema.service.VendedorService;


public class VendedorDataModel extends ListDataModel<Vendedor> implements SelectableDataModel<Vendedor> 
{
	private VendedorService servico = new VendedorService();
	
	public VendedorDataModel()
	{
		
	}

	public VendedorDataModel(List <Vendedor> list)
	{
	   super(list);	
	}

	
	@Override
	public Vendedor getRowData(String rowKey) {
		
		for(Vendedor f: servico.getVendedores())
		   if(Integer.parseInt(rowKey) ==  f.getCodigo())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(Vendedor vendedor) {
		return vendedor.getCodigo();
	}
	
}