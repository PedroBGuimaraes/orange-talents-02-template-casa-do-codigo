package com.example.casacodigo.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.example.casacodigo.model.Autor;
import com.example.casacodigo.model.Categoria;
import com.example.casacodigo.model.Livro;
import com.example.casacodigo.validator.ExistsId;
import com.example.casacodigo.validator.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

public class NovoLivroDto {

	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "titulo")
	private String titulo;
	@NotBlank @Size(max=500)
	private String resumo;
	private String sumario;
	@NotNull @Min(20)
	private BigDecimal preco;
	@NotNull @Min(100)
	private Integer numeroPaginas;
	@NotBlank @UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao;
	@NotNull @ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Integer idCategoria;
	@NotNull @ExistsId(domainClass = Autor.class, fieldName = "id")
	private Integer idAutor;
	
	public NovoLivroDto(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
			@NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) Integer numeroPaginas, @NotBlank String isbn,
			@NotNull Integer idCategoria, @NotNull Integer idAutor) {
		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}

	/*
	 * Criei esse setter pq o Jackson não estava sendo capaz de dessierializar o json com a data no parâmetro pelo constructor.
	 * Talvez exista um jeito melhor, mas nesse momento eu não sei.
	 */
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao,categoria, autor);
	}
	
	
	
}
