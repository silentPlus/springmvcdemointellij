package com.suvan.Thread;

/**
 * @描述:
 * @作者: xuqian
 * @创建日期: 2018-03-20 20:01
 */
public class CountOperate extends Thread {
    public CountOperate() {
        System.out.println("CountOperate--begin");
        System.out.println("Thread.currentThread().getName()=" +
        Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" +
        Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("this.getId()=" + this.getId());
        System.out.println("CountOperate--end");
    }

    @Override
    public void run() {
        System.out.println("run--begin");
        System.out.println("Thread.currentThread().getName()=" +
                Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive()=" +
                Thread.currentThread().isAlive());
        System.out.println("this.getName()=" + this.getName());
        System.out.println("this.isAlive()=" + this.isAlive());
        System.out.println("this.getId()=" + this.getId());
        System.out.println("run--end");
    }

    public static void main(String[] args) {
        CountOperate c = new CountOperate();
        Thread t1 = new Thread(c);
        System.out.println("main begin t1 isAlive=" + t1.isAlive());
        t1.setName("A");
        t1.start();
        System.out.println("main end t1 isAlive=" + t1.isAlive());
    }
}
