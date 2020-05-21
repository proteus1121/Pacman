package packman;

import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.tuple.Pair;

public enum Direction
{
  @SerializedName("left_up")
  LEFT_UP(Pair.of(-1, -1)),
  @SerializedName("up")
  UP(Pair.of(0, -1)),
  @SerializedName("right_up")
  RIGHT_UP(Pair.of(1, -1)),

  @SerializedName("left")
  LEFT(Pair.of(-1, 0)),
  @SerializedName("hold")
  HOLD(Pair.of(0, 0)),
  @SerializedName("right")
  RIGHT(Pair.of(1, 0)),

  @SerializedName("left_down")
  LEFT_DOWN(Pair.of(-1, 1)),
  @SerializedName("down")
  DOWN(Pair.of(0, 1)),
  @SerializedName("right_down")
  RIGHT_DOWN(Pair.of(1, 1));

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
