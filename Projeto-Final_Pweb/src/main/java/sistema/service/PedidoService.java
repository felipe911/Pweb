package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.dao.PedidoDAO;
import sistema.modelos.Cliente;
import sistema.modelos.Pedido;

public class PedidoService {

	PedidoDAO pedidoDAO = new PedidoDAO();

	public Pedido salvar(Pedido pedido) {
		pedido = pedidoDAO.save(pedido);
		pedidoDAO.closeEntityManager();
		return pedido;

	}

	public List<Pedido> getPedidos() {
		List<Pedido> list = pedidoDAO.getAll(Pedido.class);
		pedidoDAO.closeEntityManager();
		return list;
	}
	
	public Pedido pesquisar(Pedido pedido) {

		pedido = pedidoDAO.getById(Pedido.class, pedido.getCodigo());
		pedidoDAO.closeEntityManager();
		return pedido;
	}
	

	public void alterar(Pedido pedido) {
		pedidoDAO.save(pedido);
		pedidoDAO.closeEntityManager();
	}

	public void remover(Pedido pedido) {

		pedido = pedidoDAO.getById(Pedido.class, pedido.getCodigo());
		pedidoDAO.remove(pedido);
		pedidoDAO.closeEntityManager();
	}

}
