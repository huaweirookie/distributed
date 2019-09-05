package com.zhunongyun.toalibaba.distributed.concurrent.programming.basics.threadstatus;

import java.util.concurrent.TimeUnit;

public class InterruptTest {

    private static long i = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                i++;
            }
            System.out.println("i = " + i);
        });

        thread.start();

        TimeUnit.SECONDS.sleep(1);

        // 把线程的IsInterrupted设置成true
        thread.interrupt();
    }
}