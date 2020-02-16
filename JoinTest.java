package lesson1;

/**
 * Author: lisiyu
 * Created: 2020/2/14
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {

        // 匿名内部类
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(i);
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
        // 当前线程（代码所在线程 main）阻塞，直到 t 线程执行完毕
         t.join();
        // 当前线程（代码所在线程 main）阻塞，直到 t 线程执行完毕,或给定时间已经到了(两者的最小时间)
        // t.join(300000);
        // t.join(300);
        System.out.println("main");
    }
}
