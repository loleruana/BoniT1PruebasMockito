package Examen;

public interface ServicioCredito {
    int obtenerScore(String dni);
    boolean tieneDeudasPendientes(String dni);
    double obtenerIngresoMensual(String dni);
}

