package siapro.controller;

import java.util.List;

import siapro.dao.CriterioDAO;
import siapro.dao.EventoDAO;
import siapro.model.Categoria;
import siapro.model.Criterio;
import siapro.model.Evento;

public class CriterioController {
	public void Salvar(Categoria categoria, String nome, String descricao, String notaMax, String notaMin) {
		double notaMaxima = Double.parseDouble(notaMax);
		double notaMinima = Double.parseDouble(notaMin);
		
		Criterio c = new Criterio();
		c.setNome(nome);
		c.setDescricao(descricao);
		c.setNotaMaxima(notaMaxima);
		c.setNotaMinima(notaMinima);
		c.setCategoria(categoria);
		new CriterioDAO().salvar(c);
	}
	
	public List<Categoria> listaCategorias(Evento e){
		List<Categoria> categorias =  new ListarCategoriaController().listarCategoria(e);
		return categorias;
	}
	
	public Evento listarCategorias(Categoria c) {
		c.setEvento((Evento) new EventoDAO().pesquisarPorCategoria(c));
		return c.getEvento();
	}
}