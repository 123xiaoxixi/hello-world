package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 21:59
 * wait():一旦执行，线程进入阻塞状态并释放同步监视器，这三个函数的调用者必须和同步监视器对象保持一致
 * notify():一旦执行，会唤醒一个wait()的线程(优先级高的优先唤醒)
 * notifyAll():一旦执行，唤醒所有wait线程
 * sleep()和wait()比较：
 * 相同点:都可以使线程进入阻塞状态
 * 不同点：1.sleep()定义在Thread类中，wait()定义在Object类中
 *        2.调用要求不同，sleep可以在任何地方调用，wait()只能在同步代码块和同步方法中调用
 *        3.sleep()不会释放同步监视器，wait()会释放同步监视器
 */
class Number implements Runnable{
    private int number = 1;
    @Override
    public void run() {
        while(true){
            synchronized (this) {
                notify();
                if (number <= 100) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else
                    break;
            }
        }
    }
}
public class ThreadCommunication01 {
    public static void main(String[] args) {
        Number n = new Number();
        Thread t1 = new Thread(n);
        Thread t2 = new Thread(n);
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}
