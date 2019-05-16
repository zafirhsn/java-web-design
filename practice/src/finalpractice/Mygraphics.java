/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpractice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author Zafir
 */
public class Mygraphics extends JPanel {
  
 
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.setBackground(Color.GREEN);
    
    g.setColor(Color.BLUE);
    g.fillRect(25, 25, 100, 30);
    
    g.setColor(new Color(190,81,215));
    g.fillRect(25, 65, 100, 30);
    
    Point p = new Point(100,200);
    g.drawLine(p.x, p.y, p.x, p.y);
    
    g.drawArc(300, 100, 50, 50, 50, 50 );
    
    g.setColor(Color.RED);
    g.drawString("This is some text", 25, 120);
  
    
  }
  
}

class Zafir {
  
  public static void main(String[] args) {
    JFrame jf = new JFrame("Title");
    jf.setSize(400,400);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    Mygraphics mg = new Mygraphics();
    jf.add(mg);
    jf.setVisible(true);
  }
}
