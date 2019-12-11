package com.zhunongyun.toalibaba.distributed.concurrent.programming.threadcommunication;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 线程通信,执行wait()方法
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThreadB extends Thread {

    private Object lock;

    @Override
    public void run() {
        synchronized (lock) {
            try {
                System.out.println("线程ThreadB 开始执行");
                System.out.println("线程ThreadB 开始执行锁对象lock的wait()方法");
                lock.wait();
                System.out.println("线程ThreadB 结束执行");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}