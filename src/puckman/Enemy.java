/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puckman;

/**
 *
 * @author Артем
 */
public class Enemy implements Obj{
        String im ;
               
    int x ;
    int y ;
       @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
         return y;
    }

    @Override
    public String getIm() {
       return im;
    }

    @Override
    public String getName() {
       return "Enemy";
    }

    @Override
    public void setX(int x) {
       this.x=x;
    }

    @Override
    public void setY(int y) {
      this.y=y;
    }
}
