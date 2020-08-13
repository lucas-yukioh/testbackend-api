package com.testebackend.api.service;

import java.util.List;

import com.testebackend.api.entity.Trilha;

public interface TrilhaService {
	
	public List<Trilha> findAll();
	
	public Trilha findById(int id);
	
	public void save(Trilha trilha);
	
	public void delete(Trilha trilha);
	
}
