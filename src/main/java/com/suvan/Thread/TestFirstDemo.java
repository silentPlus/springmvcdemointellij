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
        /*try {
            MyThread1 myThread1 = new MyThread1();
            myThread1.start();
            myThread1.interrupt();
            System.out.println("是否停止1？ = " + Thread.interrupted());
            System.out.println("是否停止2？ = " + Thread.interrupted());
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");*/
        /*Thread.currentThread().interrupt();
        System.out.println("是否停止1？ = " + Thread.interrupted());
        System.out.println("是否停止2？ = " + Thread.interrupted());*/
        MyThread1 myThread1 = new MyThread1();
        myThread1.setDaemon(true);
        myThread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("离开了");
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

class MyThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 500000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
}
