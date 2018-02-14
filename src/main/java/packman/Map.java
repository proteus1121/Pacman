package packman;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Map
{
  @Getter
  private Block[][] blocks = new Block[20][20];

  Map()
  {
  }

  public void readMap(File mapFile, JPanel dip)
  {
    dip.setLayout(new GridLayout(20, 20));

    String map = "====================" + "=******************=" + "=***==***=***==****=" + "=***==*=====*==****=" + "=******************="
        + "=**=*****=******=**=" + "=**=***=====****=**=" + "=*==*=*******=**==*=" + "=****=*******=*****=" + "===**=*******=***==="
        + "=******************=" + "===**=***=***=***===" + "=****==**=**==*****=" + "=****=***=***=*****=" + "=****=*=====*=*****="
        + "=******************=" + "=*==*==**=***==*==*=" + "=*==*==**=***==*==*=" + "=********=*********=" + "====================";
    int z = 0;
    for (int i = 0; i < 20; i++)
    {
      for (int y = 0; y < 20; y++)
      {
        Block n = new Block(map.charAt(z));
        dip.add(n.getView(), i, y);
        blocks[i][y] = n;
        z++;
      }
    }
  }
}
