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
public class Practice {

  public static void main(String[] args) {
      System.out.println("Hello World");
      System.out.print("Goodbye World");
      System.out.println("Hey, I'm back!");

      int[] arr = new int[10];
      System.out.println(arr);
//        arr = [5,6,7,8,9,10,11,12,13,14];
      arr[0] = 6;

      for (int i = 0; i < arr.length; i++) {
          System.out.println(arr[i]);
      }
      System.out.println(Arrays.asList(arr));
  }
}
