package codedrinker.ch01;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by codedrinker on 2019/8/4.
 */
public class JStackCase {
    public static Executor executor = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        System.out.println("start");
        executor.execute(new Task());
    }

    static class Task implements Runnable {

        public void run() {
            calculate();
        }

        public void calculate() {
            int i = 0;
            while (true) {
                i++;
            }
        }
    }
}
