package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 21:32
 */
class Method04 implements Runnable{
    private int tickets = 100;
    @Override
    public void run() {
        while(true){
            synchronized (this){
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
    }
}
public class ThreadSync04 {
    public static void main(String[] args) {
        Method04 m = new Method04();
        new Thread(m).start();
        new Thread(m).start();
        new Thread(m).start();

    }
}
