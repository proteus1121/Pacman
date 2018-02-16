/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import javafx.util.Pair;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author Артем
 */
public class Enemy implements Obj
{
  private String view = "♕";
  private int x;
  private int y;

  Enemy(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public String getView()
  {
    return view;
  }

  public GameObject getName()
  {
    return GameObject.ENEMY;
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public void setY(int y)
  {
    this.y = y;
  }

  public void generateNextStep(Map map, List<Obj> mapObjects)
  {
    List<Pair<Integer, Integer>> freeWays = lookForFreeSpace(map, mapObjects);
    Random random = new Random();
    if (!freeWays.isEmpty())
    {
      int d = random.nextInt(freeWays.size());
      Pair<Integer, Integer> wayToMove = freeWays.get(d);
      setX(x + wayToMove.getKey());
      setY(y + wayToMove.getValue());
    }
  }
}
