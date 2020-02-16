package lesson1;

import java.util.Date;

/**
 * Author: lisiyu
 * Created: 2020/2/14
 */
public class SleepTest {
    public static void main(String[] args) throws InterruptedException {
        // 日期类：1970-01-01 00:00:00 到当前时间经历的毫秒数
//        Date data = new Date();
//        long current = data.getTime();
//        long c = System.currentTimeMillis();
        Thread.sleep(5000); // 作用在 main 线程
        Thread t =new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i =0; i < 10000000; i++) {
                        System.out.println(i);
                        Thread.sleep(1000);  // 作用在 new 线程
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // 所有非守护线程都结束，进程才结束
        // t.setDaemon(true);

        t.start();

        // JVM在操作系统创建一个线程，并申请CPU调度,是有时间消耗的。
//        Thread.sleep(3000);
//        System.out.println("main");

    }
}
