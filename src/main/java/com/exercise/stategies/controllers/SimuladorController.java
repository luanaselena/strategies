package com.exercise.stategies.controllers;

import com.exercise.stategies.dto.SimuladorDto;
import com.exercise.stategies.services.implementation.SimuladorService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estrategias/simuladores")
public class SimuladorController {

    private final SimuladorService simuladorService;

    public SimuladorController(SimuladorService simuladorService) {
        this.simuladorService = simuladorService;
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> updateSimulador(@PathVariable("id") Integer id, @RequestBody SimuladorDto simuladorDto) throws Exception {
        return ResponseEntity.ok(simuladorService.updateSimulador(id, simuladorDto));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createSimulador(@RequestBody SimuladorDto simuladorDto) throws Exception {
        return ResponseEntity.ok(simuladorService.createSimulador(simuladorDto));
    }

    @GetMapping
    public ResponseEntity<?> getSimuladores(){
        return ResponseEntity.ok(simuladorService.findSimuladores());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSimuladorById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(simuladorService.findById(id));
    }

}
