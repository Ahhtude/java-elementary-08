package polls.PoolExecutor;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadpoolexecutorDemo {

    private static int cores = Runtime.getRuntime().availableProcessors();
    private static List<Prime> list = new ArrayList<>(cores);
    private static int result = 0;

    public synchronized static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number for analysis: ");
        int numbers = scanner.nextInt();
        System.out.println("Enter a amount of threads that your need: ");
        int threads = scanner.nextInt();

        int step = numbers / (threads);

        ExecutorService service = new ThreadPoolExecutor(cores
                , cores
                ,60
                , TimeUnit.SECONDS
                , new ArrayBlockingQueue<Runnable>(threads));

        List<Future> futures = new LinkedList<>();

        for (int i = 0; i < threads; i++) {
            if (i==threads-1){
                list.add(new Prime(i * step, step * (i + 1)));
            }
            list.add(new Prime(i * step, step * (i + 1) - 1));
        }

        for (int i = 0; i < threads; i++) {
            int number = i;

            try {
                Future f = service.submit(() -> {
                    list.get(number).run();
                });
                futures.add(f);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        for (Future future : futures) {
            future.get();
        }
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i).count;
        }

        service.shutdown();
        System.out.println("RESULT IS " + result);


    }
}