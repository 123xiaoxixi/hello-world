package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 20:38
 */
class Mthread02 implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class ThreadCreate02 {
    public static void main(String[] args) {
        Mthread02 m1 = new Mthread02();
        new Thread(m1).start();
        new Thread(m1).start();
    }
}
