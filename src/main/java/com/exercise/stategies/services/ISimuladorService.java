package com.exercise.stategies.services;

import com.exercise.stategies.dto.SimuladorDto;

import java.util.List;

public interface ISimuladorService {

    public List<SimuladorDto> findSimuladores();
    public SimuladorDto findById(Integer id) throws Exception;
    public SimuladorDto updateSimulador(Integer id, SimuladorDto simuladorDto) throws Exception;
    public SimuladorDto createSimulador(SimuladorDto simuladorDto);
}
