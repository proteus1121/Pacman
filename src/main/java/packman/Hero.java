/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import javafx.util.Pair;
import lombok.Data;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

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

  @Override
  public void generateNextStep(Map map, List<Obj> mapObjects)
  {
    List<Pair<Integer, Integer>> freeWays = lookForFreeSpace(map, mapObjects);
    Random random = new Random();
    int d = random.nextInt(freeWays.size());
    Pair<Integer, Integer> wayToMove = freeWays.get(d);
    setX(x + wayToMove.getKey());
    setY(y + wayToMove.getValue());
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
