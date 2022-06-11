package com.xx.thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lsr
 * @create 2022-06-11 21:38
 * 线程同步：使用lock方法
 */
class Window05 implements Runnable{
    private int tickets = 100;
    private ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();    //加锁
                if(tickets>0){
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName()+":"+tickets);
                    tickets--;
                }
                else
                    break;
            }finally {
                lock.unlock();  //解锁
            }


        }
    }
}
public class ThreadSync05 {
    public static void main(String[] args) {
        Window05 m = new Window05();
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();
    }
}
