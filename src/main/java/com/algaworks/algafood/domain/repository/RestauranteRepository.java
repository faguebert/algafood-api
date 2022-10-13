package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.Restaurante;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface RestauranteRepository extends CustomJpaRepository<Restaurante, Long>, JpaSpecificationExecutor<Restaurante> {

    @Query("from Restaurante r join r.cozinha join fetch r.formasPagamento")
    List<Restaurante> findAll();
    List<Restaurante> find(String nomeRestaurante, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);
}
