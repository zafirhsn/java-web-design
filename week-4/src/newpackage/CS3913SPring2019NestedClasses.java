/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs3913spring2019nestedclasses;

/**
 *
 * @author dkatz
 */
public class CS3913SPring2019NestedClasses {
    int i;
    public static void main(String[] args) {
        Sclass s = new Sclass();
        s.y=100;
        CS3913SPring2019NestedClasses c2 = new CS3913SPring2019NestedClasses();
        c2.i=100;
        CS3913SPring2019NestedClasses.Sclass.x=10;
    }
    
    void func(){
        java.util.Scanner sin = new java.util.Scanner(System.in);
        final int z;
        System.out.println("Give me a number: ");
        z=sin.nextInt();
        class Inner{
            void innerFunc(){
                System.out.println(z);
                i=z;
            }
        }
    }
    
    static class Sclass{
        static int x;
        int y;
        
    }
    void func2(){
    new AnotherClass(){
        double d;
        void anotherFunc(int newval){
            super.anotherFunc(newval);
            d = 100;
        }
    }.anotherFunc(20);
    }
}

class AnotherClass{
    int x;
    void anotherFunc(int newval){
        x = newval;
    }
}


class Vehicle{
    void loadUpTheFamily(){}
    
}
interface CanPutGasInIt{
    void putGasInIt(double amount);
    boolean isFull();
}

class Car extends Vehicle implements CanPutGasInIt{    
    double gasTank;
    double gasTankCapacity;
    public void putGasInIt(double amount){
        gasTank+=amount;
    }
    public boolean isFull(){
        return gasTank==gasTankCapacity;
    }
}

class GasStation{
    double pumpGas(CanPutGasInIt c){
        double putIn=0;
        while (!c.isFull()){
            c.putGasInIt(1);
            putIn++;
        }
        return putIn;
    }
}