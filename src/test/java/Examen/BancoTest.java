package Examen;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class BancoTest {

    @Test
    void testScoreInsuficiente() {
        ServicioCredito mockServicio = Mockito.mock(ServicioCredito.class);
        PrestamoBancario banco = new PrestamoBancario(mockServicio);

        when(mockServicio.obtenerScore("12345678")).thenReturn(500);

        String resultado = banco.registrarPrestamo("P-001", "12345678", 1000, 12);

        assertEquals("Préstamo registrado con éxito", resultado);
    }

    @Test
    void testPrestamoExitoso() {
        ServicioCredito mockServicio = Mockito.mock(ServicioCredito.class);
        PrestamoBancario banco = new PrestamoBancario(mockServicio);

        when(mockServicio.obtenerScore("87654321")).thenReturn(750);
        when(mockServicio.tieneDeudasPendientes("87654321")).thenReturn(false);
        when(mockServicio.obtenerIngresoMensual("87654321")).thenReturn(5000.0);

        String resultado = banco.registrarPrestamo("P-002", "87654321", 10000, 24);

        assertEquals("Préstamo registrado con éxito", resultado);
    }
}