package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Produto;
import sistema.service.ProdutoService;



@FacesConverter("converterProduto")
public class ProdutoConverter implements Converter {

	private ProdutoService servico = new ProdutoService();
	
	@Override
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Produto f : servico.getProdutos())
				 if(f.getDescricao().equals(value))
				  	return f;
					
		}

		return null;

	}

	@Override
	public String getAsString(FacesContext fc, UIComponent uic,
			Object produto) {
		if (produto == null || produto.equals("")) {
			return null;
		} else {
			return ((Produto) produto).getDescricao();

		}
	}

}
