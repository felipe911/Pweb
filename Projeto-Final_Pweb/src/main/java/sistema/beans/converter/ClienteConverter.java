package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Cliente;
import sistema.service.ClienteService;



@FacesConverter("converterCliente")
public class ClienteConverter implements Converter {

	private ClienteService servico = new ClienteService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Cliente f : servico.getClientes())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object cliente) {
		if (cliente == null || cliente.equals("")) {
			return null;
		} else {
			return ((Cliente) cliente).getNome();

		}
	}

}
