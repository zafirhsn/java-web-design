/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019net1;

import java.io.*;
import java.net.*;
import java.util.*;

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
            Socket s = new Socket("www.google.com",80);
            if (s.isConnected()){
                Scanner sin = new Scanner(s.getInputStream());
                PrintStream sout = new PrintStream(s.getOutputStream());
                sout.print("GET / HTTP/1.0\r\n\r\n");
                while (sin.hasNext()){
                    System.out.println(sin.nextLine());
                    System.out.println("HELLO BIATCH");
                }
            }
            else{
                System.out.println("Socket COnnection Failed!");
            }
        }
        catch(IOException e){
            System.out.println("Welp... that didn't work!");
        }
    }
    
}
