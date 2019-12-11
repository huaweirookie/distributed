package com.zhunongyun.toalibaba.distributed.concurrent.programming.basicprinciples;

/**
 * 代码块同步
 */
public class SynchronizedTest4 {
    public void method1() {
        System.out.println(Thread.currentThread().getName() + " 方法 method1 开始执行");
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " 方法 method1 正在执行");
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method1 结束执行");
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " 方法 method2 开始执行");
        try {
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " 方法 method2 正在执行");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 方法 method2 结束执行");
    }

    public static void main(String[] args) {
        test4demo1();
//        test4demo2();
    }

    private static void test4demo1() {
        final SynchronizedTest4 test = new SynchronizedTest4();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test.method2();
        }, "thread2").start();
    }

    private static void test4demo2() {
        final SynchronizedTest4 test = new SynchronizedTest4();
        final SynchronizedTest4 test2 = new SynchronizedTest4();

        new Thread(() -> {
            test.method1();
        }, "thread1").start();

        new Thread(() -> {
            test2.method2();
        }, "thread2").start();
    }
}