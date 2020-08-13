package com.testebackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testebackend.api.dao.CargoRepository;
import com.testebackend.api.entity.Cargo;

@Service
public class CargoServiceImpl implements CargoService {
	
	private CargoRepository cargoRepository;
	
	@Autowired
	public CargoServiceImpl(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	@Override
	public List<Cargo> findAll() {
		return cargoRepository.findAll();
	}

	@Override
	public Cargo findById(int id) {
		Optional<Cargo> result = cargoRepository.findById(id);
		Cargo cargo = result.isPresent() ? result.get() : null;
		
		if (cargo == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo não encontrado: " + id);
		
		return cargo;
	}

	@Override
	public void save(Cargo cargo) {
		cargoRepository.save(cargo);
	}

	@Override
	public void delete(Cargo cargo) {
		cargoRepository.delete(cargo);
	}

}
