package com.uca.capas.service;

import java.util.List;

import com.uca.capas.domain.Sala;

public interface SalaService {

	public List<Sala> findAll();
	
	public Sala findOne(Integer id);
}
