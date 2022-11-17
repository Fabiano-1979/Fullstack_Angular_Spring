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
    public List<Categoria> listar() {
        return categoriaRepository.findAll(); // Voltando para metadado original 
    }
	
}
