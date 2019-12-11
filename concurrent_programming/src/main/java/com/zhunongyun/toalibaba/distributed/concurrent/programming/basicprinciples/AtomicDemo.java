package com.zhunongyun.toalibaba.distributed.concurrent.programming.basicprinciples;

/**
 * 原子性被破坏
 */
public class AtomicDemo {

    private static Long count = 0L;

    public static void main(String[] args) throws InterruptedException {

        for (int i = 0; i < 10000; i++) {
            new Thread(() -> {
                count++;
            }).start();
        }
        Thread.sleep(5000);
        System.out.println("运行结果: " + count);
    }
}