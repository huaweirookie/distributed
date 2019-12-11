package com.zhunongyun.toalibaba.distributed.concurrent.programming.threadcommunication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 线程通信,执行notifyAll()方法
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadC extends Thread {

    private Object lock;

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("线程ThreadC 开始执行");
                System.out.println("线程ThreadC 开始执行锁对象lock的notifyAll()方法");
                lock.notifyAll();
                System.out.println("线程ThreadC 结束执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}