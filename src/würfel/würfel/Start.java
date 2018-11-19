/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package würfel;

import würfel.model.Application;
import würfel.presenter.Adapter;
import würfel.presenter.Controller;
import würfel.view.Fenster;

/**
 * Builder Class
 *
 * @author nobody
 */
public class Start {

    public Start() {
        Fenster frm = new Fenster();
        Application app = new Application();
        Adapter adp = new Adapter(app, frm);
        Controller cntrl = new Controller(app, frm);
        cntrl.registerEvents();
        adp.registerEvents();
        frm.setVisible(true);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Start();
    }
}
