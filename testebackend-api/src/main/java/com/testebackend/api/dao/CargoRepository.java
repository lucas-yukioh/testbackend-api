package com.testebackend.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.testebackend.api.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer> {

}
