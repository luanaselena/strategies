package com.exercise.stategies.repositories;
import com.exercise.stategies.entities.Simulador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimuladorRepository extends JpaRepository<Simulador, Integer> {
}
