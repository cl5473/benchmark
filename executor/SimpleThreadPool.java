import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.io.BufferedWriter;


public class SimpleThreadPool {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        int concurrency = Integer.parseInt(System.getProperty("concurrency"));
        int jobs = Integer.parseInt(System.getProperty("jobs"));
        ExecutorService executor = Executors.newFixedThreadPool(concurrency);
        for (int i = 0; i < jobs ; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
          }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        long end = System.currentTimeMillis();
        System.out.println("Finished all threads");
        System.out.println((end - start) / 1000f + "seconds");
    }
}
