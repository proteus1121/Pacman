package packman;

import javafx.util.Pair;

public enum Direction
{
  LEFT_UP(new Pair(-1, 1)),
  UP(new Pair(0, 1)),
  RIGHT_UP(new Pair(1, 1)),

  LEFT(new Pair(-1, 0)),
  HOLD(new Pair(0, 0)),
  RIGHT(new Pair(1, 0)),

  LEFT_DOWN(new Pair(-1, -1)),
  DOWN(new Pair(0, -1)),
  RIGHT_DOWN(new Pair(1, -1));

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
