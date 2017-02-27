/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puckman;

/**
 *
 * @author Артем
 */
public class Hero implements Obj{
    String im = "⊕";
 //             " ******  \n"
  //          +  "*********\n"
  //          +  "****     \n"
  //          +  "****     \n"
  //          +  "*********\n"
   //        +   " ******  \n";
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
        return "Hero";
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
