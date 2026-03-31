package Examen;

import java.time.LocalDate;

public class Hotel {
    // Habitación check
    public void validarHabitacion(String codigo) {
        if (codigo == null || codigo.isBlank()) {
            throw new IllegalArgumentException("Debe ingresar los campos requeridos");
        }

        if (!codigo.matches("[1-3]\\d{2}")) {
            throw new IllegalArgumentException("Ingrese una habitación válida");
        }
    }

    // Nombre del cliente check
    public void validarNombre(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            throw new IllegalArgumentException("Debe ingresar los campos requeridos");
        }

        if (!nombre.matches("[a-zA-Z]{4,}")) {
            throw new IllegalArgumentException(
                    "Recuerde que el nombre del cliente debe contener al menos cuatro caracteres"
            );
        }
    }

    // Fecha no puede ser mayor
    public void validarFechaReserva(LocalDate fechaReserva) {
        if (fechaReserva == null) {
            throw new IllegalArgumentException("Debe ingresar los campos requeridos");
        }

        if (!fechaReserva.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Debe ingresar una fecha válida");
        }
    }
    public String registrarReserva(String codigo, String nombre, LocalDate fechaReserva) {

        validarHabitacion(codigo);
        validarNombre(nombre);
        validarFechaReserva(fechaReserva);

        return "El registro ha sido exitoso";
    }
}
