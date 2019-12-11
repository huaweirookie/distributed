package com.zhunongyun.toalibaba.distributed.concurrent.programming.basicprinciples;

/**
 * 普通方法同步
 */
public class SynchronizedTest2 {
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " 方法 method1 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method1 正在执行");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method1 结束执行");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " 方法 method2 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method2 正在执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method2 结束执行");
    }

    public void method3() {
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
//        test2demo1();
//        test2demo2();
        test2demo3();
    }

    private static void test2demo1() {
        final SynchronizedTest2 test = new SynchronizedTest2();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test.method2();
        }, "thread2").start();
    }

    private static void test2demo2() {
        final SynchronizedTest2 test = new SynchronizedTest2();
        final SynchronizedTest2 test2 = new SynchronizedTest2();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test2.method2();
        }, "thread2").start();
    }

    private static void test2demo3() {
        final SynchronizedTest2 test = new SynchronizedTest2();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test.method3();
        }, "thread2").start();
    }
}