/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puckman;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Артем
 */
public class Display extends JFrame{
     //javax.swing.Timer timer2=null;
      javax.swing.Timer timer=null;
    int stop=0;
    static Block[][] blocks = new Block[20][20];
    public Display(){
    
    
    super( "Packman!" );          
        //AudioInputStream inputStream = null;
        
         //   inputStream = AudioSystem.getAudioInputStream(new File("pacman_chomp.wav"));
         //   Clip clip = AudioSystem.getClip();
         //   clip.open(inputStream);
         //   clip.loop(Clip.LOOP_CONTINUOUSLY);
         //   Thread.sleep(10); // looping as long as this thread is alive
            setSize( 600, 600 );
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            JPanel dip = new JPanel();
            dip.setLayout( new GridLayout(20,20) );    
       // JLabel hero = new JLabel(new ImageIcon("src/puckman/images.png"));
              //  dip.add(hero,0,0);
            String map = "===================="
                       + "=******************="
                       + "=***==***=***==****="
                       + "=***==*=====*==****="
                       + "=******************="
                       + "=**=*****=******=**="
                       + "=**=***=====****=**="
                       + "=*==*=*******=**==*="
                       + "=****=*******=*****="
                       + "===**=*******=***==="
                       + "=******************="
                       + "===**=***=***=***==="
                       + "=****==**=**==*****="
                       + "=****=***=***=*****="
                       + "=****=*=====*=*****="
                       + "=******************="
                       + "=*==*==**=***==*==*="
                       + "=*==*==**=***==*==*="
                       + "=********=*********="
                       + "===================="
                       ;
            int z =0;
            for (int i = 0; i < 20; i++) {
             for (int y = 0; y < 20; y++) {
             Block n = new Block(map.charAt(z));
              dip.add(n,i,y);   
              blocks[i][y]=n;
              z++;
          }
          } final ArrayList<Obj> objects = new   ArrayList();
            final Hero hero = new Hero();
            hero.x=1;
            hero.y=1;
            objects.add(hero);
            Enemy e1 = new Enemy();
            e1.x=7;
            e1.y=9;
            e1.im="♕";
            objects.add(e1);
            Enemy e2 = new Enemy();
            e2.x=9;
            e2.y=10;
            e2.im="♕";
            objects.add(e2);
            Enemy e3 = new Enemy();
            e3.x=10;
            e3.y=10;
            e3.im="♕";
            objects.add(e3);
            Enemy e4 = new Enemy();
            e4.x=9;
            e4.y=9;
            e4.im="♕";
            objects.add(e4);
            addKeyListener(new KeyAdapter() {
       
          public void keyPressed(KeyEvent e) {
            
       if(hero.getName().equals("Hero")){
            
           if(e.getKeyText(e.getKeyCode()).equals("D")){
               
            
               if(blocks[hero.getX()][hero.getY()+1].is==true){
              
                   blocks[hero.getX()][hero.getY()].setText("");
           hero.setY(hero.getY()+1);
               }
              
               }
            
        
                
                
           
           if(e.getKeyText(e.getKeyCode()).equals("A")){
               
               if(blocks[hero.getX()][hero.getY()-1].is==true){
                      blocks[hero.getX()][hero.getY()].setText("");
           hero.setY(hero.getY()-1);
           }}
           if(e.getKeyText(e.getKeyCode()).equals("S")){
               if(blocks[hero.getX()-1][hero.getY()].is==true){
                      blocks[hero.getX()][hero.getY()].setText("");
           hero.setX(hero.getX()-1);
               }
           }
           if(e.getKeyText(e.getKeyCode()).equals("W")){
                if(blocks[hero.getX()+1][hero.getY()].is==true){
                       blocks[hero.getX()][hero.getY()].setText("");
           hero.setX(hero.getX()+1);
                }
                
           } repaintw(objects); 

       }
          }
       
          public void keyReleased(KeyEvent e) {
                       
          }
       
          public void keyTyped(KeyEvent e) {
                       
          }
           
      });   timer = new javax.swing.Timer( 800, new ActionListener()
     {
         public void actionPerformed(ActionEvent e)
         { 
             
       repaintw(objects);
         
          for (Iterator it = objects.iterator(); it.hasNext();) {
                      final Obj object = (Obj) it.next();
                     
                      //blocks[object.getX()][object.getY()].setText(object.getIm());
                      if(object.getName().equals("Hero")){
                          
                         
                      
                          blocks[object.getX()][object.getY()].setForeground(Color.yellow);
                      blocks[object.getX()][object.getY()].proh=true;
                      
                          

                      
                      }
                      else{
                           int x =0;
                          int y = 0;
                          Random random = new Random();
                        int d =  random.nextInt(2);
                        int d1 =  random.nextInt(2);
                        if(d==0){x =1;}
                        if(d==1){x =-1;}
                        if(d1==0){y =1;}
                        if(d1==1){y =-1;} 
                          
                         
                         
                          
                          
                          
                           if(blocks[object.getX()+x][object.getY()+y].is==true){
           blocks[object.getX()][object.getY()].setText("");
           blocks[object.getX()][object.getY()].setForeground(Color.white);
               blocks[object.getX()+x][object.getY()+y].setText("♕");
                  
        object.setX(object.getX()+x);
        object.setY(object.getY()+y);
            }
                           else{
                           blocks[object.getX()][object.getY()].setText("");
                           blocks[object.getX()][object.getY()].setForeground(Color.white);
               blocks[object.getX()][object.getY()].setText("♕");
                  
        object.setX(object.getX());
        object.setY(object.getY()); 
                           }
                          repaintw(objects);    
                         // blocks[object.getX()][object.getY()].setText(object.getIm());
                      }
                      //   System.out.println(i+"_"+y);
                      
         }
       
         }
     } );   timer.start();
            setVisible(true);
            setLayout( new GridLayout(1,1) );
            add(dip);
         
    }
    public void repaintw(ArrayList objects){
        int a = 0;
     for (int y = 0; y < 20; y++) {
           for (int i = 0; i < 20; i++) {
             
                   if(blocks[i][y].proh==false&&blocks[i][y].is==true){
                   blocks[i][y].setText("*");
                    a =1;
                    blocks[i][y].setForeground(Color.white);
                   
                  if(blocks[i][y].proh==true)  {
                  blocks[i][y].setText("");
                  }
                   
               }
           
           
           }}
     if(a==0){timer.stop();JOptionPane.showMessageDialog(this,
    "Игра пройдена!");
}     Obj hero = null ;
     for (Iterator it = objects.iterator(); it.hasNext();) {
                   final Obj object = (Obj) it.next();
                  
                   //blocks[object.getX()][object.getY()].setText(object.getIm());
                   if(object.getName().equals("Hero")){
                       hero=object;
                     Timer  timer4 = new javax.swing.Timer( 200, new ActionListener()
  {
      public void actionPerformed(ActionEvent e)
      { 
                     
                       if(blocks[object.getX()][object.getY()].getText().equals("⊕")){
                       blocks[object.getX()][object.getY()].setText("⊗");}
                       else{blocks[object.getX()][object.getY()].setText("⊕");}
      }});
              timer4.start();         
                       
                       blocks[object.getX()][object.getY()].setForeground(Color.yellow);
                   blocks[object.getX()][object.getY()].proh=true;
                   
                       

                   
                   }
                   else{
                        int x =0;
                       int y = 0;
                     
                     if(object.getX()==hero.getX()&&
                             object.getY()==hero.getY()){
                     timer.stop();JOptionPane.showMessageDialog(this,
    "Game over!");
                     }  
                      
                      
                       
                       
                       
                        if(blocks[object.getX()+x][object.getY()+y].is==true){
        blocks[object.getX()][object.getY()].setText("");
        blocks[object.getX()][object.getY()].setForeground(Color.white);
            blocks[object.getX()+x][object.getY()+y].setText("♕");
     object.setX(object.getX()+x);
     object.setY(object.getY()+y);
        
         }
                        else{
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
