package polls.Forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin {
    public static void main(String[] args) {

    Integer res = new ForkJoinPool().invoke(new PrimeForFork(0,1_000_000));
    ForkJoinPool.commonPool().shutdown();
    System.out.println("RESULT IS" + res.intValue());


    }

}
