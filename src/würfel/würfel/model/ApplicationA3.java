/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package würfel.model;

/**
 *
 * @author Fabian
 */
public class ApplicationA3 extends Application{

    private Thread thd;
    private int zahl;
    private boolean gestoppt;

    public ApplicationA3() {
        zahl = 0;
        thd = null;
        gestoppt = false;

    }


    @Override
    public void run() {
        System.out.println("Führe Aufgabe 3 aus...");
        while (true) {
            berechneZahl();
            this.setChanged();
            this.notifyObservers();
        }

    }

    private void berechneZahl() {
        zahl = 1 + (int) (Math.random() * 6);
        long sleeptime = (long) (1000 + 5000 * Math.random());
        try {
            Thread.sleep(sleeptime);
        } catch (InterruptedException ix) {
            System.err.println(ix);
        }
        System.out.println("Zahl berechnet!");
    }

    @Override
    public int getZahl() {
        return this.zahl;
    }

    @Override
    public void setStopp() {
        gestoppt = true;
        this.thd = null;
    }

    @Override
    public void setStart() {
        gestoppt = false;
        starteBerechnung();
    }
    
}
