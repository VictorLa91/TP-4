package ejercicio2.model;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Chek   {
    private Conexion conexion;
    private List<String[]> listado;


    public  Chek(Conexion conexion)   {
        try {
            this.conexion =conexion;
            listado= new Reader().read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String[]> buscarPersonasQueCumplanHoy() {
        List<String[]> cumpleañeros = listado;
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");
        String fechaActualFormateada = fechaActual.format(formatter);
        var tex= "20/4/2024";
        cumpleañeros= filter((fila)->fila[2].equals(fechaActualFormateada));
        for (String[] fila : cumpleañeros) {
            this.conexion.comunicar();
        }

        return cumpleañeros;
    }

    private List<String[]> filter(Predicate<String[]> predicate) {
        List<String[]> results = new ArrayList<String[]>();

        for (String[] fila : listado) {
            if (predicate.test(fila)) {
                results.add(fila);
            }
        }
        return results;
    }
    private List<Map<String, String>> convertirMaps() {
        List<Map<String, String>> output = new ArrayList<Map<String, String>>();

        for (String[] dato : listado) {
            Map<String, String> mapped = new HashMap<String, String>();
            mapped.put("APELLIDO", dato[0]);
            mapped.put("NOMBRE", dato[1]);
            mapped.put("FECHA_NACIMIENTO", dato[2]);
            mapped.put("CORREO", dato[3]);
            output.add(mapped);
        }
        return output;
    }

}
