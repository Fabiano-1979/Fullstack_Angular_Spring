package com.example.algamoney_win.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.algamoney_win.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
