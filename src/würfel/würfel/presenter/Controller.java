/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package würfel.presenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import würfel.model.Application;
import würfel.model.ApplicationA1;
import würfel.view.Fenster;

/**
 *
 * @author nobody
 */
public class Controller implements ActionListener {

    private Application model;
    private Fenster view;

    public Controller(Application model, Fenster view) {
        this.view = view;
        this.model = model;
    }

    public void registerEvents() {
        view.getBtnStart().addActionListener(this);
        view.getBtnStopp().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (src == view.getBtnStart()) {
            System.out.println("Start gedrückt!");
            model.setStart();

        }
        if (src == view.getBtnStopp()) {
            System.out.println("Stopp gedrückt!");
            model.setStopp();

        }
    }
}
