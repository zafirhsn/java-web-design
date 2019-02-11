/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
// package cs3913spring2019intro1;

import java.util.*;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Intro1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arr = new int[100];
        for (int i=0; i<arr.length; i++)
            arr[i] = i*10;
        int[] temp = new int[arr.length*2];
        for (int i=0; i<arr.length; i++)
            temp[i]=arr[i];
        arr=temp;
        
        String[] test = new String[100];
        for (int i=0; i<100; i++)
            test[i] = new String("Hello world!");
        for (int i=0; i<100; i++)
            System.out.println(test[i].length());
        
        Scanner sin = new Scanner(System.in);
        System.out.print("Enter some number: ");
        int q = sin.nextInt();
        System.out.println("You said: "+q);
        
        System.out.println("5+3="+5+3);
        
        System.out.println(args.length);
        String s;
        s = new String("Daniel Katz");
        System.out.println(s.length());
        
        int x =5;
        int y =2;
        System.out.println(x/y);
        System.out.println(x/2d);
        System.out.println(x/(double)y);
        Integer i = new Integer(15);
        s = "Daniel Katz";
        System.out.println(s);
        System.out.println();
        
        int w = (int)(6/2.);
        double d = 5/2.;
        x=0;
        if (x!=0){
            
        }
        
        
        
    }
    
}
