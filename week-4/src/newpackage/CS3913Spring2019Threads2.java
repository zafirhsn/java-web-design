/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019threads2;

import javax.swing.JFrame;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Threads2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame jf = new JFrame("My little program");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(new Timer());
        jf.setSize(400,300);
        jf.setVisible(true);
    }
    
}
