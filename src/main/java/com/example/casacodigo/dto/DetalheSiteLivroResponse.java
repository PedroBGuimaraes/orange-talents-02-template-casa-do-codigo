package com.example.casacodigo.dto;

import java.math.BigDecimal;

import com.example.casacodigo.model.Autor;
import com.example.casacodigo.model.Livro;

public class DetalheSiteLivroResponse {

	private String titulo;
	private DetalheSiteAutorResponse autor;
	private BigDecimal preco;
	private String sumario;
	private String isbn;
	private String resumo;
	private Integer numeroPaginas;

	public DetalheSiteLivroResponse(Livro livro) {
		this.titulo = livro.getTitulo();
		this.autor = new DetalheSiteAutorResponse(livro.getAutor());
		this.preco = livro.getPreco();
		this.sumario = livro.getSumario();
		this.isbn = livro.getIsbn();
		this.resumo = livro.getResumo();
		this.numeroPaginas = livro.getNumeroPaginas();
	}

	public String getTitulo() {
		return titulo;
	}

	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getSumario() {
		return sumario;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getResumo() {
		return resumo;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	
	
	
}
