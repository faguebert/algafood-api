package com.algaworks.algafood.api.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.algafood.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;
	
	@GetMapping
	public List<Restaurante> listar(){
		return restauranteRepository.findAll();
	}

	@GetMapping("/por-nome-e-frete")
	public List<Restaurante> restaurantesPorNomeFrete(String nomeRestaurante,
													  BigDecimal taxaFreteInicial,
													  BigDecimal taxaFreteFinal){
		return restauranteRepository.find(nomeRestaurante, taxaFreteInicial, taxaFreteFinal);
	}

	@GetMapping("/com-frete-gratis")
	public List<Restaurante> restaurantesComFreteGratis(String nomeRestaurante){
		var comFreteGratis = new RestauranteComFreteGratisSpec();
		var comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nomeRestaurante);

		return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
	}
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId){
		Optional<Restaurante> restaurante = restauranteRepository.findById(restauranteId);
		
		if(restaurante.isPresent()) {
			return ResponseEntity.ok(restaurante.get());
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante){
		try {
			restaurante = cadastroRestaurante.salvar(restaurante);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(restaurante);
		} catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.badRequest().body(e.getMessage()); 
		}
		
	}
	
	@PutMapping("/{restauranteId}")
	public ResponseEntity<?> atualizar(@PathVariable Long restauranteId, @RequestBody Restaurante restaurante){
		try {
			Optional<Restaurante> restauranteAtual = restauranteRepository.findById(restauranteId);
			
			if(restauranteAtual.isPresent()) {
				BeanUtils.copyProperties(restaurante, restauranteAtual, "id");
				
				Restaurante restauranteAtualizado = cadastroRestaurante.salvar(restauranteAtual.get());
				return ResponseEntity.ok(restauranteAtualizado);
			}
			
			return ResponseEntity.notFound().build();
		} catch (EntidadeNaoEncontradaException e) {
				return ResponseEntity.badRequest().body(e.getMessage());
		}

	}

	@DeleteMapping("{restauranteId}")
	public ResponseEntity<?> excluir(@PathVariable Long restauranteId){
		try {
			cadastroRestaurante.excluir(restauranteId);
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}
	
}
