package Examen;

import java.time.LocalDate;

public class PrestamoBancario {
    private ServicioCredito servicio;

    public PrestamoBancario(ServicioCredito servicio) {
        this.servicio = servicio;
    }

    public String registrarPrestamo(String codigo, String dni, double monto, int meses) {
        // 1. Validar campos básicos
        if (codigo == null || dni == null || meses < 6 || meses > 60) {
            throw new IllegalArgumentException("Datos de préstamo inválidos");
        }

        // 2. Evaluación crediticia (Usando Mockito)
        if (servicio.obtenerScore(dni) < 600) {
            return "Rechazado: Score insuficiente";
        }

        if (servicio.tieneDeudasPendientes(dni)) {
            return "Rechazado: Cliente con deudas";
        }

        // 3. Capacidad de pago
        double ingreso = servicio.obtenerIngresoMensual(dni);
        double cuota = monto / meses;

        if (cuota > (ingreso * 0.30)) {
            return "Rechazado: Supera capacidad de pago";
        }

        return "Préstamo registrado con éxito";
    }
}
