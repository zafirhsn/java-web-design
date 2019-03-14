/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.util.*;
/**
 *
 * @author Zafir
 */
public class Primitives {
  public static char c;
  public static short s;
  public static long L;
  public static int i; 
  public static float f;
  public static double d;
  public static byte b;
  public static boolean test;
  public static String[] name;
  public static int[] memberArr;
  
  public static void main(String[] args) {
      System.out.println("Hello World");
      System.out.print("Goodbye World");
      System.out.println("Hey, I'm back!");

      System.out.println(c);
      System.out.println(s);
      System.out.println(L);
      System.out.println(i);
      System.out.println(f);
      System.out.println(d);
      System.out.println(b);
      System.out.println(test);
      
      System.out.println(name);
      
      //Local variables are not initialized like member variables
      int[] arr;
//      This will cause an error since arr is not initialized to null
//      System.out.println(arr);
//      This will not cause an error b/c it's a member variable, will be null
      System.out.println(memberArr);
      
      int newd = 100;
//      char newc = Character.toChars(newd);
      System.out.println(((Object) newd).getClass().getSimpleName());
      System.out.println(newd);
      System.out.println("X = "+5+3);
      System.out.println();
      
      String s1 = new String("Daniel");
      String s3 = new String("Katz");
      String[] s2 = {"Daniel", "Zafir", "Razin"};
      
      System.out.println(s1.getClass().getSimpleName());
      System.out.println(s2.getClass().getSimpleName());
      
      swap(s1, s3);
      System.out.println("S1: "+s1+"\nS2: "+s3);
      
      System.out.println((Object)s2[0].getClass().getSimpleName());
      s3 = s1;
      
      s1 = "Hello";
      System.out.println(s3);
      
      System.out.println();
      arr = new int[10];
      int[] otherArr = arr;
      
      for (int i = 0; i < otherArr.length; i++){
        System.out.print(otherArr[i]);
      }
      arr[6] = 23;
      System.out.println();
      for (int i = 0; i < otherArr.length; i++){
        System.out.print(otherArr[i]);
      }
      
      
      float newf = 100L;
//      System.out.println(isEqual);
  }
  
  public static void swap(String s1, String s2) {
    String temp = s1;
    s1 = s2;
    s2 = temp;
  }
}
