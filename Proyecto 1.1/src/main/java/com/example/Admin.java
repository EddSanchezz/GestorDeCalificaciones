package com.example;

public class Admin extends Usuario{

    private String contra;

    public Admin(String nombre, String contra) {
        super(nombre);
        this.contra = contra;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

}
