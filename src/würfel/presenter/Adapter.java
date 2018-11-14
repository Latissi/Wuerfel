/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package würfel.presenter;

import java.util.Observable;
import java.util.Observer;
import würfel.model.Application;
import würfel.view.Fenster;

/**
 *
 * @author nobody
 */
public class Adapter implements Observer
{
  private Application model;
  private Fenster view;
  public Adapter(Application model, Fenster view)
  {
    this.view = view;
    this.model = model;
  }
 
  @Override
  public void update(Observable o, Object arg)
  {
    view.getLblNumber().setText(Integer.toString(model.getZahl()));
  }
}
