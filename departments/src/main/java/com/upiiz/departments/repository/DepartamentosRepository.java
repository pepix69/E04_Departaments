package com.upiiz.departments.repository;

import com.upiiz.departments.models.Departamento;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class DepartamentosRepository {
    // Almacenar en un listado los departamentos: salvar, listar, eliminar, actualizar
    // Generar de manera unica el id para cada departamento

    // Evitar el null pointer exception
    private List<Departamento> departamentos = new ArrayList<Departamento>();
    private AtomicLong id =  new AtomicLong();

    // Post
    public Departamento guardar(Departamento departamento){
        departamento.setId(id.incrementAndGet());
        departamentos.add(departamento);
        return departamento;
    }

    // Get - All
    public List<Departamento> obtenerDepartamentos(){
        return departamentos;
    }

    // Get
    public Departamento obtenerDepartamento(Long id) {
        return departamentos.stream().filter(departamento -> departamento.getId().equals(id)).findFirst().orElse(null);
    }

    // DELETE
    public void eliminar(Long id){
        departamentos.removeIf(departamento -> departamento.getId().equals(id));
    }

    // PUT
    public Departamento actualizar(Departamento departamento){
        eliminar(departamento.getId());
        departamentos.add(departamento);
        return departamento;
    }


}
