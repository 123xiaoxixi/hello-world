package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 21:28
 */
class Windows03 extends Thread{
    private static int tickets = 100;
    public Windows03(String name){
        super(name);
    }
    @Override
    //方法二：同步代码块
    public void run() {
        while(true){
            synchronized (Windows03.class){ //使用类对象作为同步锁
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

    }

}
public class ThreadSync03 {
    public static void main(String[] args) {
        Windows03 t1 = new Windows03("window_1");
        Windows03 t2 = new Windows03("window_2");
        Windows03 t3 = new Windows03("window_3");
        t1.start();
        t2.start();
        t3.start();
    }
}
