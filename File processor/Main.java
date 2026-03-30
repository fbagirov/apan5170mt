import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        AtomicInteger processedCount = new AtomicInteger(0);
        ConcurrentLinkedQueue<String> processedFiles = new ConcurrentLinkedQueue<>();

        for (int i = 1; i <= 5; i++) {
            executor.execute(new Task(i, processedCount, processedFiles));
        }

        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        System.out.println("\n--- Summary ---");
        System.out.println("Total files processed: " + processedCount.get());
        System.out.println("Processed files: " + processedFiles);
    }
}