/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package würfel.model;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fabian
 */
public class ApplicationA3 extends Application {

    private Thread thd;
    private int zahl;
    private boolean gestoppt;

    public ApplicationA3() {
        zahl = 0;
        thd = null;
        gestoppt = false;

    }

    @Override
    public void starteBerechnung() {
        if (thd == null) {
            this.thd = new Thread(this);
            this.thd.start();
            System.out.println("Thread gestartet!");
        }
    }

    @Override
    public synchronized void run() {
        System.out.println("Führe Aufgabe 3 aus...");
        while (true) {
            berechneZahl();
                while (gestoppt) {
                    try {
                        System.out.println("Thread wartet!");
                        wait();
                        System.out.println("Thread läuft weiter!");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ApplicationA3.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            this.setChanged();
            this.notifyObservers();
        }

    }

    private void berechneZahl() {
        zahl = 1 + (int) (Math.random() * 6);
        long sleeptime = (long) (1000 + 3000 * Math.random());
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
    }

    @Override
    public synchronized void setStart() {
        gestoppt = false;
        if (this.thd == null) {
            starteBerechnung();
        } else {
            notifyAll();
            System.out.println("Notify All!");
        }

    }

}
