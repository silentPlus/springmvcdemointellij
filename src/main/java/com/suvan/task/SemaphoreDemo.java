package com.suvan.task;

import java.util.Date;
import java.util.concurrent.Semaphore;

/**
 * Created by suvan on 2017/12/13.
 */
public class SemaphoreDemo {
    public static void main(String[] args) {
        int N = 8;            //工人数
        Semaphore semaphore = new Semaphore(5); //机器数目
        for (int i = 0; i < N; i++) {
            new Worker(i, semaphore).start();
        }
    }

    static class Worker extends Thread {
        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("Worker " + this.num + " is using one machine...");
                Thread.sleep(2000);
                System.out.println("Worker " + this.num + " release machine");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.nanoTime();
                new Date();
            }
        }
    }
}
