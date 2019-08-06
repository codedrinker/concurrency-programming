package codedrinker.ch03;

/**
 * Created by codedrinker on 2019/7/26.
 */
public class ReorderExample {
    int a = 0;
    int i = -1;
    boolean flag = false;

    public void writer() {
        a = 1;
        flag = true;
    }

    public void reader() {
        if (flag) {
            i = a * a;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int i = 0;
        while (true) {
            final ReorderExample reorderExample = new ReorderExample();
            Thread one = new Thread(new Runnable() {
                public void run() {
                    reorderExample.writer();
                }
            });

            Thread other = new Thread(new Runnable() {
                public void run() {
                    reorderExample.reader();
                }
            });
            one.start();
            other.start();
            one.join();
            other.join();
            if (reorderExample.i == 0) {
                System.out.println("第 " + i + " 次 " + reorderExample.i);
                break;
            } else if (i % 100000 == 0) {
                System.out.println("第 " + i + " 次 " + reorderExample.i);
            }
            i++;
        }
    }
}
