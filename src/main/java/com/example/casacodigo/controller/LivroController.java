package com.example.casacodigo.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.casacodigo.dto.DetalheSiteLivroResponse;
import com.example.casacodigo.dto.NovoLivroDto;
import com.example.casacodigo.model.Livro;

@RestController
@RequestMapping("/livros")
public class LivroController {
	
	@Autowired
	private EntityManager manager;

	@PostMapping
	@Transactional
	public String postNovoLivro(@RequestBody @Valid NovoLivroDto novoLivroDto) {
		Livro novoLivro = novoLivroDto.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> getListaLivros(){
		List<Livro> livros = manager.createNativeQuery("Select * from livro").getResultList();
		return ResponseEntity.ok(livros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getLivroByid(@PathVariable("id") Integer id) {
		Livro livroBuscado = manager.find(Livro.class, id);
		// O find retorna null - Fazer verificação
		if(livroBuscado==null) {
			return ResponseEntity.notFound().build();
		}
		
		DetalheSiteLivroResponse detalheLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
		return ResponseEntity.ok(detalheLivroResponse);
	}
}
