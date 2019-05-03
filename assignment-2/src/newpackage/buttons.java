/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

/**
 *
 *
 */
class setGrid extends JPanel implements Runnable, ActionListener {

   private static final int NUM_BUTTONS = 8;
   private JButton[] buttonArr;
   private Thread thread;
   
   public setGrid() {
       super();
       setLayout(new GridLayout(4, 2));
       
       this.buttonArr = new JButton[NUM_BUTTONS];
       
       for (int i = 0; i < NUM_BUTTONS; i++) {
           this.buttonArr[i] = new JButton();
           this.buttonArr[i].addActionListener(this);
           add(this.buttonArr[i]);
       }
       setColor();
       this.thread = new Thread(this);
       this.thread.start();
   }
   

   private void setColor() {
       // Create random object
       Random rand = new Random();

       for (int i = 0; i < NUM_BUTTONS; i++) {
           if (!this.buttonArr[i].isSelected()) 
               this.buttonArr[i].setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
       }
   }

   public void actionPerformed(ActionEvent ae) {
       JButton btn = (JButton) ae.getSource();
       if (btn.isSelected())
           btn.setSelected(false);
       else
           btn.setSelected(true);
   }

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

public class buttons extends JFrame {
  
   public buttons() {
       super();
       setSize(300, 400);
       setLocationRelativeTo(null);
       setResizable(false);
   }
   
   public static void main(String[] args) {
       buttons changer = new buttons();
       changer.add(new setGrid());
       changer.setVisible(true);
       changer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }
}

