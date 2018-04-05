package packman;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class Map
{
  @Getter
  private Block[][] blocks;

  Map()
  {
  }

  public void readMap(JsonArray mapArray, JPanel dip)
  {
    int colls = mapArray.size();
    int rows = mapArray.get(0).getAsString().length();
    blocks = new Block[rows][colls];
    dip.setLayout(new GridLayout(rows, colls));

    String map = StreamSupport.stream(mapArray.spliterator(), false).map(JsonElement::getAsString).collect(Collectors.joining());
    int z = 0;
    for (int i = 0; i < rows; i++)
    {
      for (int y = 0; y < colls; y++)
      {
        Block n = new Block(map.charAt(z));
        dip.add(n.getView());
        blocks[i][y] = n;
        z++;
      }
    }
  }
}
