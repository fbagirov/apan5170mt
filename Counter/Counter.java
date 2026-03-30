package Counter;
class Counter {
    int count = 0;

    void increment() {
        count++; // Not thread-safe
    }
}
public class StopCounter { 
   public static void main(String [] args) throws InterruptedException { 
       Counter counter = new Counter(); 
       counter.start(); 

       Thread.sleep(500); 
       counter.stop(); 
   }
}
