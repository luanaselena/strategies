package com.exercise.stategies.controllers;

import com.exercise.stategies.dto.AccionDto;
import com.exercise.stategies.services.implementation.AccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/estrategias/acciones")

public class AccionController {

    private final AccionService accionService;

    public AccionController(AccionService accionService) {
        this.accionService = accionService;
    }

    @GetMapping
    public ResponseEntity<?> getAcciones(){
        return ResponseEntity.ok(accionService.findAcciones());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(accionService.findById(id));
    }

    @PostMapping("/crear")
    public ResponseEntity<?> createDocument(@RequestBody AccionDto accionDto) throws Exception {
        return ResponseEntity.ok(accionService.createAccion(accionDto));
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<?> updateAccion(@PathVariable("id") Integer id, @RequestBody AccionDto accionDto) throws Exception {
        return ResponseEntity.ok(accionService.updateAccion(id, accionDto));
    }

}
