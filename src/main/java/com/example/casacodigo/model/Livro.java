package com.example.casacodigo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Livro {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private @NotBlank String titulo;
	private @NotBlank @Size(max = 500) String resumo;
	private String sumario;
	private @NotNull @Min(20) BigDecimal preco;
	private @NotNull @Min(100) Integer numeroPaginas;
	private @NotBlank String isbn;
	private @NotNull @Future LocalDate dataPublicacao;
	@ManyToOne
	private @NotNull @Valid Categoria categoria;
	@ManyToOne
	private @NotNull @Valid Autor autor;
	
	@Deprecated
	public Livro() {
	}

	public Livro(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull @Future LocalDate dataPublicacao, @NotNull @Valid Categoria categoria, @NotNull @Valid Autor autor) {
				this.titulo = titulo;
				this.resumo = resumo;
				this.sumario = sumario;
				this.preco = preco;
				this.numeroPaginas = numeroPaginas;
				this.isbn = isbn;
				this.dataPublicacao = dataPublicacao;
				this.categoria = categoria;
				this.autor = autor;
		// TODO Auto-generated constructor stub
	}
	
	public Autor getAutor() {
		return autor;
	}
	
	public BigDecimal getPreco() {
		return preco;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}
	
	public String getSumario() {
		return sumario;
	}

	@Override
	public String toString() {
		return "Livro [id=" + id + ", titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco="
				+ preco + ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", categoria=" + categoria + ", autor=" + autor + "]";
	}
}
