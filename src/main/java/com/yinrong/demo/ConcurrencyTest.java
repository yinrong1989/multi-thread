package com.yinrong.demo;



/**
 * Created by yinrong on 2016/5/15.
 */
/** 多线程与单线程比较**/
public class ConcurrencyTest {
    private static  final long count=1000000000;
    private static void concurrency()throws InterruptedException{
        long starttime=System.currentTimeMillis();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                int a=0;
                for (long i=0;i<count;i++){
                    a+=5;
                }
            }
        };
       Thread thread=new Thread(runnable);
        thread.start();
        int b=0;
        for (long i=0;i<count;i++){
            b--;
        }
        long time = System.currentTimeMillis() - starttime;
            thread.join();

        System.out.println("concurrency:"+time+"ms,b="+b);
        Thread t=new Thread(){
            public void run() {
                for(int i=0;i<10;i++){

                    System.out.println(Thread.currentThread().getName()+ "_____"+i);}

            }
        };
        t.start();

    }
    private static  void serial(){
     Long starttime=System.currentTimeMillis();
        int a=0;
        for (long i=0 ;i<count;i++) {
            a+=5;
        }
        int b=0;
       for (long i=0;i<count;i++){
           b--;
       }
        Long time=System.currentTimeMillis()-starttime;
        System.out.println("serial:"+time+"ms,b="+b);
    }
    public static void main(String[] args) throws InterruptedException {
        concurrency();
        serial();
    }
}
