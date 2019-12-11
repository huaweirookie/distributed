package com.zhunongyun.toalibaba.distributed.concurrent.programming.basicprinciples;

/**
 * 静态方法(类)同步
 */
public class SynchronizedTest3 {
    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " 方法 method1 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method1 正在执行");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method1 结束执行");
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " 方法 method2 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method2 正在执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method2 结束执行");
    }

    public synchronized void method3() {
        System.out.println(Thread.currentThread().getName() + " 方法 method3 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method3 正在执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method3 结束执行");
    }

    public static void main(String[] args) {
//        test3demo1();
//        test3demo2();
        test3demo3();
    }

    private static void test3demo1() {
        final SynchronizedTest3 test = new SynchronizedTest3();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test.method2();
        }, "thread2").start();
    }

    private static void test3demo2() {
        final SynchronizedTest3 test = new SynchronizedTest3();
        final SynchronizedTest3 test2 = new SynchronizedTest3();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test2.method2();
        }, "thread2").start();
    }

    private static void test3demo3() {
        final SynchronizedTest3 test = new SynchronizedTest3();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test.method3();
        }, "thread2").start();
    }
}