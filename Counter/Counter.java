package Counter;
class Counter {
   private static int count = 0;

    void increment() {
        count++; // Not thread-safe
        System.out.println("Shared count is" + count);
    }
}
