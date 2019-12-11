package com.zhunongyun.toalibaba.distributed.concurrent.programming.threadcommunication;

/**
 * 线程通信测试类
 */
public class ThreadCommunicationTest {

    public static void main(String[] args) {
        Object lock = new Object();

        new ThreadA(lock).start();
        new ThreadB(lock).start();
        new ThreadC(lock).start();
    }
}