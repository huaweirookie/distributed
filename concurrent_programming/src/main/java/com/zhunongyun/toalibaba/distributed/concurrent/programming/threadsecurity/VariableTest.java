package com.zhunongyun.toalibaba.distributed.concurrent.programming.threadsecurity;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class VariableTest {



    public volatile static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            long i= 0;
            while (!flag) {
                i++;
                if (i % 10000 == 0) {
                    System.out.println("输出结果" + i);
                }
            }
        }).start();

        Thread.sleep(5);

        flag = true;
    }
}
