package com.yinrong.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by yinrong on 2016/5/15.
 */
public class MyThread extends Thread{
    private CountDownLatch countDownLatch;
    private Integer time;

    @Override
    public void run() {
        try {
            System.out.println("线程"+this.getName()+"开始");
            this.sleep(time);
            countDownLatch.countDown();
            System.out.println("线程"+this.getName()+"结束");
       //     System.out.println("当前线程"+Thread.currentThread());
            System.out.println("剩余线程数量"+countDownLatch.getCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public MyThread(CountDownLatch countDownLatch, Integer time) {
        this.countDownLatch = countDownLatch;
        this.time = time;
    }


}
