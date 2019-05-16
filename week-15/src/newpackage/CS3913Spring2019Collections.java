/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Collections {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0;i<10;i++){
            al.add(i*10);
        }
        Iterator<Integer> i = al.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        
        System.out.println("*******************************");
        for (Integer var :al){
            System.out.println(var);
        }
        System.out.println("*******************************");
        
        TreeSet<Integer> hs = new TreeSet<Integer>();
        Random r = new Random();
        for (int j=0; j<10; j++)
            hs.add(r.nextInt(100));
        i = hs.iterator();
        int val = i.next();
//        System.out.println(i.next());
        System.out.println(val);
        System.out.println("");
        hs.remove(val);
        hs.add(val);
        i = hs.iterator();
        while (i.hasNext())
            System.out.println(i.next());
        
    }
    
}
