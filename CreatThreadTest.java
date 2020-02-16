package lesson1;

/**
 * Author: lisiyu
 * Created: 2020/2/14
 */
public class CreatThreadTest {
    public static void main(String[] args) {
        MyThread thread = new MyThread("我的线程");
        thread.start();    // 启动的子线程和主线程是同时进行的
        // thread.run();   // 一直在 run()方法中循环，没有退出
        // main 主线程 (java级别) 结束，子线程运行

        // thread.start();
        // 一个线程只能启动一次

        while (true) {}
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        // System.out.println(Thread.currentThread().getName());
        while (true) {}
    }
}