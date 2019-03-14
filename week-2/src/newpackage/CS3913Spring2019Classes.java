package newpackage;


import newpackage.NewClass;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2019Classes {
    static int x;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        //CS3913Spring2019Classes me = new CS3913Spring2019Classes();
        //me.x=20;
        x=20;
        System.out.println(Math.sqrt(25));
        Thing one = new Thing();
        one.test();
        one.test('a','b','c','d');
        Thing two = new Thing();
        one.insideVar=100;
        two.insideVar=200;
        //NewClass n = new NewClass();
        Thing.staticVar=20;
        Thing.staticVar=30;
        System.out.println("one: insideVar:"+one.insideVar+"\tstaticVar"+one.staticVar);
        System.out.println("two: insideVar:"+two.insideVar+"\tstaticVar"+two.staticVar);
        Counter.count=0;
        Counter[] cArr = new Counter[100];
        Thing three = new OtherThing();
        OtherThing four = (OtherThing)three;
        
        for (int i=0; i<100;i++)
            cArr[i] = new Counter();
        
        for (Counter c:cArr)
            c.increment();
        System.out.println("Counter.count="+Counter.count);
        try{
            pitcher();
        }
        catch(Exception e){
            System.out.println("Exception caught: "+e.toString());
        }
        finally{
            System.out.println("You will ALWAYS see this!!!");
            
        }
        
    }//end of main
    static void pitcher() throws Exception{
        throw new Exception("Yikes... bad bad bad");
    }
}//end of CS3913...

class Counter{
    static int count;
    void increment(){
        count++;
    }
}
class Thing{
    int insideVar; //Instance Variable
    static int staticVar;
    Thing(){
        this(42); //Call to Sibling Constructor
    }
    Thing(char c){
        this(42);
        System.out.println(c);
        
    }
    Thing(int newval){
        insideVar=newval;
    }
    
    static void staticTest(){
        System.out.println("Hello world!");
        //insideVar=100; //Cannot access an instance var from a static method!
    }
    
    void test(){
        System.out.println("Hello world!");
    }
    void test(int i){
        System.out.println(i);
    }
    void test(int i, char c){
        System.out.println(c+' '+i);
    }
    void test(Object... oArr){ //Variable-Arity method
        for (Object o: oArr){
            System.out.println(o.toString());
        }
        for (int i = 0; i<oArr.length; i++){
            System.out.println(oArr[i].toString());
        }
    }
}

class OtherThing extends Thing{
    
}