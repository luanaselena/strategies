package com.exercise.stategies.services.implementation;

import com.exercise.stategies.converters.SimuladorConverter;
import com.exercise.stategies.dto.ReporteDto;
import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.entities.Accion;
import com.exercise.stategies.entities.Simulador;
import com.exercise.stategies.repositories.AccionRepository;
import com.exercise.stategies.repositories.SimuladorRepository;
import com.exercise.stategies.services.ISimuladorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class SimuladorService implements ISimuladorService {

    private final SimuladorRepository simuladorRepository;
    private final AccionRepository accionRepository;
    private final SimuladorConverter simuladorConverter;
    private final ReporteService reporteService;

    @Autowired
    public SimuladorService(SimuladorRepository simuladorRepository, AccionRepository accionRepository, SimuladorConverter simuladorConverter, ReporteService reporteService){
        this.simuladorRepository = simuladorRepository;
        this.accionRepository = accionRepository;
        this.simuladorConverter = simuladorConverter;
        this.reporteService = reporteService;
    }

    public List<SimuladorDto> findSimuladores(){
        return simuladorConverter.convertirListaADto(simuladorRepository.findAll());
    }

    public SimuladorDto findById(Integer id) throws Exception {
        Optional<Simulador> simuladorOptional = simuladorRepository.findById(id);
        if(!simuladorOptional.isPresent()){
            throw new Exception("Simulación no encontrada");
        }
        return simuladorConverter.convertirSimuladorADto(simuladorOptional.get());
    }

    public SimuladorDto updateSimulador(Integer id, SimuladorDto simuladorDto) throws Exception {
        Optional<Simulador> simuladorOptional = simuladorRepository.findById(id);
        if(!simuladorOptional.isPresent()){
            throw new Exception("Simulación no encontrada");
        }
        Simulador simulador = simuladorOptional.get();
        simulador.setMontoInicial(simuladorDto.getMontoInicial());
        simulador.setMontoActual(simuladorDto.getMontoActual());
        simulador.setFechaHasta(simuladorDto.getFechaHasta());
        simulador.setFechaDesde(simuladorDto.getFechaDesde());
        simulador.setAccionesCargadas(simuladorDto.getAccionesCargadas());
        simulador.setAccionesCompradas(simuladorDto.getAccionesCompradas());

        return simuladorConverter.convertirSimuladorADto(simuladorRepository.save(simulador));
    }

    public SimuladorDto createSimulador(SimuladorDto simuladorDto){

        Simulador simulador = new Simulador();
        simulador.setFechaDesde(simuladorDto.getFechaDesde());
        simulador.setFechaHasta(simuladorDto.getFechaHasta());
        simulador.setMontoActual(simulador.getMontoActual());
        simulador.setMontoInicial(simulador.getMontoInicial());
        simulador.setAccionesCargadas(simuladorDto.getAccionesCargadas());
        simulador.setAccionesCompradas(simuladorDto.getAccionesCompradas());

        return simuladorConverter.convertirSimuladorADto(simuladorRepository.save(simulador));
    }

    public void estrategia1(SimuladorDto simuladorDto){
        List<Accion> acciones = accionRepository.findAll();
        List<Accion> accionesObtenidas;

        LocalDate  fecha1 = null;
        LocalDate fecha2 = null;
        float diferenciaCompra, diferenciaVenta, precio1, precio2;
        simuladorDto.setMontoActual(0);
        simuladorDto.setMontoInicial(0);

        for(int i=1; i<acciones.size(); i++){
            fecha1 = LocalDate.parse(acciones.get(i).getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

            for(int j=0; j<i; j++){
                fecha2 = LocalDate.parse(acciones.get(j).getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                //chequear si 2 acciones son de la misma empresa y tienen 1 dia de diferencia

                if((acciones.get(i).getEmpresa().equals(acciones.get(j).getEmpresa())) && (ChronoUnit.DAYS.between(fecha1, fecha2) == 1)){
                    //precio1 corresponde a la accion del dia siguiente y precio2 a la accion del dia anterior
                    precio1 = Float.parseFloat(acciones.get(i).getPrecio());
                    precio2 = Float.parseFloat(acciones.get(j).getPrecio());
                    diferenciaCompra = precio2 / 100;
                    diferenciaVenta = (precio2 * 2) / 100;

                    /*       compra de acciones          */

                    //verificar si la accion del dia siguiente tiene precio minimo 1% menor que el dia anterior
                    if((precio1 - precio2) <= diferenciaCompra){
                        //se suman los 1000 de la inversion por las acciones de una misma empresa
                        simuladorDto.setMontoInicial(simuladorDto.getMontoInicial()+1000);
                        simuladorDto.setMontoActual(simuladorDto.getMontoActual()+1000);
                        //se compran todas las acciones de esa empresa que se puedan con los 1000 invertidos
                        for(Accion accion : acciones){
                            if(accion.getEmpresa().equals(acciones.get(i).getEmpresa())){
                                if(simuladorDto.getMontoActual() > Float.parseFloat(accion.getPrecio())){
                                    //se agrega esa accion a la lista de acciones compradas
                                    simuladorDto.getAccionesCompradas().add(accion);
                                    simuladorDto.setMontoActual(simuladorDto.getMontoActual()-Float.parseFloat(accion.getPrecio()));
                                }
                            }
                        }
                    }

                    /*       venta de acciones          */
                    if((precio1 - precio2) >= diferenciaVenta){
                        accionesObtenidas = simuladorDto.getAccionesCompradas();
                        for(Accion accion : accionesObtenidas){
                            if(accion.getEmpresa().equals(acciones.get(i).getEmpresa())){
                                //se venden todas las acciones compradas de esa empresa
                                simuladorDto.getAccionesCompradas().remove(accion);
                                simuladorDto.setMontoActual(simuladorDto.getMontoActual()+Float.parseFloat(acciones.get(i).getPrecio()));
                            }
                        }
                    }
                }
            }
        }
    }

    public ReporteDto obtenerReporteEstrategia1(SimuladorDto simuladorDto){
        this.estrategia1(simuladorDto);

        List<Accion> acciones = simuladorDto.getAccionesCompradas();
        List<Accion> accionesMasCompradas;
        int cantidadAccion = 0;
        int cantidadAccionMaxima = 0;
        String accionMasComprada = "";

        LocalDate fecha1 = LocalDate.parse(acciones.get(0).getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate fecha2 = LocalDate.parse(acciones.get(acciones.size()-1).getFecha(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        long diasProcesados = ChronoUnit.DAYS.between(fecha1, fecha2);

        for(int i=1; i<acciones.size(); i++){
            for(int j=0; j<i; j++){
                if(acciones.get(i).getEmpresa().equals(acciones.get(j).getEmpresa())){
                    cantidadAccion++;
                }
            }
            if(cantidadAccion > cantidadAccionMaxima){
                cantidadAccionMaxima = cantidadAccion;
                cantidadAccion = 0;
                accionMasComprada = acciones.get(i).getEmpresa();
            }
        }

        ReporteDto reporteDto = new ReporteDto();
        reporteDto.setCantComprasTotales(acciones.size());
        reporteDto.setAccionMasCompradas(accionMasComprada);
        reporteDto.setDiasProcesados(diasProcesados);

        return reporteService.createReporte(reporteDto);

    }

}
