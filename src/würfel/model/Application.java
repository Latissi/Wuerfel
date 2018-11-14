/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package würfel.model;

import java.util.Observable;

/**
 *
 * @author nobody
 */
public class Application extends Observable implements Runnable
{
  private Thread thd;
  private int zahl;
  private boolean gestoppt;

  public Application()
  {
    zahl = 0;
    thd = null;
    gestoppt = false;

  }

  public void starteBerechnung()
  {
    if (thd == null)
    {
      thd = new Thread(this);
    }
  }

  @Override
  public void run()
  {
    while(true)
    {
      berechneZahl();
      if (gestoppt)
              {
                this.setChanged();
                this.notifyObservers();                                
              }
    }
    
  }
  
  private void berechneZahl()
  {
    zahl = 1 + (int)(Math.random()*6);
    long sleeptime = (long)(1000 + 5000*Math.random());
    try
    {
      Thread.sleep(sleeptime);
    }
    catch (InterruptedException ix)
    {
      System.err.println(ix);
    }
  }

  public int getZahl()
  {
    return this.zahl;
  }
  
  public void setGestoppt()
  {
    gestoppt = false;
  }
}


