package com.fatec.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fatec.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer>{

	
}
