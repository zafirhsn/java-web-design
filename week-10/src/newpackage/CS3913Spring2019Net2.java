/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019net2;
import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Net2 {

    /**
     * @param args the command line arguments
     */
    static int portNum=7;
    public static void main(String[] args) {
        ServerSocket ss = null;
        int id =0;
        try{
            ss = new ServerSocket(portNum);
            System.out.println("Waiting for a connection on port "+portNum);
            while (true){
                Socket client = ss.accept();
                new ProcessConnection(client,++id).start();
            }
        }catch(IOException e){
            System.out.println("Could not get the socket to listen");
        }
    }
    
}

class ProcessConnection extends Thread{
    Socket client;
    int id;
    ProcessConnection(Socket news, int newid){
        client = news;
        id = newid;
    }
    public void run(){
        try{
            System.out.println("Connection number "+(++id)+"From: "+client.getInetAddress().toString());
            
                Scanner sin = new Scanner(client.getInputStream());
                PrintStream sout = new PrintStream(client.getOutputStream());
                
                sout.print("Welcome to my Echo server!\r\n");
                String line ="";
                while (!line.equalsIgnoreCase("EXIT")){
                    line = sin.nextLine();
                    System.out.println("Client ("+id+") said: "+line);
                    sout.println(line);
                }
                client.close();
                System.out.println("Client ("+id+") disconnected.");
        }
        catch(IOException e){}
    }
}