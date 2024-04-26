package ejercicio3.model;

import ejercicio3.UI.RadioCompetition;
import ejercicio3.persistencia.PersistenciaEnBase;

import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
// log exception...
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        var persistencia = new PersistenciaEnBase();
        new RadioCompetition(persistencia);
    }
}
