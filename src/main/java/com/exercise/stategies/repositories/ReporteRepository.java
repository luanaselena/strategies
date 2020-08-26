package com.exercise.stategies.repositories;

import com.exercise.stategies.entities.Reporte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReporteRepository extends JpaRepository<Reporte, Integer> {
}
