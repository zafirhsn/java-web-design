/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author Zafir
 */
public class ArrayPractice {
  public static int[] arr;
  
  public static void main(String[] args) {
//    Will be null b/c member variables are intialized
    System.out.println(arr);
    
//    Will be compiling error, b/c local vars not initialized
//    int[] newArr;
//    System.out.println(newArr);
    
    int[] newArr = new int[10];
    for (int i = 0; i < newArr.length; i++) {
      System.out.println(newArr[i]);
    }
     
  }
  
}
