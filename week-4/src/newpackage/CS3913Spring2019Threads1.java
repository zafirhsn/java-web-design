/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019threads1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Threads1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //MyThread.sema = new Object();
        for (int i=0; i<5; i++)
           new MyThread(i).start();
        /*Thread mine = Thread.currentThread();
        for (int i=0; i<100; i++){
            System.out.println("Main");
            mine.yield();
        }*/
    }
}

class MyThread extends Thread{
    Object sema;
    int id;
    MyThread(int val){
        sema = new Object();
        id=val;
    }
    public void run(){
        printLines();
    }
    public synchronized void printLines(){
        for (int i=0; i<100; i++){
            for (int j=0; j<id; j++)
                System.out.print("\t");
            System.out.println(""+id);
        }
    }
}