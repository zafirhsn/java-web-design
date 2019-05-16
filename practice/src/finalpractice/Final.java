/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpractice;

import java.util.ArrayList;
import java.net.*;
import java.util.*;
import java.io.*;
/**
 *
 * @author Zafir
 */
public class Final {
  
  public static void main(String[] args) {
    try {
      ServerSocket server = new ServerSocket(8080);
      Socket s = server.accept();
      
      String body = "<HTML><TITLE>Java Server</TITLE>This web page was sent by our simple <B>Java Server</B></HTML>";
       
      System.out.println("In server...");
      
      PrintStream sout = new PrintStream(s.getOutputStream());
      sout.print("GET / HTTP/1.0\r\n\r\n" + body);

      
      
    } catch(Exception e) {
      System.out.println("Error");
    }
  }
}
