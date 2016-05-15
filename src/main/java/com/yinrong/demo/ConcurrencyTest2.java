package com.yinrong.demo;

import com.yinrong.thread.*;
import com.yinrong.thread.MyThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yinrong on 2016/5/15.
 */
public class ConcurrencyTest2 {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        Thread t1=new MyThread(countDownLatch,5000);
        Thread t2=new MyThread(countDownLatch,10000);
        Thread t3=new MyThread(countDownLatch,2000);
        Thread t4=new MyThread(countDownLatch,4000);
        Thread t5=new MyThread(countDownLatch,6000);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        try {
            countDownLatch.await();
            System.out.println("线程都完成运行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
