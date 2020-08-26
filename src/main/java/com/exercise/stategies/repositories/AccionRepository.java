package com.exercise.stategies.repositories;

import com.exercise.stategies.entities.Accion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccionRepository extends JpaRepository<Accion, Integer> {
}
