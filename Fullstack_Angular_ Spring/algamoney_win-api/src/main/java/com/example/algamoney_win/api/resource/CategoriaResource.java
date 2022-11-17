package com.example.algamoney_win.api.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.algamoney_win.api.model.Categoria;
import com.example.algamoney_win.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias") //mapeamento de URL em porta 80
public class CategoriaResource {
	
	@Autowired //injentando implementação de repositorio.
	private CategoriaRepository categoriaRepository;
	
	@GetMapping
	public ResponseEntity<?> listar (){         // lista de resposta para reposta vazia , em caso de de erro 404 ou 200 em pagina.
		List<Categoria> categorias = categoriaRepository.findAll();
		return !categorias.isEmpty() ? ResponseEntity.ok(categorias) :  ResponseEntity.notFound().build(); 
		// Aplicamos a regra que se a a lista NÃO TIVER VAZIA , SE APLICA A REGRA, se não , aplica se a regra do NOT FOUND --> 400 em status 
		
	}
}
