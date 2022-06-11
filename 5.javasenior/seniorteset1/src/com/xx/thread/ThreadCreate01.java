package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 20:35
 * 方法一：通过继承Thread类重写run()方法创建两个线程
 */
class Mthread01 extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
public class ThreadCreate01 {
    public static void main(String[] args) {
        Mthread01 m1 = new Mthread01();
        Mthread01 m2 = new Mthread01();
        m1.start();
        m2.start();
    }
}
