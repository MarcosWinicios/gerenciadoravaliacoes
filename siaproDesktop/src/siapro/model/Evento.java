package siapro.model;

import java.util.ArrayList;
import java.util.List;

import siapro.dao.AreaDAO;
import siapro.dao.AvaliadorDAO;
import siapro.dao.CategoriaDAO;
import siapro.dao.OrganizadorDAO;
import siapro.dao.ProjetoDAO;

public class Evento implements Entidade {
	private long id;
	private String nome;
	private String informacoes;
	private boolean liberado;
	private String logotipo;
	private List<Projeto> projetos;
	private List<Avaliador> avaliadores;
	private List<Organizador> organizadores;
	private List<Area> areas;
	private List<Categoria> categorias;
	
	public Evento(long id, String nome, String informacoes,
			boolean liberado, List<Projeto> projetos, List<Avaliador> avaliadores, List<Organizador> organizadores,
			List<Area> areas, List<Categoria> categorias) {
	
		this.id = id;
		this.nome = nome;
		this.informacoes = informacoes;
		this.liberado = liberado;
		this.projetos = projetos;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}
	
	public Evento(Long id, String nome, String informacoes, Boolean liberado, String logotipo ) {
		// criado para listar
		this.id = id;
		this.nome = nome;
		this.informacoes = informacoes;
		this.liberado = liberado;
		this.logotipo = logotipo;
	}

	public Evento(String nome, String informacoes, boolean liberado,
			List<Projeto> area, List<Avaliador> avaliadores, List<Organizador> organizadores, List<Area> areas,
			List<Categoria> categorias) {
		super();
		this.nome = nome;
		this.informacoes = informacoes;
		this.liberado = liberado;
		this.projetos = area;
		this.avaliadores = avaliadores;
		this.organizadores = organizadores;
		this.areas = areas;
		this.categorias = categorias;
	}
	public Evento() {}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getNome();
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(boolean liberado) {
		this.liberado = liberado;
	}

	public List<Projeto> getArea() {
		return projetos;
	}

	public void setArea(List<Projeto> area) {
		this.projetos = area;
	}

	public List<Avaliador> getAvaliadores() {
		return avaliadores;
	}

	public void setAvaliadores(List<Avaliador> avaliadores) {
		this.avaliadores = avaliadores;
	}

	public List<Organizador> getOrganizadores() {
		return organizadores;
	}

	public void setOrganizadores(List<Organizador> organizadores) {
		this.organizadores = organizadores;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public String getLogotipo() {
		return logotipo;
	}

	public void setLogotipo(String logotipo) {
		this.logotipo = logotipo;
	}
	
	public void carregarAvaliadores() {
		this.avaliadores = new ArrayList<>();
		List<Entidade> entidades = new AvaliadorDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.avaliadores.add((Avaliador) entidade);
		}
	}
	
	public void carregarArea() {
		this.areas = new ArrayList<>();
		List<Entidade> entidades = new AreaDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.areas.add((Area) entidade);
		}
	}

	public void carregarProjeto() {
		this.projetos = new ArrayList<>();
		List<Entidade> entidades = new ProjetoDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.projetos.add((Projeto) entidade);
		}
	}
	
	public void carregarCategoria() {
		this.categorias = new ArrayList<>();
		List<Entidade> entidades = new CategoriaDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.categorias.add((Categoria) entidade);
		}
	}
	
	public void carregarOrganizadores() {
		this.organizadores = new ArrayList<>();
		List<Entidade> entidades = new OrganizadorDAO().listarTudo(this);
		for (Entidade entidade : entidades) {
			this.organizadores.add((Organizador) entidade);
		}
	}
}
