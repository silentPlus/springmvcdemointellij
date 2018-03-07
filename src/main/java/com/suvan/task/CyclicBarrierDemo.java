package com.suvan.task;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by suvan on 2017/12/13.
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int N = 4;
        // CyclicBarrier barrier = new CyclicBarrier(N);
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("current thread " + Thread.currentThread().getName());
            }
        });
        /*for (int i = 0; i < N; i++) {
            if (i < N - 1) {
                new Writer(barrier).start();
            } else {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }
        }*/
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }

    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("thread " + Thread.currentThread().getName() + " is writing...");
            try {
                Thread.sleep(5000);
                System.out.println("thread" + Thread.currentThread().getName() + " complately write out, waiting others thread...");
                // cyclicBarrier.await();
                cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("all of thread have write out, keep doing next job...");
        }
    }
}
