/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Артем
 */
public interface Obj
{
  int getX();

  int getY();

  void setX(int x);

  void setY(int y);

  GameObject getName();

  String getView();

  void generateNextStep(Map map, List<Obj> mapObjects);

  default List<Pair<Integer, Integer>> lookForFreeSpace(Map map, List<Obj> mapObjects)
  {
    return Arrays.stream(Direction.values()).filter(way ->
    {
      Block nextBlock = map.getBlocks()[getX() + way.getPoint().getKey()][getY() + way.getPoint().getKey()];
      return !nextBlock.getStatus().isBusy(nextBlock, mapObjects);
    }).map(Direction::getPoint).collect(Collectors.toList());
  }
}
