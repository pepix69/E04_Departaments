package com.upiiz.departments.services;

import com.upiiz.departments.repository.DepartamentosRepository;
import com.upiiz.departments.models.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;

// Se crea una instancia de la clase
@Service
public class DepartamentosService {
    // Requiero inyectar al servicio

    // Requerimos repositorio(Datos - Listado) - Departamento
    DepartamentosRepository departamentosRepository;
    // Constructor

    public DepartamentosService (DepartamentosRepository DepartamentosRepository) {
        this.departamentosRepository = DepartamentosRepository;
    }

    // Get - Todas las departamentos
    public List<Departamento> getAllDepartamentos(){
        return departamentosRepository.obtenerDepartamentos();
    }

    // Get - Departamento por id
    public Departamento getDepartamentoById(Long id){
        return departamentosRepository.obtenerDepartamento(id);
    }

    // Post - Crear departamento
    public Departamento createDepartamento(Departamento departamento){
        return departamentosRepository.guardar(departamento);
    }

    // Put - Actualizar departamento
    public Departamento updateDepartamento(Departamento departamento){
        return departamentosRepository.actualizar(departamento);
    }

    // Delete - Eliminar departamento
    public void deleteDepartamento(Long id){
        departamentosRepository.eliminar(id);
    }


}
