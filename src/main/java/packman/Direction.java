package packman;

import com.google.gson.annotations.SerializedName;
import javafx.util.Pair;

public enum Direction
{
  @SerializedName("left_up")
  LEFT_UP(new Pair(-1, 1)),
  @SerializedName("up")
  UP(new Pair(0, 1)),
  @SerializedName("right_up")
  RIGHT_UP(new Pair(1, 1)),

  @SerializedName("left")
  LEFT(new Pair(-1, 0)),
  @SerializedName("hold")
  HOLD(new Pair(0, 0)),
  @SerializedName("right")
  RIGHT(new Pair(1, 0)),

  @SerializedName("left_down")
  LEFT_DOWN(new Pair(-1, -1)),
  @SerializedName("down")
  DOWN(new Pair(0, -1)),
  @SerializedName("right_down")
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
