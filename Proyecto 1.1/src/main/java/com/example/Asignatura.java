package com.example;

import java.util.ArrayList;
import java.util.Collection;

public class Asignatura {
    private String nombre;
    private String codigo;
    private int capacidadMaxEstudiantes;
    private boolean estadoDeApertura;
    private boolean indicadorHabilitacion;
    private Docente docenteAsignado;
    private ArrayList<ArrayList<Float>> nota = new ArrayList<ArrayList<Float>> ();
    @SuppressWarnings({ "unused", "rawtypes" })
    private Collection estudiante = new ArrayList<Estudiante> ();


    @SuppressWarnings("rawtypes")
    public Asignatura(String nombre, String codigo, int capacidadMaxEstudiantes, boolean estadoDeApertura,
            boolean indicadorHabilitacion, Docente docenteAsignado, ArrayList<ArrayList<Float>> nota, Collection estudiante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.capacidadMaxEstudiantes = capacidadMaxEstudiantes;
        this.estadoDeApertura = estadoDeApertura;
        this.indicadorHabilitacion = indicadorHabilitacion;
        this.docenteAsignado = docenteAsignado;
        this.nota = nota;
        this.estudiante = estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public  int getCapacidadMaxEstudiantes() {
        return capacidadMaxEstudiantes;
    }

    public void setCapacidadMaxEstudiantes(int capacidadMaxEstudiantes) {
        this.capacidadMaxEstudiantes = capacidadMaxEstudiantes;
    }

    public boolean isEstadoDeApertura() {
        return estadoDeApertura;
    }

    public void setEstadoDeApertura(boolean estadoDeApertura) {
        this.estadoDeApertura = estadoDeApertura;
    }

    public boolean isIndicadorHabilitacion() {
        return indicadorHabilitacion;
    }

    public void setIndicadorHabilitacion(boolean indicadorHabilitacion) {
        this.indicadorHabilitacion = indicadorHabilitacion;
    }

    public Docente getDocenteAsignado() {
        return docenteAsignado;
    }

    public void setDocenteAsignado(Docente docenteAsignado) {
        this.docenteAsignado = docenteAsignado;
    }


    public void setNota(@SuppressWarnings("rawtypes") Collection nota) {
        
    }

    @SuppressWarnings("rawtypes")
    public Collection getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(@SuppressWarnings("rawtypes") Collection estudiante) {
        this.estudiante = estudiante;
    }

    public ArrayList<ArrayList<Float>> getListaDeNotas() {
        return nota;
    }
    
    
    
}
