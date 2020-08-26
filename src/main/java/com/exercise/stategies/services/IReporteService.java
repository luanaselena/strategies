package com.exercise.stategies.services;

import com.exercise.stategies.dto.ReporteDto;

import java.util.List;

public interface IReporteService {

    public List<ReporteDto> findReportes();
    public ReporteDto findById(Integer id) throws Exception;
    public ReporteDto createReporte(ReporteDto reporteDto);
}
