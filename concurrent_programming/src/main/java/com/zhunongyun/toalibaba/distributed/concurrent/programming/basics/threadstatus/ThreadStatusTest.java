package com.zhunongyun.toalibaba.distributed.concurrent.programming.basics.threadstatus;

import java.util.concurrent.TimeUnit;

/**
 * 线程六种状态实现
 */
public class ThreadStatusTest {

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(100);
                } catch (Exception e) {

                }
            }
        }, "Time_Waiting_Thread").start();

        new Thread(() -> {
            while (true) {
                synchronized (ThreadStatusTest.class) {
                    try {
                        ThreadStatusTest.class.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "Waiting_Thread").start();

        new Thread(new BlockedDemo(), "Blocked_Thread_01").start();
        new Thread(new BlockedDemo(), "Blocked_Thread_02").start();
    }

    static class BlockedDemo implements Runnable {

        @Override
        public void run() {
            synchronized (BlockedDemo.class) {
                while (true) {
                    try {
                        TimeUnit.SECONDS.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}