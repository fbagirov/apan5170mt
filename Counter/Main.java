package Counter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Counter counter = new Counter();

        System.out.println("=== Part 1: Unsafe Counter (Race Condition) ===");

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        long start1 = System.nanoTime();
        t1.start();
        t2.start();
        t1.join(); 
        t2.join();
        long end1 = System.nanoTime();

        System.out.println("Final count : " + counter.count
                + " (expected 2000, may be less due to race condition)");
        System.out.println("Time        : " + (end1 - start1) + " ns");
        System.out.println();
        System.out.println("=== Part 2: Synchronized Counter (Thread-Safe) ===");

        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.incrementSync();
        });

        Thread t4 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.incrementSync();
        });

        long start2 = System.nanoTime();
        t3.start();
        t4.start();
        t3.join();
        t4.join();
        long end2 = System.nanoTime();

        System.out.println("Final count : " + counter.getSyncCount()
                + " (expected 2000)");
        System.out.println("Time        : " + (end2 - start2) + " ns");
        System.out.println();
        
        System.out.println("=== Part 3: AtomicInteger Counter (Thread-Safe) ===");

        Thread t5 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.incrementAtomic();
        });

        Thread t6 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.incrementAtomic();
        });

        long start3 = System.nanoTime();
        t5.start();
        t6.start();
        t5.join();
        t6.join();
        long end3 = System.nanoTime();

        System.out.println("Final count : " + counter.atomicCount.get()
                + " (expected 2000)");
        System.out.println("Time        : " + (end3 - start3) + " ns");
        System.out.println();

}
