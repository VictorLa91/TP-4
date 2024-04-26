package ejercicio2.model;

import ejercicio2.conexion.Mail;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        var comunicador= new Mail();
        var listadoDePersonas= new Chek(comunicador).buscarPersonasQueCumplanHoy();
        for (String[] txt : listadoDePersonas ) {
           for (String subtxt : txt){
               System.out.println(subtxt);

           }
        }
    }
}