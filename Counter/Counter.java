package Counter;
class Counter {
    int count = 0;

    void increment() {
        count++; // Not thread-safe
    }
}