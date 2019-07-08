package polls.PoolExecutor;

public class Prime extends Thread {

    public int count = 0;

    int start, end;

    public Prime(int start, int end) {
        this.start = start;
        this.end = end;
    }


    public void run() {
        for (int n = start; n <= end; n++) {
            boolean prime = true;
            for (int j = 2; j < n; j++) {
                if (n % j == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime) {
                count++;
            }

        }
        System.out.println("From " + start + " to " + end + " result is - " + count);
    }
}

