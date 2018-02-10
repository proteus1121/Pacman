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
  private String im = "♕";
  private int x;
  private int y;

  private static final List<Pair<Integer, Integer>> POSSIBLE_WAYS = new ArrayList<Pair<Integer, Integer>>()
  {{
    add(new Pair(-1, 1));
    add(new Pair(0, 1));
    add(new Pair(1, 1));

    add(new Pair(-1, 0));
    add(new Pair(0, 0));
    add(new Pair(1, 0));

    add(new Pair(-1, -1));
    add(new Pair(0, -1));
    add(new Pair(1, -1));
  }};

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
    return im;
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
    int d = random.nextInt(freeWays.size());
    Pair<Integer, Integer> wayToMove = freeWays.get(d);
    setX(x + wayToMove.getKey());
    setY(y + wayToMove.getValue());
  }

  private List<Pair<Integer, Integer>> lookForFreeSpace(Map map, List<Obj> mapObjects)
  {
    return POSSIBLE_WAYS.stream().filter(way -> {
      Block nextBlock = map.getBlocks()[x + way.getKey()][y + way.getKey()];
      return !nextBlock.getStatus().isBusy(nextBlock, mapObjects);
    }).collect(Collectors.toList());
  }
}
