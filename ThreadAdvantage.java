package lesson1;

/**
 * Author: lisiyu
 * Created: 2020/2/14
 */
public class ThreadAdvantage {

    private static final long NUM = 10_0000_0000L;

    // 获取处理器的核数量
    // 不是线程越多越好，CPU 会有调度不过来的情况
    // 一般使用 CPU 的核数来运行，效率比较高(峰值)
    private static final int COUNT = Runtime.getRuntime().availableProcessors();

    // 串行
    public static void serial() {
        for (int i = 0; i < NUM; i++) {
            i++;
        }
    }
    // 并行，多线程
    public static void parallel() {
        for (int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    serial();
                }
            }).start();
        }
    }
    public static void main(String[] args) {
        long start1 = System.currentTimeMillis();
        serial();
        serial();
        long end1 = System.currentTimeMillis();
        System.out.println("串行：" + (end1 - start1) + "毫秒");

        long start2 = System.currentTimeMillis();
        parallel();
        while (Thread.activeCount() > 1) {
            // 等待，因为 main 线程还在执行，会一直往下进程，影响计时，此时必须使 parallel() 运行完毕
            // 即为 ：等待 活跃线程数 为 1，再向下执行
            // 使用 debug 方式启动
            Thread.yield();
        }
        parallel();
        long end2 = System.currentTimeMillis();
        System.out.println("并行：" + (end2 - start2) + "毫秒");
    }
}
