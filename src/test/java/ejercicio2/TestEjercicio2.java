package ejercicio2;

import ejercicio2.conexion.Mail;
import ejercicio2.model.Chek;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestEjercicio2 {

    @Test
    public void TestEncontrarPersonasQueCumplanHoy() {
        var comunicador = new Mail();
        List<String[]> listado = new Chek(comunicador).buscarPersonasQueCumplanHoy();
        assertEquals(listado.size(), 2);

    }


}
