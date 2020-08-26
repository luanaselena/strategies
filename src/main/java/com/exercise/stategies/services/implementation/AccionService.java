package com.exercise.stategies.services.implementation;

import com.exercise.stategies.converters.AccionConverter;
import com.exercise.stategies.dto.AccionDto;
import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.entities.Accion;
import com.exercise.stategies.entities.Simulador;
import com.exercise.stategies.repositories.AccionRepository;
import com.exercise.stategies.services.IAccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccionService implements IAccionService {
    private final AccionRepository accionRepository;
    private final AccionConverter accionConverter;

    @Autowired
    public AccionService(AccionRepository accionRepository, AccionConverter accionConverter) {
        this.accionRepository = accionRepository;
        this.accionConverter = accionConverter;
    }

    public List<AccionDto> findAcciones(){
        return accionConverter.convertirListaADto(accionRepository.findAll());
    }

    public AccionDto findById(Integer id) throws Exception {
        Optional<Accion> accionOptional = accionRepository.findById(id);
        if(!accionOptional.isPresent()){
            throw new Exception("Accion no encontrada");
        }
        return accionConverter.convertirAccionADto(accionOptional.get());
    }

    public AccionDto updateAccion(Integer id, AccionDto accionDto) throws Exception {
        Optional<Accion> accionOptional = accionRepository.findById(id);
        if(!accionOptional.isPresent()){
            throw new Exception("Accion no encontrada");
        }
        Accion accion = accionOptional.get();
        accion.setEmpresa(accionDto.getEmpresa());
        accion.setFecha(accionDto.getFecha());
        accion.setPrecio(accionDto.getPrecio());

        return accionConverter.convertirAccionADto(accionRepository.save(accion));
    }

    public AccionDto createAccion(AccionDto accionDto){

        Accion accion = new Accion();
        accion.setPrecio(accionDto.getPrecio());
        accion.setFecha(accionDto.getFecha());
        accion.setEmpresa(accionDto.getEmpresa());

        return accionConverter.convertirAccionADto(accionRepository.save(accion));
    }
}
