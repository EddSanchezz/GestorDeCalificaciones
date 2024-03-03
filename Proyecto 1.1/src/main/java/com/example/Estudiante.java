package com.example;

public class Estudiante extends Usuario {
    private int edad;

    public Estudiante(String nombre, String apellido, String identificacion, int edad) {
        super(nombre, apellido, identificacion);
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Object getNumIdentidad() {
        return getIdentificacion();
    }

}
