package chauncy.concurrentprogramming.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewCachedThreadPool {
	public static void main(String[] args) {
		// 创建可缓存线程池
		ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
		// 执行execute方法表示创建了一个线程，类似于start
		for (int i = 0; i < 30; i++) {
			int index = i;
			// index++;
			newCachedThreadPool.execute(new Runnable() {

				@Override
				public void run() {
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
					}
					// 内部类中使用的i必须是final,但是换成index后就不报错，因为jdk1.8进行了优化，能识别index是否被改变，如果把int
					// index=i;下边的index++放开就会报错。
					System.out.println(Thread.currentThread().getName() + "----" + index);
				}
			});
		}
		// 关闭线程池
		newCachedThreadPool.shutdown();
	}
}
