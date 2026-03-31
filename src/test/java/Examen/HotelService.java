package Examen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelService {

    @Test
    void testHabitacionInvalida() {
        Hotel service = new Hotel();
        service.validarHabitacion("212");
    }

    @Test
    @DisplayName("Prueba de nombre inválido")
    void testNombreErroneo() {
        Hotel h = new Hotel();
        h.validarNombre("Mary");
    }

    @Test
    @DisplayName("Confirmar que no acepta fechas de hoy o pasadas")
    void testValidacionFechaVerde() {
        Hotel h = new Hotel();
        assertThrows(IllegalArgumentException.class, () -> {
            h.validarFechaReserva(LocalDate.now().minusDays(1));
        });
    }


    @Test
    @DisplayName("Registro erroneo por campo en blanco")
    void testRegistroErroneo() {
        Hotel h = new Hotel();

        IllegalArgumentException error = assertThrows(IllegalArgumentException.class, () -> {
            h.registrarReserva("202", "  ", LocalDate.now().plusDays(2));
        });

        assertEquals("Debe ingresar los datos requeridos", error.getMessage());
        System.out.println("Mensaje de error capturado: " + error.getMessage());
    }

    @Test
    @DisplayName("Registro exitoso con datos correctos")
    void testRegistroExitoso() {
        Hotel h = new Hotel();

        String resultado = h.registrarReserva("101", "Dayana", LocalDate.now().plusDays(1));

        assertEquals("El registro ha sido exitoso", resultado);
        System.out.println("Resultado exitoso: " + resultado);
    }

}

