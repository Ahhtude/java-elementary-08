package polls.ThreadPoolExecutor;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Prime extends Thread{



    public static CopyOnWriteArrayList<Integer> primeList = new CopyOnWriteArrayList<>();


    public int count = 0;

    int start,end;

    public Prime(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public void run() {
        for (int n = start; n<=end; n++) {
            boolean prime = true;
            for (int j = 2; j < n; j++) {
                if (n%j == 0){
                    prime = false;
                    break;
                }
            }

            if (prime){
                count++;
                primeList.add(n);

            }

        }
        System.out.println("From " + start + " to " + end + " result is - " +count);
    }
}

