package com.xx.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lsr
 * @create 2022-06-11 23:17
 * 使用线程池创建线程
 * 优点：1.提高响应速度
 *      2.降低资源消耗
 *      3.便于线程管理
 */
class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(i % 2 ==0)
                System.out.println(Thread.currentThread().getName() + ": "+i);
        }
    }
}
class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(i % 2 !=0)
                System.out.println(Thread.currentThread().getName() + ": "+i);
        }
    }
}
public class ThreadCreate04 {
    public static void main(String[] args) {
        //1.提供指定线程数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(2);
        //2.执行指定的线程操作
        service.execute(new NumberThread());
        service.execute(new NumberThread1());
        //3.关闭连接池
        service.shutdown();
    }
}
