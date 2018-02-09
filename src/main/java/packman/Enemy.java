/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package packman;

/**
 *
 * @author Артем
 */
public class Enemy implements Obj
{
  private String im = "♕";
  private int x;
  private int y;

  Enemy(int x, int y)
  {
    this.x = x;
    this.y = y;
  }

  public int getX()
  {
    return x;
  }

  public int getY()
  {
    return y;
  }

  public String getIm()
  {
    return im;
  }

  public String getName()
  {
    return "Enemy";
  }

  public void setX(int x)
  {
    this.x = x;
  }

  public void setY(int y)
  {
    this.y = y;
  }
}
