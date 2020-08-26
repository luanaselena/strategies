package com.exercise.stategies.converters;

import com.exercise.stategies.dto.ReporteDto;
import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.entities.Reporte;
import com.exercise.stategies.entities.Simulador;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("reporteConverter")
public class ReporteConverter {

    public ReporteDto convertirReporteADto(Reporte reporte){
        ReporteDto reporteDto = new ReporteDto();
        reporteDto.setId(reporte.getId());
        reporteDto.setAccionMasCompradas(reporte.getAccionMasCompradas());
        reporteDto.setAccionMasGanancia(reporte.getAccionMasGanancia());
        reporteDto.setCantComprasConGanancia(reporte.getCantComprasConGanancia());
        reporteDto.setCantComprasTotales(reporte.getCantComprasTotales());
        reporteDto.setDiasProcesados(reporte.getDiasProcesados());
        reporteDto.setLucro(reporte.getLucro());
        reporteDto.setId(reporte.getId());

        return reporteDto;
    }

    public List<ReporteDto> convertirListaADto(List<Reporte> reporteList){
        List<ReporteDto> reporteDtoList = new ArrayList<>();
        for (Reporte reporte: reporteList) {
            reporteDtoList.add(convertirReporteADto(reporte));
        }
        return reporteDtoList;

    }
}
