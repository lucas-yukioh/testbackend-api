package com.testebackend.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.testebackend.api.dao.TrilhaRepository;
import com.testebackend.api.entity.Trilha;

@Service
public class TrilhaServiceImpl implements TrilhaService {
	
	private TrilhaRepository trilhaRepository;
	
	@Autowired
	public TrilhaServiceImpl(TrilhaRepository trilhaRepository) {
		this.trilhaRepository = trilhaRepository;
	}

	@Override
	public List<Trilha> findAll() {
		return trilhaRepository.findAll();
	}

	@Override
	public Trilha findById(int id) {
		Optional<Trilha> result = trilhaRepository.findById(id);
		Trilha trilha = result.isPresent() ? result.get() : null;
		
		if (trilha == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Trilha não encontrada: " + id);
		
		return trilha;
	}

	@Override
	public void save(Trilha trilha) {
		trilhaRepository.save(trilha);
	}

	@Override
	public void delete(Trilha trilha) {
		if (!trilha.getCargos().isEmpty())
			throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Trilha possui Cargos associados, não pode ser excluída: " + trilha.getId());
		
		trilhaRepository.delete(trilha);
	}

}
