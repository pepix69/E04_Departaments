package com.upiiz.departments.controllers;
import com.upiiz.departments.models.Departamento;
import com.upiiz.departments.services.DepartamentosService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departamentos")
public class DepartamentosController {



    // Requiero inyectar el servicio
    DepartamentosService departamentosService;
    public DepartamentosController(DepartamentosService departamentosService){
        this.departamentosService = departamentosService;
    }

    // Get - Todas las departamentos
    @GetMapping
    public ResponseEntity<List<Departamento>> getDepartamentos(){
        return ResponseEntity.ok(departamentosService.getAllDepartamentos());
    }

    // Get - Departamento por id
    @GetMapping("/{id}")
    public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id){
        return ResponseEntity.ok(departamentosService.getDepartamentoById(id));
    }

    // Post - Crear departamento
    @PostMapping
    public ResponseEntity<Departamento> addDepartamento(@RequestBody Departamento departamento){
        return ResponseEntity.ok(departamentosService.createDepartamento(departamento));
    }

    // Put - Actualizar departamento

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> putDepartamento(@RequestBody Departamento departamento, @PathVariable Long id){
        // Que se requiere antes de actualizarla??
        departamento.setId(id);
        return ResponseEntity.ok(departamentosService.updateDepartamento(departamento));
    }

    // Delete - Eliminar departamento por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartamento(@PathVariable Long id){
        departamentosService.deleteDepartamento(id);
        return ResponseEntity.noContent().build();
    }


}
