package com.exercise.stategies.services.implementation;

import com.exercise.stategies.converters.ReporteConverter;
import com.exercise.stategies.dto.ReporteDto;
import com.exercise.stategies.entities.Reporte;
import com.exercise.stategies.repositories.AccionRepository;
import com.exercise.stategies.repositories.ReporteRepository;
import com.exercise.stategies.services.IReporteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReporteService implements IReporteService {

    private final AccionRepository accionRepository;
    private final ReporteRepository reporteRepository;
    private final ReporteConverter reporteConverter;

    @Autowired
    public ReporteService(AccionRepository accionRepository, ReporteRepository reporteRepository, ReporteConverter reporteConverter) {
        this.accionRepository = accionRepository;
        this.reporteRepository = reporteRepository;
        this.reporteConverter = reporteConverter;
    }

    public List<ReporteDto> findReportes(){
        return reporteConverter.convertirListaADto(reporteRepository.findAll());
    }

    public ReporteDto findById(Integer id) throws Exception {
        Optional<Reporte> reporteOptional = reporteRepository.findById(id);
        if(!reporteOptional.isPresent()){
            throw new Exception("Reporte no encontrado");
        }
        return reporteConverter.convertirReporteADto(reporteOptional.get());
    }

    public ReporteDto createReporte(ReporteDto reporteDto){

        Reporte reporte = new Reporte();
        reporte.setAccionMasCompradas(reporteDto.getAccionMasCompradas());
        reporte.setAccionesMasGanancia(reporteDto.getAccionMasGanancia());
        reporte.setCantComprasConGanancia(reporteDto.getCantComprasConGanancia());
        reporte.setCantComprasTotales(reporteDto.getCantComprasTotales());
        reporte.setDiasProcesados(reporteDto.getDiasProcesados());
        reporte.setLucro(reporteDto.getLucro());

        return reporteConverter.convertirReporteADto(reporteRepository.save(reporte));
    }
}
