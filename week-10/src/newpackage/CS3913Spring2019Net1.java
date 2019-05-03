/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019net1;

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
 * @author dkatz
 */
public class CS3913Spring2019Net1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            SSLSocketFactory factory =(SSLSocketFactory)SSLSocketFactory.getDefault();
            SSLSocket socket =(SSLSocket)factory.createSocket("nist.time.gov", 443);
            socket.startHandshake();
            PrintStream sout = new PrintStream(socket.getOutputStream());
            Scanner sin = new Scanner(socket.getInputStream());
            sout.print("GET /actualtime.cgi HTTP/1.0\r\nHOST: nist.time.gov\r\n\r\n");
            
            String tmp;
            while(sin.hasNext()){
//                tmp = sin.getLine();
                System.out.println(tmp = sin.nextLine());
                if (tmp.indexOf("timestamp") != -1) {
                  int sindex = tmp.indexOf('"');
                  int eindex = tmp.indexOf('"', sindex + 1);
                  System.out.println(sindex);
                  System.out.println(eindex);
                  System.out.println(tmp.substring(17,33));
                  
                  long timestamp = Long.parseLong(tmp.substring(17,33));
                  Date date = new Date(timestamp / 1000L);
                  SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
                  sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
                  String formattedDate = sdf.format(date);
                  System.out.println(formattedDate);

                  SimpleDateFormat sdf1 = new java.text.SimpleDateFormat("ss");
                  String formattedDate1 = sdf1.format(date);
                  System.out.println(formattedDate1);

                  
                  System.out.println("Found the timestamp!");
                }
                
            }
        }
        catch(Exception e){System.out.println("OOpsie: "+e.toString());}
    }
    
}
