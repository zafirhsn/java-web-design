/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw3;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * 
 * 
 */

class ButtonGrid extends JPanel implements Runnable, ActionListener {

   private static final int NO_OF_BUTTONS = 8;
   private JButton[] buttons;
   final private Thread thread;
   public ButtonGrid() {
       super();
       setLayout(new GridLayout(4, 2));
       createGrid();
       this.thread = new Thread(this);
       this.thread.start();
   }
   private void createGrid() {
       this.buttons = new JButton[NO_OF_BUTTONS];
       // Add buttons to the panel
       for (int i = 0; i < NO_OF_BUTTONS; i++) {
           this.buttons[i] = new JButton();

           // Add action listener
           this.buttons[i].addActionListener(this);

           // Add button to the panel
           add(this.buttons[i]);
       }

       setColor();
   }

   private void setColor() {
       // Create random object
       Random r = new Random();

       for (int i = 0; i < NO_OF_BUTTONS; i++) {
           if (!this.buttons[i].isSelected()) 
               this.buttons[i].setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
       }
   }

   @Override
   public void actionPerformed(ActionEvent ae) {
       JButton btn = (JButton) ae.getSource();
       if (btn.isSelected())
           btn.setSelected(false);
       else
           btn.setSelected(true);
   }
   @Override
   public void run() {
       try {
           while (true) {
               Thread.sleep(1000);
               setColor();
           }
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
}
public class HW3 extends JFrame {
  
   public HW3() {
       super();
       setSize(300, 400);
       setLocationRelativeTo(null);
       setResizable(false);
   }
   public static void main(String[] args) {
       HW3 changer = new HW3();
       changer.add(new ButtonGrid());
       changer.setVisible(true);
       changer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

