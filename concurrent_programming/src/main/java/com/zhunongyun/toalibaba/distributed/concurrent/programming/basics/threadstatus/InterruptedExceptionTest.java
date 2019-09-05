package com.zhunongyun.toalibaba.distributed.concurrent.programming.basics.threadstatus;

public class InterruptedExceptionTest {

    private static Long i = 0L;

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    if (i > 20000) {
                        throw new InterruptedException();
                    }
                    i++;
                }
            } catch (InterruptedException e) {
                System.out.println("线程终止");
            }
            System.out.println("i = " + i);
        });

        thread.start();
    }
}