/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import lombok.Data;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;

/**
 *
 * @author Артем
 */
@Data
public class Hero implements Obj
{
  private String view1 = "⊕";
  private String view2 = "⊗";
  private GameObject name = GameObject.HERO;
  private int x;
  private int y;
  boolean openCloseView = false;
  Direction nextStepDirection = Direction.HOLD;

  Hero(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public String getView()
  {
    String view = openCloseView ? view1 : view2;
    openCloseView = !openCloseView;
    return view;
  }

  protected void setControl(JFrame frame)
  {
    frame.addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        switch (KeyEvent.getKeyText(e.getKeyCode()))
        {
          case "D":
            nextStepDirection = Direction.RIGHT;
            break;
          case "A":
            nextStepDirection = Direction.LEFT;
            break;
          case "S":
            nextStepDirection = Direction.DOWN;
            break;
          case "W":
            nextStepDirection = Direction.UP;
            break;
          default:
            nextStepDirection = Direction.HOLD;
            break;
        }
      }
    });
  }
}
