package chauncy.concurrentprogramming.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class NewScheduledThreadPool {
	public static void main(String[] args) {
		// 入参为线程池大小，
		ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(5);
		// schedule执行定时任务线程池,第一个参数需要创建Runnable接口对象，第二、三个参数表示多少个单位时间执行run方法。
		newScheduledThreadPool.schedule(new Runnable() {
			public void run() {
				System.out.println("我是三秒钟之后执行。。。。");
			}
		}, 3, TimeUnit.SECONDS);
	}
}
