package siapro.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import siapro.conexao.Conexao;
import siapro.model.Area;
import siapro.model.Avaliacao;
import siapro.model.Categoria;
import siapro.model.Entidade;
import siapro.model.Evento;
import siapro.model.Projeto;

public class ProjetoDAO implements InterfaceDAO{
	private Connection conexao;
	private PreparedStatement stmt;

	public ProjetoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	@Override
	public Entidade salvar(Entidade entidade) {
		String sql = "INSERT INTO contato (titulo, autores, ativo, idEvento, idCategoria, idArea) VALUES (?,?,?,?,?,?)";
		if(entidade instanceof Projeto) {
			Projeto projeto = (Projeto)entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setString(1, projeto.getTitulo());
				stmt.setString(2, projeto.getAutores());
				stmt.setBoolean(3, true);
				stmt.setLong(4, projeto.getEvento().getId());
				stmt.setLong(5, projeto.getCategoria().getId());
				stmt.setLong(6, projeto.getArea().getId());
				stmt.execute();
				stmt.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public Entidade editar(Entidade entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entidade> listarTudo(Entidade entidade) {
		String sql = "SELECT * FROM projeto WHERE idEvento = ?";
		if(entidade instanceof Evento) {
			Evento evento = (Evento)entidade;
			try {
				stmt = conexao.prepareStatement(sql);
				stmt.setLong(1, evento.getId());
				ResultSet rs = stmt.executeQuery();
				List<Entidade> listaProjeto = new ArrayList<Entidade>();
				while (rs.next()) {
					ArrayList<Avaliacao> avaliacoes = new AvaliacaoDAO().pesquisarIdProjeto();
					Area area = new AreaDAO().pesquisarId(rs.getLong("idArea"));
					Categoria categoria = new CategoriaDAO().pesquisarId(rs.getLong("idCategoria"));
					Projeto projeto = new Projeto(rs.getLong("id"), rs.getString("titulo"), rs.getString("autores"), avaliacoes , area, categoria);
					listaProjeto.add((Entidade) projeto);
				}
				stmt.close();
				return listaProjeto;
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		return null;
	}

	@Override
	public Entidade pesquisarId(int id) {
		String sql = "SELECT * FROM projeto WHERE id = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			Projeto projeto;
			List<Entidade> listaProjeto = new ArrayList<Entidade>();
			if (rs.next()) {
				projeto = new Projeto(rs.getLong("id"), null, null, null, null, null);
				Evento evento = new EventoDAO().pesquisarPorProjeto(projeto);
				ArrayList<Avaliacao> avaliacoes = new AvaliacaoDAO().pesquisarPorProjeto(projeto);
				Area area = new AreaDAO().pesquisarId(rs.getLong("idArea"));
				Categoria categoria = new CategoriaDAO().pesquisarId(rs.getLong("idCategoria"));
				projeto = new Projeto(rs.getLong("id"), rs.getString("titulo"), rs.getString("autores"), avaliacoes , area, categoria);
			}
			stmt.close();
			return (Entidade) projeto;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}
}
