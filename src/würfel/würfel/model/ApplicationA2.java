/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package würfel.model;

/**
 *
 * @author nobody
 */
public class ApplicationA2 extends Application {

    private Thread thd;
    private int zahl;
    private boolean gestoppt;

    public ApplicationA2() {
        zahl = 0;
        thd = null;
        gestoppt = false;

    }

    @Override
    public void starteBerechnung() {
        if (this.thd == null) {
            this.thd = new Thread(this);
            this.thd.start();
            System.out.println("Thread gestartet!");
        }
    }

    @Override
    public void run() {
        System.out.println("Führe Aufgabe 2 aus...");
        while (true) {
            berechneZahl();
            if (gestoppt) {
                break;
            } else {
                this.setChanged();
                this.notifyObservers();
            }
        }
        System.out.println("Run gestoppt!");

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
        this.thd = null; //das Deferenzieren allein richt nicht um run zu stoppen?
    }

    @Override
    public void setStart() {
        gestoppt = false;
        if (thd == null){
            starteBerechnung();
        }
    }
}
