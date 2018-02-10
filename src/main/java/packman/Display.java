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
import javax.swing.*;

/**
 *
 * @author Артем
 */
class Display
{
  public static final List<Obj> mapObjects = new ArrayList<>();
  private Timer timer;
  private JFrame frame = new JFrame();
  private Map map = new Map();

  Display()
  {
    frame.setTitle("Packman!");
    frame.setSize(600, 600);
    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    JPanel dip = new JPanel();
    dip.setLayout(new GridLayout(20, 20));

    setMap(dip);

    setMapObjects(mapObjects);

    timer = new javax.swing.Timer(800, e -> {
      nextStep();
//      repaintw(mapObjects);
    });
    timer.start();
    frame.setVisible(true);
    frame.setLayout(new GridLayout(1, 1));
    frame.add(dip);

  }

  private void nextStep()
  {
    for (final Obj object : mapObjects)
    {
      if(object.getName().equals(GameObject.ENEMY))
      {
        ((Enemy)object).generateNextStep(map, mapObjects);

//        if (blocks[object.getX() + x][object.getY() + y].passable && !blocks[object.getX() + x][object.getY() + y].getText().equals("♕"))
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          blocks[object.getX() + x][object.getY() + y].setText("♕");
//
//          object.setX(object.getX() + x);
//          object.setY(object.getY() + y);
//        }
//        else
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          blocks[object.getX()][object.getY()].setText("♕");
//
//          object.setX(object.getX());
//          object.setY(object.getY());
//        }
      }
    }
  }

  private void setMap(JPanel dip)
  {
    map.readMap(null, dip);
  }

  private void setMapObjects(List<Obj> mapObjects)
  {
    Hero hero = new Hero(1, 1);
    hero.setControl(frame);
    mapObjects.add(hero);
    Obj e1 = new Enemy(7, 9);
    mapObjects.add(e1);
    Obj e2 = new Enemy(9, 10);
    mapObjects.add(e2);
    Obj e3 = new Enemy(10, 10);
    mapObjects.add(e3);
    Obj e4 = new Enemy(9, 9);
    mapObjects.add(e4);
  }

//  public void repaintw(List<Obj> objects)
//  {
//    int a = 0;
//    for (int y = 0; y < 20; y++)
//    {
//      for (int i = 0; i < 20; i++)
//      {
//        if (blocks[i][y].proh == false && blocks[i][y].passable == true)
//        {
//          blocks[i][y].setText("*");
//          a = 1;
//          blocks[i][y].setForeground(Color.white);
//
//          if (blocks[i][y].proh == true)
//          {
//            blocks[i][y].setText("");
//          }
//        }
//      }
//    }
//    if (a == 0)
//    {
//      timer.stop();
//      JOptionPane.showMessageDialog(frame, "Игра пройдена!");
//    }
//    Obj hero = null;
//    for (Iterator it = objects.iterator(); it.hasNext(); )
//    {
//      final Obj object = (Obj) it.next();
//
//      if (object.getName().equals("HERO"))
//      {
//        hero = object;
//        Timer timer4 = new javax.swing.Timer(200, new ActionListener()
//        {
//          public void actionPerformed(ActionEvent e)
//          {
//
//            if (blocks[object.getX()][object.getY()].getText().equals("⊕"))
//            {
//              blocks[object.getX()][object.getY()].setText("⊗");
//            }
//            else
//            {
//              blocks[object.getX()][object.getY()].setText("⊕");
//            }
//          }
//        });
//        timer4.start();
//
//        blocks[object.getX()][object.getY()].setForeground(Color.yellow);
//        blocks[object.getX()][object.getY()].proh = true;
//
//      }
//      else
//      {
//        int x = 0;
//        int y = 0;
//
//        if (object.getX() == hero.getX() && object.getY() == hero.getY())
//        {
//          timer.stop();
//          JOptionPane.showMessageDialog(this, "Game over!");
//        }
//
//        if (blocks[object.getX() + x][object.getY() + y].passable == true)
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          blocks[object.getX() + x][object.getY() + y].setText("♕");
//          object.setX(object.getX() + x);
//          object.setY(object.getY() + y);
//
//        }
//        else
//        {
//          blocks[object.getX()][object.getY()].setText("");
//          blocks[object.getX()][object.getY()].setText("♕");
//          blocks[object.getX()][object.getY()].setForeground(Color.white);
//          object.setX(object.getX());
//          object.setY(object.getY());
//
//        }
//      }
//    }
//  }
}
