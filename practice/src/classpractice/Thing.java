/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classpractice;

/**
 *
 * @author zafir
 */
public class Thing {
  int num;
  
  public static void main(String[] args) {
    System.out.println("Inside main method of the Thing class");
    
    A obj = new A();
    
    A.B obj1 = new A.B();
    obj1.display();
    obj1.num = 5;
   }   
}


interface Drivable {
  
  void getSpeed();
}

class A {
  int num;
  String name;
  
  public void display() {
    System.out.println("I am the A class");
  }
  
  static class B {
    int num;
    String name;
    
    public void display() {
      System.out.println("I am the B class");
    }
  }
}


class Car implements Drivable {
  boolean allWheelDrive;
  int price;
  String name;
  protected String color;
  
  Car() {
    allWheelDrive = true;
    color = "red";
  }
  
  Car(boolean allWheelDrive, int price, String name, String color) {
    this.allWheelDrive = allWheelDrive;
    this.price = price;
    this.name = name;
    this.color = color;
  }
  
  public void getSpeed() {
    System.out.println("I am going 45 mph");
  }
  
  public String getColor() {
    return color; 
  }
  
  public void setColor(String color) {
    this.color = color;
  }
}

class Tesla extends Car {
  
  Tesla() {
    super();
  }
  
  Tesla(boolean allWheelDrive, int price, String name, String color) {
    super(allWheelDrive, price, name, color);
  }
  
//  public String getColor() {
//    return "This is a Tesla";
//  }
}



