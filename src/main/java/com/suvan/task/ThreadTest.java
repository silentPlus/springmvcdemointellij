package com.suvan.task;

/**
 * Created by suvan on 2017/12/22.
 */
public class ThreadTest {
    private static String value;

    public static void main(String[] args) {
        value = "aaa";
        new Runnable(){

            @Override
            public void run() {
                System.out.println(ThreadTest.value);
            }
        }.run();

    }
}
