package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 21:24
 */
class Method implements Runnable{
    private int tickets = 100;
    Object obj = new Object();
    @Override
    public void run() {
        while(true){
            test();
        }
    }
    private synchronized void test(){
        if (tickets > 0) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + ":" + tickets);
            tickets--;
        }
    }
}
public class ThreadSync02 {
    public static void main(String[] args) {
        Method m = new Method();
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();

    }
}
