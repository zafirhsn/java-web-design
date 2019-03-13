/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019window2;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Window2 {

    /**
     * @param args the command line arguments
     */
    static PressCounter count;
    static JLabel iLabel;
    static JLabel upLabel;
    static JLabel downLabel;
    static JLabel pressLabel;
    static JButton upButton;
    static JButton downButton;
    public static void main(String[] args) {
        count = new PressCounter();
        JFrame jf = new JFrame("Welcome to my program");
        jf.setSize(800,800);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel inner = new JPanel();
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        inner.setLayout(new BorderLayout());
        top.setLayout(new GridLayout(6,3));
        bottom.setLayout(new GridLayout(3,5));
        inner.add(top,BorderLayout.NORTH);
        inner.add(bottom,BorderLayout.SOUTH);
        upButton = new JButton("UP");
        upButton.addActionListener(new ButtonListener());
        downButton = new JButton("DOWN");
        downButton.addActionListener(new ButtonListener());
        iLabel = new JLabel("<HTML><BODY><H1>i=0");
        upLabel = new JLabel("Up=0");
        downLabel = new JLabel("down=0");
        pressLabel = new JLabel("Presses=0");
        uglyTopFunc(top);
        uglyBottomFunc(bottom);
        jf.add(inner);
        jf.setVisible(true);
    }
    static void uglyTopFunc(JPanel jp){
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(iLabel);
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(upLabel);
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(downLabel);
        jp.add(new JLabel(""));
        jp.add(new JLabel(""));
        jp.add(pressLabel);
    }
    static void uglyBottomFunc(JPanel jp){
        for (int i=0; i<6; i++)
            jp.add(new JLabel(""));
        jp.add(upButton);
        jp.add(new JLabel(""));
        jp.add(downButton);
    }
    static class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton action = (JButton)e.getSource();
            if (action==upButton){
                count.i++;
                count.ups++;
            }
            else{
                count.i--;
                count.downs++;
            }
            iLabel.setText("<HTML><BODY><H1>i="+count.i);
            upLabel.setText("Up="+count.ups);
            downLabel.setText("Down="+count.downs);
            pressLabel.setText("Presses="+(count.downs+count.ups));
        }
        
    }

    static class PressCounter{
        int i;
        int ups;
        int downs;
        PressCounter(){
            i = 0;
            ups=0;
            downs=0;
        }
    }
}