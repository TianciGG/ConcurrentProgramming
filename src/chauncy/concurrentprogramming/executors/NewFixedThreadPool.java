package chauncy.concurrentprogramming.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewFixedThreadPool {
	public static void main(String[] args) {
		// newFixedThreadPool 每次最多只能执行三个，其他线程等待执行。
		ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			int index = i;
			newFixedThreadPool.execute(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
					}
					System.out.println(Thread.currentThread().getName() + "----i:" + index);
				}
			});
		}
	}
}
