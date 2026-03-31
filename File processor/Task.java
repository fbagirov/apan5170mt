import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Task implements Runnable {
    private int id;
    private AtomicInteger processedCount;
    private ConcurrentLinkedQueue<String> processedFiles;

    public Task(int id, AtomicInteger processedCount, ConcurrentLinkedQueue<String> processedFiles) {
        this.id = id;
        this.processedCount = processedCount;
        this.processedFiles = processedFiles;
    }

    @Override
    public void run() {
        System.out.println("Task " + id + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // simulate work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String fileName = "file_" + id + ".txt";
        processedFiles.add(fileName);              
        int count = processedCount.incrementAndGet();
        System.out.println("Task " + id + " completed (" + count + " files processed so far)");
    }
}