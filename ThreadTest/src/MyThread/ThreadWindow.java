package MyThread;

/**
 * @author lsr
 * @create 2022-09-18 22:14
 */
class WindowTest extends Thread{
    private static int ticket = 100;
    @Override
    public void run() {
        while(true) {
            System.out.println(ticket);
            ticket--;
            if(ticket<=0)
                break;
        }
    }
}
public class ThreadWindow {
    public static void main(String[] args) {
        WindowTest t1 = new WindowTest();
        WindowTest t2 = new WindowTest();
        WindowTest t3 = new WindowTest();
        t1.start();
        t2.start();
        t3.start();

    }
}
