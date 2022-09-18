package MyThread;

/**
 * @author lsr
 * @create 2022-09-18 21:15
 */

/**
 * 用匿名对象的方式创建子线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
    }
}
