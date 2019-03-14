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
    int[] temp = new int[newArr.length * 2];
    
    for (int i = 0; i < newArr.length; i++) {
      System.out.println(newArr[i]);
    }
    
    newArr = temp;
    System.out.println(newArr);
    System.out.println(temp);
    
    for (int i = 0; i < newArr.length; i++) {
      System.out.print(newArr[i] + " ");
    }
    
    temp[0] = 4;
    System.out.println();
    for (int i = 0; i < newArr.length; i++) {
      System.out.print(newArr[i] + " ");
    }
     
  }
  
}
