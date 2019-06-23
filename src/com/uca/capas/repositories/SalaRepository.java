package com.uca.capas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Sala;



@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {

}
