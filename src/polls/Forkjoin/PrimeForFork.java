package polls.Forkjoin;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.RecursiveTask;

public class PrimeForFork extends RecursiveTask<Integer> {

    public static CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList();
    int start, end;
    private final int maxdataSize = 100_000;

    public PrimeForFork(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int lenght = end-start;
        int count = 0;

        if (lenght< maxdataSize){
            for (int n = start; n < end; n++) {
                boolean prime = true;
                for (int j = 2; j < n; j++) {
                    if (n % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    count++;
                    list.add(count);
                }
            }

        }
        else{
            PrimeForFork task1 = new PrimeForFork(start, (start+lenght/10)-1);
            PrimeForFork task2 = new PrimeForFork(start+lenght/10,end);
            task1.invoke();
            task2.invoke();
            Integer part2 = task2.compute();
            Integer part1 = task1.join();
            count= part1 + part2;
        }
        System.out.println("From " + start + " to " + end + " result is - " + count);
        return count;
    }


    }

