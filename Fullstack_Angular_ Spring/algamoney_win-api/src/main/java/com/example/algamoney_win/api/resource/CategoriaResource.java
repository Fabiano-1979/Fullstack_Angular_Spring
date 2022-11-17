package com.example.algamoney_win.api.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED) //  criação de uma categoria nova : em pagina 201 , de criação. 
	public void criar(@RequestBody Categoria categoria,HttpServletResponse response) {
    Categoria categoriaSalva = categoriaRepository.save(categoria);
    
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(categoriaSalva.getCodigo()).toUri();
    response.setHeader("Location", uri.toASCIIString()); // Recurso criado com descrição em post, para informar o local  e URL em descrição. 
		
		
	}
	
}
