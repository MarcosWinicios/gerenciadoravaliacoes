package siapro.dao;

import java.util.List;

import siapro.model.Entidade;

public interface InterfaceDAO {
	
	public Entidade salvar(Entidade entidade);
	
	public Entidade editar(Entidade entidade);
	
	public List<Entidade> listarTudo();
	
	public Entidade pesquisarId(int id);

}
