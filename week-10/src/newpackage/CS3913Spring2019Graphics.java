/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Graphics {

    /**
     * @param args the command line arguments
     */
//  Class counter i
    static int i;
    
    static ArrayList<Point> al;
    
    public static void main(String[] args) {
        i=0;
        al = new ArrayList<Point>();
        
        JFrame jf = new JFrame("My program");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        Special JPanel
        CirclePanel cp = new CirclePanel();
        jf.add(cp);
        /*cp.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent m){
                i++;
                cp.repaint();
            }
        });*/
        new Thread(){
            public void run(){
                while (true){
                    CS3913Spring2019Graphics.i+=1;
                    cp.repaint();
                    try {
                        System.out.println("sleeping");
                        sleep(1000/6);
                    } catch (InterruptedException ex) {
                        
                    }
                    
                }
            }
        }.start();
        /*DrawingPanel p = new DrawingPanel();
        JPanel jp = new JPanel();
        JButton jb = new JButton("Clear");
        jb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                al.clear();
                p.repaint();
            }
        
        });
        jp.add(jb);
        jf.setLayout(new BorderLayout());
        jf.add(jb,BorderLayout.SOUTH);
        p.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent m){
                al.add(new Point(m.getX(), m.getY()));
                p.repaint();
            }
        });
        jf.add(p,BorderLayout.CENTER);
        */
        jf.setVisible(true);
    }
    
}
class CirclePanel extends JPanel{
    
    int r;
    
    CirclePanel(){
        super();
        CS3913Spring2019Graphics.i=0;
    }
    Point calcLocation(){
        Point p = new Point();
        p.x = (int)(Math.sin(Math.toRadians(CS3913Spring2019Graphics.i))*r);
        p.y = (int)(Math.cos(Math.toRadians(CS3913Spring2019Graphics.i))*r);
        return p;
    }
    protected void paintComponent(Graphics g){
//      Paint the rectangle white
        int height = this.getSize().height;
        int width = this.getSize().width;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
      
        
        r = height/2;
        int centerX = width/2;
        int centerY = height/2;
        int startX = width/2;
        int startY = 0;
        Point p = calcLocation();
        g.setColor(Color.BLACK);
        g.drawLine(centerX, centerY, centerX+p.x, centerY-p.y);
        g.drawString(""+CS3913Spring2019Graphics.i,centerX,centerY+100);
        
    }
}
class DrawingPanel extends JPanel{
    DrawingPanel(){
        super();
    }
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int height = this.getSize().height;
        int width = this.getSize().width;
        //Font f = g.getFont().deriveFont((float)45);
        //g.setFont(f);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.RED);
        //g.setColor(Color.RED);
        int size=6;
        for (Point p: CS3913Spring2019Graphics.al)
            g.fillOval(p.x-size/2,p.y-size/2,size,size);
        //g.setColor(Color.BLACK);
        //g.drawLine(0,0,width,height);
        //g.drawLine(0,height,width,0);
        //i++;
    }
}

class Point{
    int x;
    int y;
    Point(int newx, int newy){x = newx; y = newy;}
    Point(){this(0,0);}
}