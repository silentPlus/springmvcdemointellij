package com.suvan.Thread;

/**
 * @描述:
 * @作者: xuqian
 * @创建日期: 2018-03-20 19:14
 */
public class TestFirstDemo extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("MyThread");
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread t1 = new Thread(myThread);
        Thread t2 = new Thread(myThread);
        Thread t3 = new Thread(myThread);
        Thread t4 = new Thread(myThread);
        Thread t5 = new Thread(myThread);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("运行中");
    }
}

class MyThread extends Thread {
    private int i = 5;
    @Override
    public void run() {
        super.run();
        System.out.println("i=" + i-- + " threadName=" + Thread.currentThread().getName());
    }
}
