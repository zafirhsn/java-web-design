/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalpractice;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author Zafir
 */
public class Client {
  
  public static void main(String[] args) {
    
    try {      
      Socket s = new Socket("127.0.0.1", 8080);
      if (s.isConnected()) {
        Scanner sin = new Scanner(s.getInputStream());
        PrintStream sout = new PrintStream(s.getOutputStream());
        sout.print("GET / HTTP/1.0\r\n\r\n");
        while (sin.hasNext()) {
          System.out.println(sin.nextLine());
        }
      }
      
      
    } catch(Exception e) {
      System.out.println("There was an error");
    }
    
  }
  
}
