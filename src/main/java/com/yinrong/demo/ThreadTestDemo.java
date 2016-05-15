package com.yinrong.demo;



public class ThreadTestDemo {
	public static void main(String[] args) {
      Thread t1=new MyThread();
      MyRunnable r=new MyRunnable();
      Thread t2=new Thread(r);
      t1.start();
      t2.start();
	}
}
