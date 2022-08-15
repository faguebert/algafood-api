package com.algaworks.algafood.domain.repository;

import java.util.List;

import com.algaworks.algafood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	Cidade salvar(Cidade cidade);
	Cidade buscar(Long id);
	void remover(Cidade cidade);
	
}
