package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.VendaDAO;
import sistema.modelos.Venda;

public class VendaService {

	VendaDAO vendaDAO = new VendaDAO();

	public Venda salvar(Venda venda) {
		venda = vendaDAO.save(venda);
		vendaDAO.closeEntityManager();
		return venda;

	}

	public List<Venda> getVendas() {
		List<Venda> list = vendaDAO.getAll(Venda.class);
		vendaDAO.closeEntityManager();
		return list;
	}

	public void alterar(Venda venda) {
		vendaDAO.save(venda);
		vendaDAO.closeEntityManager();
	}

	public void remover(Venda venda) {

		venda = vendaDAO.getById(Venda.class, venda.getCodigo());
		vendaDAO.remove(venda);
		vendaDAO.closeEntityManager();
	}

}
