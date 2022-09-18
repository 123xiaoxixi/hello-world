package MyThread;

/**
 * @author lsr
 * @create 2022-09-18 21:20
 */

/**
 * 1.setName():设置当前线程名
 * 2.getName():获取当前线程名
 * 3.currentThread():Thread类中静态方法，返回当前类
 * 4.yield():释放当前线程的CPU占有权
 * 5.join():调用join的对象线程直接占有CPU，直到执行完毕后再释放CPU，当前线程进入阻塞状态
 * 6.sleep():让当前线程阻塞一段时间，时间为毫秒
 * 7.isAlive():判断线程是否还是存活的
 * 8.优先级：MAX_PRORITY=10,MIN_PRORITY=0
 *   setPrority():设置优先级
 *   getPrority():获取优先级
 */
class MyThread1 extends Thread{
    @Override
    public void run() {
        System.out.println();
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(getName() + ":" + i);
            }
//            if(i % 10 == 0){
//                Thread.yield();
//            }
        }
    }
}

public class ThreadMethod {
    public static void main(String[] args) {
        MyThread1 t1 = new MyThread1();
        t1.setPriority(Thread.MAX_PRIORITY);
        t1.setName("hhh");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        t1.start();
        for (int i = 0; i < 100; i++) {
            if(i % 2 != 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
//            if(i == 3){
//                try {
//                    System.out.println(t1.isAlive());
//                    t1.join();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
        }

    }
}
