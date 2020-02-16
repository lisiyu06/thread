package lesson1;

/**
 * Author: lisiyu
 * Created: 2020/2/14
 */
public class CreatRunnableTest {
    public static void main(String[] args) {
        Thread t = new Thread(new MyRunnable(), "我的线程");
        t.start();
        System.out.println("main 方法中：" + Thread.currentThread().getName());
    }

}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable 中：" + Thread.currentThread().getName());
    }
}