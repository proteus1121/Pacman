/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Артем
 */
class Display extends JFrame
{
  private static Block[][] blocks = new Block[20][20];
  private Timer timer;
  private final List<Obj> mapObjects = new ArrayList();

  Display()
  {
    super("Packman!");
    setSize(600, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel dip = new JPanel();
    dip.setLayout(new GridLayout(20, 20));

    setMap(dip);

    setMapObjects(mapObjects);

    setControl();

    timer = new javax.swing.Timer(800, new ActionListener()
    {
      public void actionPerformed(ActionEvent e)
      {

        repaintw(mapObjects);

        for (Iterator it = mapObjects.iterator(); it.hasNext(); )
        {
          final Obj object = (Obj) it.next();

          //blocks[object.getX()][object.getY()].setText(object.getIm());
          if (object.getName().equals("Hero"))
          {

            blocks[object.getX()][object.getY()].setForeground(Color.yellow);
            blocks[object.getX()][object.getY()].proh = true;

          }
          else
          {
            int x = 0;
            int y = 0;
            Random random = new Random();
            int d = random.nextInt(2);
            int d1 = random.nextInt(2);
            if (d == 0)
            {
              x = 1;
            }
            if (d == 1)
            {
              x = -1;
            }
            if (d1 == 0)
            {
              y = 1;
            }
            if (d1 == 1)
            {
              y = -1;
            }

            if (blocks[object.getX() + x][object.getY() + y].is == true)
            {
              blocks[object.getX()][object.getY()].setText("");
              blocks[object.getX()][object.getY()].setForeground(Color.white);
              blocks[object.getX() + x][object.getY() + y].setText("♕");

              object.setX(object.getX() + x);
              object.setY(object.getY() + y);
            }
            else
            {
              blocks[object.getX()][object.getY()].setText("");
              blocks[object.getX()][object.getY()].setForeground(Color.white);
              blocks[object.getX()][object.getY()].setText("♕");

              object.setX(object.getX());
              object.setY(object.getY());
            }
            repaintw(mapObjects);
            // blocks[object.getX()][object.getY()].setText(object.getIm());
          }
          //   System.out.println(i+"_"+y);

        }

      }
    });
    timer.start();
    setVisible(true);
    setLayout(new GridLayout(1, 1));
    add(dip);

  }

  private void setControl()
  {
    addKeyListener(new KeyAdapter()
    {
      public void keyPressed(KeyEvent e)
      {
        switch (KeyEvent.getKeyText(e.getKeyCode()))
        {
          case "D":
            if (blocks[hero.getX()][hero.getY() + 1].is)
            {
              blocks[hero.getX()][hero.getY()].setText("");
              hero.setY(hero.getY() + 1);
            }
            break;
          case "A":
            if (blocks[hero.getX()][hero.getY() - 1].is)
            {
              blocks[hero.getX()][hero.getY()].setText("");
              hero.setY(hero.getY() - 1);
            }
            break;
          case "S":
            if (blocks[hero.getX() - 1][hero.getY()].is)
            {
              blocks[hero.getX()][hero.getY()].setText("");
              hero.setX(hero.getX() - 1);
            }
            break;
          case "W":
            if (blocks[hero.getX() + 1][hero.getY()].is)
            {
              blocks[hero.getX()][hero.getY()].setText("");
              hero.setX(hero.getX() + 1);
            }
            break;
        }
        repaintw(mapObjects);
      }
    });
  }

  private void setMap(JPanel dip)
  {
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
        dip.add(n, i, y);
        blocks[i][y] = n;
        z++;
      }
    }
  }

  private void setMapObjects(List<Obj> mapObjects)
  {
    Hero hero = new Hero(1, 1);
    mapObjects.add(hero);
    Enemy e1 = new Enemy(7, 9);
    mapObjects.add(e1);
    Enemy e2 = new Enemy(9, 10);
    mapObjects.add(e2);
    Enemy e3 = new Enemy(10, 10);
    mapObjects.add(e3);
    Enemy e4 = new Enemy(9, 9);
    mapObjects.add(e4);
  }

  public void repaintw(List<Obj> objects)
  {
    int a = 0;
    for (int y = 0; y < 20; y++)
    {
      for (int i = 0; i < 20; i++)
      {

        if (blocks[i][y].proh == false && blocks[i][y].is == true)
        {
          blocks[i][y].setText("*");
          a = 1;
          blocks[i][y].setForeground(Color.white);

          if (blocks[i][y].proh == true)
          {
            blocks[i][y].setText("");
          }

        }

      }
    }
    if (a == 0)
    {
      timer.stop();
      JOptionPane.showMessageDialog(this, "Игра пройдена!");
    }
    Obj hero = null;
    for (Iterator it = objects.iterator(); it.hasNext(); )
    {
      final Obj object = (Obj) it.next();

      //blocks[object.getX()][object.getY()].setText(object.getIm());
      if (object.getName().equals("Hero"))
      {
        hero = object;
        Timer timer4 = new javax.swing.Timer(200, new ActionListener()
        {
          public void actionPerformed(ActionEvent e)
          {

            if (blocks[object.getX()][object.getY()].getText().equals("⊕"))
            {
              blocks[object.getX()][object.getY()].setText("⊗");
            }
            else
            {
              blocks[object.getX()][object.getY()].setText("⊕");
            }
          }
        });
        timer4.start();

        blocks[object.getX()][object.getY()].setForeground(Color.yellow);
        blocks[object.getX()][object.getY()].proh = true;

      }
      else
      {
        int x = 0;
        int y = 0;

        if (object.getX() == hero.getX() && object.getY() == hero.getY())
        {
          timer.stop();
          JOptionPane.showMessageDialog(this, "Game over!");
        }

        if (blocks[object.getX() + x][object.getY() + y].is == true)
        {
          blocks[object.getX()][object.getY()].setText("");
          blocks[object.getX()][object.getY()].setForeground(Color.white);
          blocks[object.getX() + x][object.getY() + y].setText("♕");
          object.setX(object.getX() + x);
          object.setY(object.getY() + y);

        }
        else
        {
          blocks[object.getX()][object.getY()].setText("");
          blocks[object.getX()][object.getY()].setText("♕");
          blocks[object.getX()][object.getY()].setForeground(Color.white);
          object.setX(object.getX());
          object.setY(object.getY());

        }

        // blocks[object.getX()][object.getY()].setText(object.getIm());
      }
      //   System.out.println(i+"_"+y);

    }

  }
}
