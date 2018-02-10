/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package puckman;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Артем
 */
public class Block extends JLabel{
     boolean is;
    boolean proh;
   
    
    
    public Block(char c){
       
        super();
        setOpaque(true);
         setFont(new Font("Serif", Font.PLAIN, 20));
        
   if(c=='='){setBackground(new Color(25, 25, 112));
   is=false;
   }
    if(c=='*'){setBackground(new Color(123 , 104 , 238));is=true;}

    }

    
    
}
