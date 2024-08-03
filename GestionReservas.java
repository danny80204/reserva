package com.ejemplo.bicicletas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestionReservas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Datos ficticios de clientes y bicicletas
        Cliente cliente = new Cliente("Ana Gómez", "123456789", "5556789");
        List<Bicicleta> bicicletas = new ArrayList<>();
        bicicletas.add(new Bicicleta("B001", "Mountain Bike"));
        bicicletas.add(new Bicicleta("B002", "Road Bike"));

        boolean continuar = true;

        while (continuar) {
            // Selección de bicicleta
            Bicicleta bicicletaSeleccionada = null;
            while (bicicletaSeleccionada == null) {
                System.out.println("Seleccione una bicicleta por ID:");
                for (Bicicleta bici : bicicletas) {
                    if (bici.isDisponible()) {
                        System.out.println("ID: " + bici.getId() + ", Modelo: " + bici.getModelo());
                    }
                }
                String bicicletaId = scanner.nextLine();
                for (Bicicleta bici : bicicletas) {
                    if (bici.getId().equals(bicicletaId) && bici.isDisponible()) {
                        bicicletaSeleccionada = bici;
                        break;
                    }
                }
                if (bicicletaSeleccionada == null) {
                    System.out.println("Bicicleta no disponible o ID incorrecto. Por favor, inténtelo de nuevo.");
                }
            }

            // Datos de la reserva
            System.out.println("Ingrese la fecha de inicio (dd/MM/yyyy): ");
            String fechaInicioStr = scanner.nextLine();
            LocalDate fechaInicio = LocalDate.parse(fechaInicioStr, formatter);

            System.out.println("Ingrese la fecha de fin (dd/MM/yyyy): ");
            String fechaFinStr = scanner.nextLine();
            LocalDate fechaFin = LocalDate.parse(fechaFinStr, formatter);

            Reserva reserva = new Reserva(cliente, bicicletaSeleccionada, fechaInicio, fechaFin);
            bicicletaSeleccionada.setDisponible(false); // Marcar la bicicleta como no disponible

            reserva.imprimirRecibo();

            // Preguntar si el usuario quiere realizar otra reserva
            System.out.println("¿Desea realizar otra reserva? (sí/no): ");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("no")) {
                continuar = false;
            }
        }

        System.out.println("Gracias por usar el sistema de reservas de bicicletas.");
    
}

}


