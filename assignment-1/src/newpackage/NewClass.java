/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author dkatz
 */
public class NewClass {
  static JFrame jf;
  static JPanel jp;
  static JPanel top;
  static JPanel bottom; 
  static JButton jb;
  static JButton jb2;
  static JButton[] buttonArr;
  static final int NUM_BUTTONS = 8;
  
  public static void main(String[] args) {
    class ButtonPress implements ActionListener {
      public void actionPerformed(ActionEvent ae) {
        JButton theButton = (JButton)ae.getSource();
        for (int i = 0; i < buttonArr.length; i++) {
          if (buttonArr[i] != theButton) {
            int r = (int)(Math.random() * 255 + 1); 
            int g = (int)(Math.random() * 255 + 1); 
            int b = (int)(Math.random() * 255 + 1); 
            
            buttonArr[i].setBackground(new Color(r,g,b));
          }
        }
      }
    }
    
    jf = new JFrame("Assignment 1");
    jf.setSize(600,600);
    jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    jp = new JPanel();
    jp.setLayout(new GridLayout(4,2));
    
    buttonArr = new JButton[NUM_BUTTONS];
    for (int i = 0; i < NUM_BUTTONS; i++) {
      buttonArr[i] = new JButton((""+i));
      buttonArr[i].addActionListener(new ButtonPress());
      jp.add(buttonArr[i]);
    }
    
   
    jf.add(jp);
    jf.setVisible(true);
    
    
    
  }
  
  
}
