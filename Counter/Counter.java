package Counter;
class Counter {
    int count = 0;

    void increment() {
        count++; // Not thread-safe
    }

    private int syncCount = 0;

    public synchronized void incrementSync() {
        syncCount++; 
    }

    public int getSyncCount() {
        return syncCount;
    }

    AtomicInteger atomicCount = new AtomicInteger(0);

    void incrementAtomic() {
        atomicCount.incrementAndGet(); 
    }
}
