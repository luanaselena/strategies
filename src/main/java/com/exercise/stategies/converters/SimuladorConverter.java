package com.exercise.stategies.converters;

import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.entities.Simulador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("simuladorConverter")
public class SimuladorConverter {

    public SimuladorDto convertirSimuladorADto(Simulador simulador){
        SimuladorDto simuladorDto = new SimuladorDto();
        simuladorDto.setId(simulador.getId());
        simuladorDto.setAccionesCargadas(simulador.getAccionesCargadas());
        simuladorDto.setAccionesCompradas(simulador.getAccionesCompradas());
        simuladorDto.setFechaDesde(simulador.getFechaDesde());
        simuladorDto.setFechaHasta(simulador.getFechaHasta());
        simuladorDto.setMontoActual(simulador.getMontoActual());
        simuladorDto.setMontoInicial(simulador.getMontoInicial());

        return simuladorDto;
    }

    public List<SimuladorDto> convertirListaADto(List<Simulador> simuladorList){
        List<SimuladorDto> simuladorDtoList = new ArrayList<>();
        for (Simulador simulador: simuladorList) {
            simuladorDtoList.add(convertirSimuladorADto(simulador));
        }
        return simuladorDtoList;

    }
}
