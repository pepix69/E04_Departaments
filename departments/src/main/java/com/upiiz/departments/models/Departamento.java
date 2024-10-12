package com.upiiz.departments.models;

public class Departamento {
    private Long id;
    private String nombre;

    public Departamento(){}
    public Departamento(Long id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
