package com.ejemplo.bicicletas;

public class Bicicleta {
    private String id;
    private String modelo;
    private boolean disponible;

    public Bicicleta(String id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.disponible = true; // Todas las bicicletas están disponibles inicialmente
    }

    public String getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}
