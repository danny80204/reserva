package com.ejemplo.bicicletas;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Bicicleta bicicleta;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Reserva(Cliente cliente, Bicicleta bicicleta, LocalDate fechaInicio, LocalDate fechaFin) {
        this.cliente = cliente;
        this.bicicleta = bicicleta;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double calcularCosto() {
        long diasReserva = java.time.temporal.ChronoUnit.DAYS.between(fechaInicio, fechaFin);
        double costoPorDia = 10.0; // Costo por día en unidades monetarias
        return diasReserva * costoPorDia;
    }

    public void imprimirRecibo() {
        System.out.println("\nRecibo de Reserva:");
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Documento: " + cliente.getDocumento());
        System.out.println("Teléfono: " + cliente.getTelefono());
        System.out.println("Bicicleta ID: " + bicicleta.getId());
        System.out.println("Modelo: " + bicicleta.getModelo());
        System.out.println("Fecha de Inicio: " + fechaInicio);
        System.out.println("Fecha de Fin: " + fechaFin);
        System.out.println("Costo Total: $" + calcularCosto());
    }
}
