package com.suvan.task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @描述: 生产者-消费者模式，多对多
 * @作者: suvan
 * @创建日期: 2018-04-09 16:02
 */
public class LinkedBlockingQueueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            ThreadA a = new ThreadA();
            a.setName("A" + (i + 1));
            a.start();
        }

        ThreadB threadB1 = new ThreadB();
        threadB1.setName("B1");
        threadB1.start();
        ThreadB threadB2 = new ThreadB();
        threadB2.setName("B2");
        threadB2.start();
    }
}

class StringQueue {
    private static StringQueue instance;
    public int num = 0;
    private BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

    static {
        instance = new StringQueue();
    }

    private StringQueue(){}

    public static StringQueue getInstance() {
        return instance;
    }

    /**
     * 插入数据，队列满了就等待
     * @param msg
     * @throws InterruptedException
     */
    public void push(String msg) throws InterruptedException{
        blockingQueue.put(msg);
    }

    /**
     * 获取第一条数据，为空返回null
     * @return
     */
    public String poll() {
        return blockingQueue.poll();
    }

    /**
     * 获取第一条数据，为空等待
     * @return
     */
    public String take() throws InterruptedException{
        return blockingQueue.take();
    }
}

class ThreadA extends Thread{
    private static ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                lock.lock();
                StringQueue instance = StringQueue.getInstance();
                System.out.println(Thread.currentThread().getName() + "插入数据msg" + instance.num);
                instance.push("msg" + instance.num++);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (lock.isHeldByCurrentThread()) {
                    lock.unlock();
                }
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class ThreadB extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName() + "=======" + StringQueue.getInstance().take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}