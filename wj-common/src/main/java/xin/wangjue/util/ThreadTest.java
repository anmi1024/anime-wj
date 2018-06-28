package xin.wangjue.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {
    private ExecutorService pool = Executors.newFixedThreadPool(2);
    private BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(5);
    private volatile boolean running = true;
    private AtomicInteger atomic = new AtomicInteger(0);
    private Map<Integer,Integer> recodes = new HashMap();

    public static void main(String[] args) {
        ThreadTest threadTest = new ThreadTest();
        threadTest.thread();
    }

    public void thread() {
        while (running) {
            pool.execute(() ->{
                int rand = new Random().nextInt(6);
                try {
                    queue.put(Integer.valueOf(rand));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            pool.execute(() ->{
                try {
                    Integer rand = queue.poll(2, TimeUnit.SECONDS);
                    if (rand != null && running) {
                        int current = atomic.addAndGet(1);
                        recodes.put(current,rand);
                        if (recodes.size() >= 3) {
                            Integer currentRand = recodes.get(current);
                            Integer preRand = recodes.get(current-1);
                            Integer prePreRand = recodes.get(current-2);
                            if (currentRand != null && preRand != null && prePreRand != null) {
                                System.out.println("last 3 times rand :" + prePreRand + "," + preRand + "," + currentRand + "<--- poll queue index :" + (current - 2) + "," + (current - 1) + "," + current);
                                if (prePreRand.intValue() == preRand.intValue() && preRand.intValue() == currentRand.intValue()) {
                                    running = false;
                                    System.out.println("连续三个数相同，程序停止。");
                                }
                            }
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        if (!running) pool.shutdownNow();
    }
}
