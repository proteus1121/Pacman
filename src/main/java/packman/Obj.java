/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Артем
 */
public interface Obj
{
  List<Pair<Integer, Integer>> POSSIBLE_WAYS = new ArrayList<Pair<Integer, Integer>>()
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

  int getX();

  int getY();

  void setX(int x);

  void setY(int y);

  GameObject getName();

  String getView();

  void generateNextStep(Map map, List<Obj> mapObjects);

  default List<Pair<Integer, Integer>> lookForFreeSpace(Map map, List<Obj> mapObjects)
  {
    return POSSIBLE_WAYS.stream().filter(way ->
    {
      Block nextBlock = map.getBlocks()[getX() + way.getKey()][getY() + way.getKey()];
      return !nextBlock.getStatus().isBusy(nextBlock, mapObjects);
    }).collect(Collectors.toList());
  }
}
