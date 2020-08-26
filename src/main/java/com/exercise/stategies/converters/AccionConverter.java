package com.exercise.stategies.converters;

import com.exercise.stategies.dto.AccionDto;
import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.entities.Accion;
import com.exercise.stategies.entities.Simulador;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("accionConverter")
public class AccionConverter {

    public AccionDto convertirAccionADto(Accion accion){
        AccionDto accionDto = new AccionDto();
        accionDto.setId(accion.getId());
        accionDto.setEmpresa(accion.getEmpresa());
        accionDto.setFecha(accion.getFecha());
        accionDto.setPrecio(accion.getPrecio());

        return accionDto;
    }

    public List<AccionDto> convertirListaADto(List<Accion> accionList){
        List<AccionDto> accionDtoList = new ArrayList<>();
        for (Accion accion: accionList) {
            accionDtoList.add(convertirAccionADto(accion));
        }
        return accionDtoList;

    }
}
