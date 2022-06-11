package com.xx.thread;

/**
 * @author lsr
 * @create 2022-06-11 22:37
 * 生产者消费者模型
 */
class Goods{
    private int num=0;

    public synchronized void product() {
        if(num<20){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"start product "+ num);
            notify();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void consume() {
        if(num>0){
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+"start consume "+num);
            num--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Producer extends Thread{
    private Goods goods;
    public Producer(Goods g){
        goods = g;
    }

    @Override
    public void run() {
        while(true){
            goods.product();
        }
    }
}
class Consumer extends Thread{
    private Goods goods;
    public Consumer(Goods g){
        goods = g;
    }

    @Override
    public void run() {
        while(true){
            goods.consume();
        }
    }
}
public class ProductAndConsume {
    public static void main(String[] args) {
        Goods good = new Goods();
        Producer p = new Producer(good);
        Consumer c = new Consumer(good);
        p.setName("Producer");
        c.setName("Consumer");
        p.start();
        c.start();
    }
}
