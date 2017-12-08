package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Vendedor;
import sistema.service.VendedorService;



@FacesConverter("converterVendedor")
public class VendedorConverter implements Converter {

	private VendedorService servico = new VendedorService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Vendedor f : servico.getVendedores())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object vendedor) {
		if (vendedor == null || vendedor.equals("")) {
			return null;
		} else {
			return ((Vendedor) vendedor).getNome();

		}
	}

}
