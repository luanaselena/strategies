package com.exercise.stategies.services;

import com.exercise.stategies.dto.AccionDto;

import java.util.List;

public interface IAccionService {

    public List<AccionDto> findAcciones();
    public AccionDto findById(Integer id) throws Exception;
    public AccionDto updateAccion(Integer id, AccionDto accionDto) throws Exception;
    public AccionDto createAccion(AccionDto accionDto);
}
