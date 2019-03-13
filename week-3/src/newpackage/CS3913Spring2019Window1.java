/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019window1;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Window1 {

    /**
     * @param args the command line arguments
     */
    static JFrame jf;
    static JPanel jp;
    static JButton jb;
    public static void main(String[] args) {
        class ButtonPress implements ActionListener{
            public void actionPerformed(ActionEvent ae){
                JButton theButton = (JButton)ae.getSource();
                theButton.setText("Yeah, you pressed me!");
                theButton.setEnabled(false);
            }
        }
        jf = new JFrame("Hello World!");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jb = new JButton("Press Me!");
        jb.addActionListener(new ButtonPress());
        jp = new JPanel();
        jp.add(jb);
        jb = new JButton("Press Me!");
        jb.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JButton theButton = (JButton)ae.getSource();
                theButton.setText("I'm a little teapot!");
                theButton.setEnabled(false);
            }
        });
        jp.add(jb);
        jf.add(jp);
        jf.setVisible(true);
    }
    
    class A{
        int x;
        A(int newx){
            x = newx;
        }
        int getx(){
            return x;
        }
    }
    void func(){
        A a = new A(100);
        A b = new A(100){
            
            @Override
            int getx(){
                return super.getx()+1;
            }
        };
        System.out.println(a.getx());//Prints 100 
        System.out.println(b.getx());//Prints 101
    }
}
