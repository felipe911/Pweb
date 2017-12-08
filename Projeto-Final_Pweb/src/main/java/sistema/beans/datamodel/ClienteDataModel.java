package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Cliente;
import sistema.service.ClienteService;


public class ClienteDataModel extends ListDataModel<Cliente> implements SelectableDataModel<Cliente> 
{
	private ClienteService servico = new ClienteService();
	
	public ClienteDataModel()
	{
		
	}

	public ClienteDataModel(List <Cliente> list)
	{
	   super(list);	
	}

	
	@Override
	public Cliente getRowData(String rowKey) {
		
		for(Cliente f: servico.getClientes())
		   if(Integer.parseInt(rowKey) ==  f.getCodigo())
			   return servico.pesquisar(f);
		
		return null;
	}

	@Override
	public Object getRowKey(Cliente cliente) {
		return cliente.getCodigo();
	}
	
}