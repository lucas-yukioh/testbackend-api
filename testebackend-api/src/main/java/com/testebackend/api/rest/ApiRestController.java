package com.testebackend.api.rest;

import java.time.OffsetDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.testebackend.api.entity.Cargo;
import com.testebackend.api.entity.Trilha;
import com.testebackend.api.service.CargoService;
import com.testebackend.api.service.TrilhaService;

@RestController
@RequestMapping("/api")
public class ApiRestController {
	
	private CargoService cargoService;
	private TrilhaService trilhaService;
	
	@Autowired
	public ApiRestController(CargoService cargoService, TrilhaService trilhaService) {
		this.cargoService = cargoService;
		this.trilhaService = trilhaService;
	}
	
	// --------------------- Cargos endpoints ---------------------
	
	@GetMapping("/cargos")
	public List<Cargo> findCargos() {
		return cargoService.findAll();
	}
	
	@GetMapping("/cargos/{id}")
	public Cargo findCargoById(@PathVariable int id) {
		Cargo cargo = cargoService.findById(id);
		
		return cargo;
	}
	
	@PostMapping("/cargos")
	public Cargo addCargo(@Valid @RequestBody Cargo cargo) {
		Trilha trilha = trilhaService.findById(cargo.getTrilha().getId());
		
		cargo.setId(0);
		cargo.setTrilha(trilha);
		cargo.setDataAtualizacao(OffsetDateTime.now());
		
		cargoService.save(cargo);
		
		return cargo;
	}
	
	@PutMapping("/cargos/{id}")
	public Cargo updateCargo(@Valid @RequestBody Cargo cargo, @PathVariable int id) {
		Cargo cargoOld = cargoService.findById(id);
		Trilha trilha = trilhaService.findById(cargo.getTrilha().getId());
		
		cargoOld.setCargoNome(cargo.getCargoNome());
		cargoOld.setTrilha(trilha);
		cargoOld.setCargoMissao(cargo.getCargoMissao());
		cargoOld.setDataAtualizacao(OffsetDateTime.now());
		
		cargoService.save(cargoOld);
		
		return cargoOld;
	}
	
	@DeleteMapping("/cargos/{id}")
	public String deleteCargo(@PathVariable int id) {
		Cargo cargo = cargoService.findById(id);
		
		cargoService.delete(cargo);
		
		return "Cargo deletado: " + id;
	}
	
	// --------------------- Trilhas endpoints ---------------------
	
	@GetMapping("/trilhas")
	public List<Trilha> findTrilhas() {
		return trilhaService.findAll();
	}
	
	@GetMapping("/trilhas/{id}")
	public Trilha findTrilhaById(@PathVariable int id) {
		Trilha trilha = trilhaService.findById(id);
		
		return trilha;
	}
	
	@PostMapping("/trilhas")
	public Trilha addTrilha(@Valid @RequestBody Trilha trilha) {
		trilha.setId(0);
		trilha.setDataAtualizacao(OffsetDateTime.now());
		
		trilhaService.save(trilha);
		
		return trilha;
	}
	
	@PutMapping("/trilhas/{id}")
	public Trilha updateTrilha(@Valid @RequestBody Trilha trilha, @PathVariable int id) {
		Trilha trilhaOld = trilhaService.findById(id);
		
		trilhaOld.setTrilhaNome(trilha.getTrilhaNome());
		trilhaOld.setDiretoria(trilha.getDiretoria());
		trilhaOld.setMissaoFormal(trilha.getMissaoFormal());
		trilhaOld.setMissaoAlternativa(trilha.getMissaoAlternativa());
		trilhaOld.setDataAtualizacao(OffsetDateTime.now());
		
		trilhaService.save(trilhaOld);
		
		return trilhaOld;
	}
	
	@DeleteMapping("/trilhas/{id}")
	public String deleteTrilha(@PathVariable int id) {
		Trilha trilha = trilhaService.findById(id);
		
		trilhaService.delete(trilha);
		
		return "Trilha deletada: " + id;
	}

}
