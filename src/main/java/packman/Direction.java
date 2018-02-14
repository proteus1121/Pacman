package packman;

import javafx.util.Pair;

public enum Direction
{
  HOLD(Obj.POSSIBLE_WAYS.get(4)),
  LEFT(Obj.POSSIBLE_WAYS.get(3)),
  RIGHT(Obj.POSSIBLE_WAYS.get(5)),
  UP(Obj.POSSIBLE_WAYS.get(1)),
  DOWN(Obj.POSSIBLE_WAYS.get(7));

  private final Pair<Integer, Integer> point;

  Direction(Pair<Integer, Integer> point)
  {
    this.point = point;
  }

  public Pair<Integer, Integer> getPoint()
  {
    return point;
  }
}
