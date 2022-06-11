package com.xx.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author lsr
 * @create 2022-06-11 22:55
 * 创建线程:使用Callable接口创建线程
 * 优点：可以有返回值，可以抛出异常
 */
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int num=0;
        for(int i = 1;i <= 100;i++){
            if(i %2 == 0 )
                num += i;
        }
        return num;
    }
}
public class ThreadCreate03 {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();
        FutureTask futureTask = new FutureTask(numThread);
        new Thread(futureTask).start();
        try {
            Object obj = futureTask.get();
            System.out.println(obj);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
