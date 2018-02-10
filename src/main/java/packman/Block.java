package packman;

import lombok.Data;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Артем
 */
@Data
class Block
{
  private boolean isHero;
  private boolean isEnemy;
  private BlockInfo status;
  private JLabel view;
  private int x;
  private int y;

  Block(char c)
  {
    view = new JLabel();
    view.setOpaque(true);
    view.setFont(new Font("Serif", Font.PLAIN, 20));

    if (c == '=')
    {
      view.setBackground(new Color(25, 25, 112));
      status = BlockInfo.WALL;
    }
    if (c == '*')
    {
      view.setBackground(new Color(123, 104, 238));
      status = BlockInfo.POINT;
    }
    if (c == ' ')
    {
      view.setBackground(new Color(123, 104, 238));
      status = BlockInfo.EMPTY;
    }
  }
}
