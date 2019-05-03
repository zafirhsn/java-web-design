/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintStream;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
/**
 *
 * @author zafir
 */
public class Clock {

    /**
     * @param args the command line arguments
     */

    static long timestamp;
    static String formatDate;
    static int i;
    static ArrayList<Point> al;
    
//    Get the second value from the the timestamp in order to draw the line at the right angle when beginning
    public static int getSec(long timestamp) {
      Date date = new Date(timestamp / 1000L);
      SimpleDateFormat sdf = new java.text.SimpleDateFormat("ss");
  
      String formattedDate = sdf.format(date);
      System.out.println(formattedDate);

      return(Integer.parseInt(formattedDate));
    }
    
//    Convert timestamp to formatted date string
    public static String timeConvert(long timestamp) {
      Date date = new Date(timestamp / 1000L);
      SimpleDateFormat sdf = new java.text.SimpleDateFormat("HH:mm:ss z");
      sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-5"));
      String formattedDate = sdf.format(date);
      System.out.println(formattedDate);

      return(formattedDate);
    }
    
//    Get timestamp from website
    public static long getTime() {
      try{
        SSLSocketFactory factory =(SSLSocketFactory)SSLSocketFactory.getDefault();
        SSLSocket socket =(SSLSocket)factory.createSocket("nist.time.gov", 443);
        socket.startHandshake();
        PrintStream sout = new PrintStream(socket.getOutputStream());
        Scanner sin = new Scanner(socket.getInputStream());
        sout.print("GET /actualtime.cgi HTTP/1.0\r\nHOST: nist.time.gov\r\n\r\n");

        String tmp;
        while(sin.hasNext()){

            System.out.println(tmp = sin.nextLine());
            if (tmp.indexOf("timestamp") != -1) {
              int sindex = tmp.indexOf('"');
              int eindex = tmp.indexOf('"', sindex + 1);
              System.out.println(sindex);
              System.out.println(eindex);
              System.out.println(tmp.substring(sindex+1, eindex));

              timestamp = Long.parseLong(tmp.substring(sindex+1, eindex));

              return(timestamp);
            }
                
            }
        }
        catch(Exception e){System.out.println("OOpsie: "+e.toString());}
        return(0);
    }
    
    public static void main(String[] args) {
        timestamp = getTime();
        formatDate = timeConvert(timestamp);
        int sec = getSec(timestamp);
        
        i = sec * 6;
        al = new ArrayList<Point>();
        
        JFrame jf = new JFrame("My program");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
//        Special JPanel
        CirclePanel cp = new CirclePanel();
        jf.add(cp);
       
          
        new Thread(){
            public void run(){
                while (true){
                    Clock.i+=6;
                    timestamp += 1000000;
                    formatDate = timeConvert(timestamp);
                    i = getSec(timestamp) * 6;
                    cp.repaint();
                    try {
                        if (i % 720 == 0) {
                          timestamp = getTime();
                          formatDate = timeConvert(timestamp);
                        }
                        System.out.println("sleeping");
                        sleep(1000);

                    } catch (InterruptedException ex) {

                    }

                }
            }
        }.start();
        jf.setVisible(true);
    }
    
}

class CirclePanel extends JPanel{
    
    int r;
    
    CirclePanel(){
        super();
    }
    Point calcLocation(){
        Point p = new Point();
        p.x = (int)(Math.sin(Math.toRadians(Clock.i))*r);
        p.y = (int)(Math.cos(Math.toRadians(Clock.i))*r);
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
        g.drawString(Clock.formatDate,centerX-60,centerY+100);
        
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

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.RED);

        int size=6;
        for (Point p: Clock.al)
            g.fillOval(p.x-size/2,p.y-size/2,size,size);
    }
}

class Point{
    int x;
    int y;
    Point(int newx, int newy){x = newx; y = newy;}
    Point(){this(0,0);}
}