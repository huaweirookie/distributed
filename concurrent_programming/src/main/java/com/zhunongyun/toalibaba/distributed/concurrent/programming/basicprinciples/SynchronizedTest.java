package com.zhunongyun.toalibaba.distributed.concurrent.programming.basicprinciples;

/**
 * 没有同步的场景
 */
public class SynchronizedTest {
    public void method1() {
        System.out.println(Thread.currentThread().getName() + " 方法 method1 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method1 正在执行");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  方法 method1 结束执行");
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " 方法 method2 开始执行");
        try {
            System.out.println(Thread.currentThread().getName() + " 方法 method2 正在执行");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "  方法 method2 结束执行");
    }

    public static void main(String[] args) {
        final SynchronizedTest synchronizedTest = new SynchronizedTest();

        new Thread(() -> {
            synchronizedTest.method1();
        }, "thread1").start();

        new Thread(() -> {
            synchronizedTest.method2();
        }, "thread2").start();
    }
}