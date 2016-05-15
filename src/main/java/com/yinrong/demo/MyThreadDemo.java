package com.yinrong.demo;


public class MyThreadDemo {
	public static void main(String[] args) {

		Myrunnable1 r = new Myrunnable1();
	//	Myrunnable1 r2 = new Myrunnable1();
		Thread t1 = new Thread(r);
		Thread t2 = new Thread(r);
		Thread t3 = new Thread(r);
		Thread t4 = new Thread(r);
		Thread t5 = new Thread(r);
		Thread t6 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
	}

	static class Myrunnable1 implements Runnable {
		private int flag;
        private Object object=new Object();
		@Override
		public void run() {
			synchronized (object) {

				flag = 0;
				System.out.println(Thread.currentThread().getName() + "开始打饭"+flag);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				flag = 1;
				System.out.println(Thread.currentThread().getName() + "饭已经打完"
						+ flag);
			}
		}

	}
}


