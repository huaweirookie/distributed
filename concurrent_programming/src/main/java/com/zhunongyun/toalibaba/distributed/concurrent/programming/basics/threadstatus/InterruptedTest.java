package com.zhunongyun.toalibaba.distributed.concurrent.programming.basics.threadstatus;

public class InterruptedTest {

    public static void main(String[] args) throws InterruptedException {
        Thread.currentThread().interrupt();
        System.out.println("第一次调用Thread.currentThread().interrupt()："
                + Thread.currentThread().isInterrupted());
        System.out.println("第一次调用thread.interrupted()："
                + Thread.currentThread().interrupted());
        System.out.println("第二次调用thread.interrupted()："
                + Thread.currentThread().interrupted());
    }
}