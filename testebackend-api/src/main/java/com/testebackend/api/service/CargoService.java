package com.testebackend.api.service;

import java.util.List;

import com.testebackend.api.entity.Cargo;

public interface CargoService {

	public List<Cargo> findAll();
	
	public Cargo findById(int id);
	
	public void save(Cargo cargo);
	
	public void delete(Cargo cargo);
	
}
