package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();
	Cozinha salvar(Cozinha cozinha);
	Cozinha buscar(Long id);
	void remover(Long id);
	
}
