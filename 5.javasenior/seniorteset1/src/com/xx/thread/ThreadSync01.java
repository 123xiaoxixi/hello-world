package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 21:19
 */
class Windows01 extends Thread{
    private static int tickets = 100;
    public Windows01(String name){
        super(name);
    }
    @Override
    public void run() {
        while(true){
            test();
        }

    }
    //方法一：同步方法
    private static synchronized void test(){
        if(tickets>0){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+":"+tickets);
            tickets--;
        }
    }
}
public class ThreadSync01 {
    public static void main(String[] args) {
        Windows01 t1 = new Windows01("window_1");
        Windows01 t2 = new Windows01("window_2");
        Windows01 t3 = new Windows01("window_3");
        t1.start();
        t2.start();
        t3.start();
    }
}
