package com.yinrong.demo;


import java.util.concurrent.locks.ReentrantLock;

public class MyThreadDemo2 {
	public static void main(String[] args) {

		Myrunnable1 r = new Myrunnable1();
		Thread thread1=new Thread(r);
		Thread thread2=new Thread(r);
		Thread thread3=new Thread(r);
		Thread thread4=new Thread(r);
		Thread thread5=new Thread(r);
		Thread thread6=new Thread(r);
		Thread thread7=new Thread(r);
		Thread thread8=new Thread(r);
		Thread thread9=new Thread(r);

    	 thread1.start();
    	 thread2.start();
    	 thread3.start();
    	 thread4.start();
    	 thread5.start();
    	 thread6.start();
    	 thread7.start();
    	 thread8.start();
    	 thread9.start();
    	
    	 
     
	}

	static class Myrunnable1 implements Runnable {
		private int flag;
        private ReentrantLock lock=new ReentrantLock();
		@Override
		public void run() {
			wash();
			dafan();
			eat();
		}

		public  void dafan() {
           lock.lock();
			System.out.println(Thread.currentThread().getName() + "开始打饭");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName() + "饭已经打完");
		   lock.unlock();
		}

		public  void eat() {
			lock.lock();
			System.out.println(Thread.currentThread().getName() +"吃饭..............");
		    lock.unlock();
		}
		public void wash(){
			
			System.out.println(Thread.currentThread().getName()+"洗碗筷");
		}

	}
}
