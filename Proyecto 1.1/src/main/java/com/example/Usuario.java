package com.example;

public class Usuario {
    private String nombre;
    private String apellido;
    private String Identificacion;
    public Usuario(String nombre, String apellido, String identificacion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.Identificacion = identificacion;
    }
    public Usuario(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getIdentificacion() {
        return Identificacion;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public void setIdentificacion(String identificacion) {
        Identificacion = identificacion;
    }

}
